package hash;

import java.util.*;

/*
[🛡️ 2회차 복습: 베스트 앨범]
- 미션: 다조건 정렬 및 해시 매핑 수련
- 핵심: 집계(Sum)와 수집(List)의 이원화(Dual Mapping) 전술
- 제한 가혹 조건: 자동 완성 봉인 (Zero Auto-completion)

[문제 해석]
"장르 별"로 가장 많이 재생된 노래를 "두 개씩 모아" 베스트 앨범을 출시하려 합니다. 
-> 장르 별로 그룹핑 > 재생 횟수 내림차순 정렬 > 장르 별로 2개씩 모아 베스트 앨범 출시

노래는 고유 번호로 구분하며, 
-> 오픈채팅방의 userid처럼 노래도 유니크한 id가 있는듯...?

노래를 수록하는 기준은 다음과 같습니다.(재생횟수가 기준)
1. 속한 노래가 "많이 재생된 장르"를 먼저 수록합니다.
-> **장르** 별로 내림차순 정렬

2. 장르 내에서 "많이 재생된 노래"를 먼저 수록합니다.
-> 장르 내에서 **노래** 별 재생횟수 내림차순

3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
-> if (songX.재생횟수 == songY.재생횟수): **고유번호**(id) 오름차순 정렬

param: 노래의 **장르**를 나타내는 문자열 배열 genres, 노래별 **재생 횟수**를 나타내는 정수 배열 plays

요구사항: 베스트 앨범(장르 > 노래 > 고유번호 && 장르 별 max 2개)에 들어갈 노래의 고유 번호를 순서대로 return

- 제한사항-
1. genres[i]는 고유번호가 i인 노래의 장르입니다.
-> 고유번호 == 인덱스

2. plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
-> 고유번호 == 인덱스
3. genres와 plays의 길이는 같으며, 이는 1 이상 10^4 이하입니다.

4. 장르 종류는 10^2개 미만입니다.
-> 중복되는 장르가 있을 수도 있다는 의미, 따라서 해시맵을 써서 merge(Integer::sum)을 한다.

5. 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.

6. 모든 장르는 재생된 횟수가 다릅니다.
-> 위의 4번과 매핑되는데, 장르의 Key는 중복되지만, 재생 횟수인 Value는 다르다는 의미
*/

public class BestAlbumSolution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 별 내림차순 정렬을 위해 먼저 장르 별 집계
        Map<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.merge(genres[i], plays[i], Integer::sum);
        }

        // 장르별 내림차순 실행, but 순서가 있는 정렬을 하기 위해 리스트 초기화
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreMap.entrySet());
        genreList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // 장르 내 내림차순 정렬을 위한 List 수집(idx[0] = 노래 고유번호, idx[1] = 노래 횟수)
        // ! new int[]만 하면 같은 장르일 때 노래횟수가 덮어쓰일 수 있기 때문에 리스트로 별도 관리!
        Map<String, List<int[]>> musicMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            musicMap.computeIfAbsent(genres[i], key -> new ArrayList<>()).add(new int[] { i, plays[i] });
        }

        // 장르별을 순회하면서 내림차순 정렬된 키를 기준으로 다시 내림차순 정렬
        // 장르 종류는 10^2개 미만이기 때문에 이중 for문 가능!
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genreList) {
            String key = entry.getKey();

            List<int[]> musicList = musicMap.get(key);
            musicList.sort((m1, m2) -> {
                // 노래횟수가 같으면 고유번호 오름차순
                if (m1[1] == m2[1]) {
                    return Integer.compare(m1[0], m2[0]);
                } else {
                    return Integer.compare(m2[1], m1[1]);
                }
            });

            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                answer.add(musicList.get(i)[0]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
