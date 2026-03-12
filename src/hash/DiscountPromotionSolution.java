package hash;

import java.util.*;

/*
[문제 해석]
XYZ 마트는 일정한 금액을 지불하면 10일 동안 회원 자격을 부여합니다. 
-> if 일정한 금액 지불: 회원 자격 부여(10일)

XYZ 마트에서는 회원을 대상으로 매일 한 가지 제품을 할인하는 행사를 합니다. 할인하는 제품은 하루에 하나씩만 구매할 수 있습니다. 
-> 제품을 할인 && 하나씩만 판매

알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 **10일 연속**으로 일치할 경우에 맞춰서 회원가입을 하려 합니다.
-> for i in range(10):
    if <제품, 수량> 할인하는 날짜와 일치:
        return 회원가입

[제한사항]
1. 1 ≤ want의 길이 = number의 길이 ≤ 10
    1.1. 1 ≤ number의 원소 ≤ 10
    1.2. number[i]는 want[i]의 수량을 의미하며, number의 원소의 합은 10입니다.
    -> 해시맵<want, number>로 만들라는 의미

2. 10 ≤ discount의 길이 ≤ 10^5
3. want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열입니다.
    3.1. 1 ≤ want의 원소의 길이, discount의 원소의 길이 ≤ 12

[코드 설계]
1. 먼저 해시맵 초기화
2. discount에서 10일 연속하는 것을 해시맵과 매칭하기 위해 discount를 슬라이딩 윈도우 기법을 사용해야함. (e.g. 3~12일, 4~13일, 5~14일은 O.K)
    2.1. discount의 10일 간격을 두고, 0 <= idx < 10, 1 <= idx < 11, ... 10^5 - 10 <= idx < discount.length() for문을 돌려야하는데, 최대 10^5까지 가능하기 때문에, 하나의 for문만 사용해야함


*/

public class DiscountPromotionSolution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 1. 정현이가 원하는 고정된 품목 지도를 만듭니다. ( wantMap )
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 2. 현재 10일간의 현황판을 만듭니다. ( windowMap )
        Map<String, Integer> windowMap = new HashMap<>();
        // 3. [초기 세팅] 첫 10일(0~9)을 현황판에 기록합니다.
        for (int i = 0; i < 10; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
        }

        // 4. 첫 10일치가 완벽히 일치하는지 확인합니다.
        if (wantMap.equals(windowMap))
            answer++;

        // 5. [본격 슬라이딩] 10일차부터 끝까지 '나가는 놈'과 '들어오는 놈'만 처리합니다.
        for (int i = 10; i < discount.length; i++) {
            // A) 나가는 놈 처리 (i - 10일차 제품)
            String outItem = discount[i - 10];
            int outCount = windowMap.get(outItem);

            if (outCount == 1) {
                windowMap.remove(outItem); // 수량이 0이 되면 맵에서 완전히 제거해야 equals가 작동함
            } else {
                windowMap.put(outItem, outCount - 1);
            }
            // B) 들어오는 놈 처리 (i일차 제품)
            String inItem = discount[i];
            windowMap.put(inItem, windowMap.getOrDefault(inItem, 0) + 1);
            // C) 검증: 지도가 현황판과 일치하는가?
            if (wantMap.equals(windowMap))
                answer++;
        }
        return answer;
    }
}
