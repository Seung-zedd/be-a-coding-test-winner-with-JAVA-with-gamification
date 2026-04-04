package hash;

import java.util.*;

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
        return new String[0];
    }
}
