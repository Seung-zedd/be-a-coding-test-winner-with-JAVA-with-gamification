package hash;

import java.util.*;
import java.util.stream.*;

/*
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
-> 이중 for문도 가능하다는 의미...? but lazy eval 기법을 써서 N-pass를 사용할꺼임

4. 장르 종류는 10^2개 미만입니다.
-> 중복되는 장르가 있을 수도 있다는 의미, 따라서 해시맵을 써서 merge(Integer::sum)을 한다.

5. 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.

6. 모든 장르는 재생된 횟수가 다릅니다.
-> 위의 4번과 매핑되는데, 장르의 Key는 중복되지만, 재생 횟수인 Value는 다르다는 의미
*/

public class BestAlbumSolution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르 별 내림차순 정렬
        // 1-Pass: 장르 별 노래횟수만 집계
        Map<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            genreMap.merge(genres[i], plays[i], Integer::sum);
        }

        // 2-Pass: 장르 별 (고유번호, 노래횟수)를 저장하기 위한 해시맵
        // ! 해시맵에 다시 넣으면, 기존의 0번 곡 데이터가 2번 곡 데이터로 Overwrite되기 때문에 Value는 반드시 물리적 메모리 주소를
        // 추상화한 List<int[]>를 사용해야 한다!
        Map<String, List<int[]>> musicMap = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            musicMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[] { i, plays[i] }); // idx, 노래횟수
        }

        // ? 1. HashMap은 순서가 없으므로 ArrayList로 변환하여 정렬(정렬은 순서가 있음을 전제)
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreMap.entrySet());

        // ? 2. Value 내림차순 정렬
        genreList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // 2. 장르 내 재생횟수 내림차순 정렬
        // 정렬된 genreList를 가져와서 key값으로 musicMap을 가져와서 내림차순 정렬을 한다.

        // 장르 종류는 10^2개 미만이기 때문에 2중 for문 사용이 가능!(왜냐하면 1-Pass에서 중복되는 장르는 집계했기 때문)
        // 고유 번호를 담을 리스트 생성
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genreList) {
            String key = entry.getKey();
            List<int[]> musicList = musicMap.get(key);
            musicList.sort((m1, m2) -> {
                // 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
                // ! compare 함수는 반드시 리턴값이 존재해야 한다.
                if (m1[1] == m2[1]) {
                    return Integer.compare(m1[0], m2[0]);
                } else {
                    return Integer.compare(m2[1], m1[1]);
                }
            });

            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                answer.add(musicList.get(i)[0]); // idx 삽입
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
