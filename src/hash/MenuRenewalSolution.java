package hash;

import java.util.*;
import java.util.stream.*;

/*
[문제 해석]
1. 코스요리: 손님들이 가장 많이 함께 주문한 단품메뉴 조합
2. 구성 조건: 최소 2가지 이상의 단품메뉴 & 최소 2명 이상의 손님이 주문함
3. 결과 정렬: 
   - 각 코스 구성 내 메뉴는 알파벳 오름차순 정렬
   - 최종 결과 리스트도 사전 순 오름차순 정렬
4. 중복 처리: 가장 많이 주문된 조합이 여러 개라면 모두 포함

<param>
- orders: 각 손님의 주문 내역 (String[])
- course: 코스 요리를 구성하는 메뉴 개수 (int[])

<제한사항>
- orders 길이: 2 ~ 20
- 각 order 길이: 2 ~ 10 (알파벳 대문자, 중복 없음)
- course 길이: 1 ~ 10 (2 ~ 10 사이의 값, 오름차순 정렬됨)
*/

public class MenuRenewalSolution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> countMap = new HashMap<>();
        List<String> answer = new ArrayList<>();

        // 1. course를 순회
        for (int c : course) {
            // 단품메뉴 배열을 순회
            for (String o : orders) {
                // 오름차순 정렬
                char[] beOrdered = o.toCharArray();
                Arrays.sort(beOrdered);
                String ordered = String.valueOf(beOrdered);
                List<String> result = combine(ordered, c);
                for (String r : result) {
                    countMap.merge(r, 1, Integer::sum);
                }
            }

            // 최대 빈도수 탐색 && value >= 2로 검증
            // 1. 최대 빈도수 탐색
            int maxVal = Integer.MIN_VALUE;
            for (Integer v : countMap.values()) {
                maxVal = Math.max(maxVal, v);
            }

            // 2. value >= 2 검증
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == maxVal && entry.getValue() >= 2) {
                    answer.add(entry.getKey());
                }
            }

            countMap.clear();
            Collections.sort(answer);
        }
        return answer.stream().toArray(String[]::new);
    }

    private static List<String> combine(String ordered, int r) {
        List<String> result = new ArrayList<>();
        Deque<Character> curr = new ArrayDeque<>();
        combineHelper(ordered, result, curr, r, 0);

        return result;
    }

    private static void combineHelper(String ordered, List<String> result, Deque<Character> curr, int r, int start) {
        // base condition
        if (curr.size() == r) {
            result.add(curr.stream().map(String::valueOf).collect(Collectors.joining()));
        }

        for (int i = start; i < ordered.length(); i++) {
            char c = ordered.charAt(i);
            curr.addLast(c); // push()
            combineHelper(ordered, result, curr, r, i + 1); // 잠수
            curr.removeLast(); // pop()
        }
    }
}
