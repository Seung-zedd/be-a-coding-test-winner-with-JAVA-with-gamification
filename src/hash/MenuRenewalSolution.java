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
        // course를 순회하면서 단품메뉴 조합 가지 수 탐색
        // countMap은 힙 메모리 절약을 위해 지역변수로 초기화한다, but 해시맵에 저장을 하고 나면 반드시 clear()해준다.
        Map<String, Integer> countMap = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i : course) {
            // 2-Pass 전략: 먼저 해시맵으로 조합 집계
            for (String order : orders) {
                // 내부 오름차순 정렬
                char[] beOrdered = order.toCharArray();
                Arrays.sort(beOrdered);
                String ordered = String.valueOf(beOrdered);
                List<String> result = combine(ordered, i); // 백트래킹 조합(T.C.:2^10 = 1024)
                for (String r : result) {
                    countMap.merge(r, 1, Integer::sum);
                }
            }

            // 분할 및 소집
            int maxValue = Integer.MIN_VALUE;
            for (Integer v : countMap.values()) {
                maxValue = Math.max(maxValue, v);
            }

            // 2. 최대 빈도수 및 value >= 2 검증
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == maxValue && entry.getValue() >= 2) {
                    ans.add(entry.getKey());
                }
            }

            countMap.clear();
        }
        // 외부 정렬
        Collections.sort(ans);

        return ans.stream().toArray(String[]::new);
    }

    private static List<String> combine(String str, int k) {
        List<String> ans = new ArrayList<>();
        List<Character> curr = new ArrayList<>();

        combineHelper(str, ans, curr, k, 0);
        return ans;
    }

    private static void combineHelper(String str, List<String> ans, List<Character> curr, int k, int start) {
        // base condition
        if (curr.size() == k) {
            ans.add(curr.stream().map(String::valueOf).collect(Collectors.joining()));
            return; //! 명시적으로 return문을 작성하지 않으면 부모 함수로 돌아가지 않기 때문에 불필요하게 아래의 for문이 동작한다!
        }
        

        for (int i = start; i < str.length(); i++) {
            curr.add(str.charAt(i));
            combineHelper(str, ans, curr, k, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
