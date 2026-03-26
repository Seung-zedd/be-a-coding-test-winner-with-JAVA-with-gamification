package hash;

import java.util.*;
import java.util.stream.*;

/*
[문제 해석]
(정리) 코스요리: 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들 && 최소 2가지 이상의 단품메뉴로 구성 && 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합(//? 최대 빈도(Max Frequency) 탐색, 즉 2가지 이상의 백트래킹 조합을 한 결과를 countMap으로 집계한 후, 나중에 value가 2 이상일 때만 result 리스트에 삽입) 

(각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)
-> 26가지

<param>
orders: 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열
// -> 각 손님들은 인덱스로 구분
-> 신고 결과 문제와 비슷하게 조합 횟수로 옵저버 패턴으로 변경!

course: "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열
-> 백트래킹 조합의 가지 수 

요구사항: "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return

<제한사항>
1. 2 <= orders.length <= 2 * 10
2. 2 <= orders[i] <= 10
    2.1. 각 문자열은 알파벳 대문자로만 이루어져 있습니다.
    2.2. 각 문자열에는 같은 알파벳이 중복해서 들어있지 않습니다.

3. 1 <= course.length <= 10
    3.1. 2 <= course[i] 오름차순 정렬 <= 10
    3.2. course[i]는 unique

4. 정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 -> "사전 순으로 오름차순 정렬"해서 return
    4.1. 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
    4.2. 만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return 하면 됩니다.
    -> //?
    4.3. orders와 course 매개변수는 return 하는 배열의 길이가 1 이상이 되도록 주어집니다.

*/

public class MenuRenewalSolution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        // course를 순회하면서 단품메뉴 조합 가지 수 탐색
        for (int i : course) {
            for (String order : orders) {
                // 내부 오름차순 정렬을 하기 위해 먼저 toCharArray로 변환
                char[] beOrdered = order.toCharArray();
                Arrays.sort(beOrdered);
                String ordered = String.valueOf(beOrdered); // 다시 String으로 변환

                // 백트래킹 조합
                // 2^10 
                List<String> result = combine(ordered, i);

                // 분할 및 소집
                for (String r : result) {
                    // 집계
                    countMap.merge(r, 1, Integer::sum);
                }
            }
            // 최대 빈도수 탐색 && value >= 2로 검증
            int maxValue = Integer.MIN_VALUE;
            for (Integer v : countMap.values()) {
                maxValue = Math.max(maxValue, v);
            }

            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == maxValue && entry.getValue() >= 2) {
                    answer.add(entry.getKey());
                }
            }
            // 가지 수가 바뀔 때마다 초기화
            countMap.clear();
        }

        // 외부 오름차순 정렬
        Collections.sort(answer);

        return answer.stream().toArray(String[]::new);
    }

    private List<String> combine(String ordered, int k) {
        List<String> ans = new ArrayList<>();
        List<Character> curr = new ArrayList<>();

        combineHelper(ordered, ans, curr, k, 0);

        return ans;
    }

    private void combineHelper(String ordered, List<String> ans, List<Character> curr, int k, int start) {
        // base condition
        if (curr.size() == k) {
            ans.add(curr.stream().map(String::valueOf).collect(Collectors.joining())); // char 타입을 불변 객체인 String으로 변환해서 삽입
            return;
        }

        for (int i = start; i < ordered.length(); i++) {
            curr.add(ordered.charAt(i));
            combineHelper(ordered, ans, curr, k, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
