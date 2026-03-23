package queue;

import java.util.*;

/*
[문제 해석]
코니는 "영어 단어"가 적힌 "카드 뭉치 두 개"를 선물로 받았습니다. 코니는 다음과 같은 규칙으로 "카드에 적힌 단어"들을 사용해 원하는 순서의 단어 배열을 만들 수 있는지 알고 싶습니다.
    원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
    한 번 사용한 카드는 다시 사용할 수 없습니다.
    카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
    기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.

*/

public class CardDeckSolution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 카드를 순서대로 뽑기 위해 덱 인터페이스 각각 초기화
        Deque<String> q1 = new ArrayDeque<>();
        Deque<String> q2 = new ArrayDeque<>();
        for (String c1 : cards1) {
            q1.offer(c1);
        }
        for (String c2 : cards2) {
            q2.offer(c2);
        }

        // goal 순회
        for (String g : goal) {
            if (!q1.isEmpty() && (q1.peek().equals(g))) {
                q1.poll();
                continue;
            } else if (!q2.isEmpty() && (q2.peek().equals(g))) {
                q2.poll();
                continue;
            }
            // q1과 q2 둘다 매칭되는 단어가 없으면
            return "No";
        }
        return "Yes";
    }
}
