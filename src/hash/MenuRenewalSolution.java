package hash;

import java.util.*;
import java.util.stream.*;

/*
[문제 해석]
기존에는 단품으로만 제공하던 메뉴를 "조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공"하기로 결정했습니다.
-> 단품을 조합해서 코스요리

이전에 "각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴"들을 코스요리 메뉴로 구성하기로 했습니다.(단, 코스요리 메뉴는 "최소 2가지 이상의 단품메뉴로 구성"하려고 합니다. )
-> 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴 == //? 내림차순 정렬일까?
-> 최소 2가지 이상

또한, "최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합"에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.
-> (정리) 코스요리: 가장 많이 함께 주문한 단품메뉴 && 최소 2가지 이상의 단품메뉴 조합 && 최소 2명 이상의 손님

(각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)
-> 26가지

<param>
orders: 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열
-> 각 손님들은 인덱스로 구분

course: "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열
-> //?

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

        // 1. 백트래킹을 사용해서 course[i]에 맞게 개수 조합
        // ? 조합의 2^N에서의 N은 orders[i].length를 의미하므로 2^10 = 1024
        for (int i : course) {
            // 2. 각 조합이 몇 번 발생했는지를 알기 위한 countMap
            // ? 왜냐하면 i가지 조합마다 다르게 빈도를 조사해야 하기 때문
            Map<String, Integer> countMap = new HashMap<>();
            for (String order : orders) {
                // order -> char[]로 변경
                char[] beOrdered = order.toCharArray();
                // 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
                //? 하나의 조합 키로 통일하여 집계하기 위해 내부 정렬(e.g. "XY" == "YX")
                Arrays.sort(beOrdered); 
                // char[] -> String
                String ordered = String.valueOf(beOrdered);

                List<String> result = combine(ordered, i);
                for (String r : result) {
                    countMap.merge(r, 1, Integer::sum);
                }
            }

            // 최대 빈도 수 탐색
            int maxValue = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                maxValue = Math.max(entry.getValue(), maxValue);
            }
            // 최소 2인 이상 검증
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                // 조합의 빈도 수가 2인 이상이면서 가장 많이 주문한 조합
                //! if (maxValue >= 2)만 작성하면 2 미만 이더라도 entry의 조합들이 저장될 수가 있어서 논리적 오류 발생!
                if (maxValue >= 2 && entry.getValue() == maxValue) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer); // 정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return
        return answer.stream().toArray(String[]::new);
    }

    // 백트래킹 템플릿
    private static List<String> combine(String order, int r) {
        // 답변 리스트 초기화
        List<String> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), order, ans, 0, r);
        return ans;
    }

    private static void backtrack(List<Character> curr, String order, List<String> ans,
            int start, int r) {
        // base condition
        if (curr.size() == r) {
            ans.add(curr.stream().map(String::valueOf).collect(Collectors.joining())); // Char 타입의 curr를 String으로 매핑하는데(화살표로 매핑하는 과정), Collectors를 사용해서 concatnate를 한다
            return;
        }
        // 후보군 탐색
        for (int i = start; i < order.length(); i++) {
            curr.add(order.charAt(i)); // 선택
            backtrack(curr, order, ans, i + 1, r); // i + 1부터 다시 탐색
            curr.remove(curr.size() - 1); // 마지막 원소 제거 (backtrack)
        }
    }
}
