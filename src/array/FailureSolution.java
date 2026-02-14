package array;

import java.util.*;

/*
 * [재도전 퀘스트: 실패율 던전 공략]
 * 1. 도전자 집계: stages 배열을 딱 한 번만 순회하여 각 스테이지별 탈락자 수를 구하세요. (O(M))
 * 2. 실패율 계산: 1번~N번 스테이지를 순회하며 실패율을 구하고 Map에 저장하세요. (O(N))
 * - 현재 스테이지의 도달자 수는 이전 스테이지 탈락자를 순차적으로 뺀 값입니다.
 * 3. 복합 정렬: 저장된 데이터를 정렬 규칙에 맞게 정렬한 후 스테이지 번호만 배열로 반환하세요.
 */

public class FailureSolution {
    public int[] solution(int N, int[] stages) {
        
        // 1번 매핑
        int[] challengers = new int[N + 2];
        for (int s : stages) {
            challengers[s]++;
        }

        // 2번 매핑
        Map<Integer, Double> failureMap = new HashMap<>();
        double total = stages.length;
        for (int i = 1; i < N + 1; i++) {
            if (total == 0) {
                failureMap.put(i, 0.0);
            } else {
                failureMap.put(i, (double) challengers[i] / total);
                total -= challengers[i];
            }
        }

        // 3번 매핑
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(failureMap.entrySet());

        entryList.sort((e1, e2) -> {
            // 실패율 내림차순
            int res = Double.compare(e2.getValue(), e1.getValue());

            // 실패율이 같다면 스테이지 번호 오름차순 정렬
            // ! 중괄호 블럭은 실행 블록이라고 컴파일러가 판단하기 때문에 반드시 리턴값을 명시해줘야함!
            if (res == 0) {
                return Integer.compare(e1.getKey(), e2.getKey());
            } else {
                return res;
            }
        });

        // ? [문법 단서 1] Comparator의 리턴: 음수는 "그대로", 양수는 "바꾸기", 0은 "같음"을 신호한다.
        // ? [문법 단서 2] mapToInt(Map.Entry::getKey): 엔트리 상자에서 키(스테이지 번호)만 쏙 빼내는 마법!
        // ! 주의: 나누기 연산 시 피연산자 중 최소 하나는 double이어야 소수점이 보존된다는 것을 잊지 말자.

        return entryList.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}
