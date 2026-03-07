package queue;

import java.util.*;

public class CardDeckSolution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 먼저 카드들을 순서대로 한 장씩 사용하기 위해 큐로 초기화한다. 단, 인터페이스의 유용성을 위해 Deque를 사용
        Deque<String> d1 = new ArrayDeque<>();
        Deque<String> d2 = new ArrayDeque<>();

        for (String c1 : cards1) {
            d1.offer(c1);
        }

        for (String c2 : cards2) {
            d2.offer(c2);
        }

        // goal을 순회
        for (String g : goal) {
            if (!d1.isEmpty() && (d1.peek().equals(g))) {
                d1.poll();
                continue;
            } else if (!d2.isEmpty() && (d2.peek().equals(g))) {
                d2.poll();
                continue;
            } else {
                return "No";
            }
        }
        // goal의 모든 단어를 다 찾았다면, 카드 뭉치에 잔여물이 있더라도 성공!
        // ! "2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이"
        return "Yes";
    }
}
