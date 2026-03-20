package hash;

import java.util.*;

/*
[문제 해석]
1. 기존에 제공하던 단품메뉴들을 조합해서 새로운 코스요리 메뉴를 구성하려 합니다.
2. 각 손님들이 주문한 단품메뉴들 중에서 "가장 많이 함께 주문된" 단품메뉴들을 코스요리 메뉴로 구성합니다.
3. 단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성되어야 하며, 
   최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합이어야 합니다.

[입력 정규화]
- orders: 각 손님이 주문한 단품메뉴들이 담긴 문자열 배열 (2 ~ 20)
- course: 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 (1 ~ 10)
- 결과: 구성된 코스요리 메뉴들을 오름차순 정렬하여 리턴

[전략]
1. 각 course의 요리 갯수별로 가능한 모든 조합을 생성합니다. (Backtracking/Combination)
2. 생성된 각 조합이 orders에서 몇 번 등장했는지 카운팅합니다. (HashMap)
3. 각 요리 갯수별로 "최대 빈도"를 가진 조합들을 선별합니다. (단, 빈도는 2 이상)
4. 최종 결과를 정렬하여 반환합니다.

*/

public class MenuRenewalSolution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        // 여기에 용사님의 논리를 펼쳐주십시오.

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }
}
