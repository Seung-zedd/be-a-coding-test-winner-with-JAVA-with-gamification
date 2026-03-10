package queue;

import java.util.*;

public class CardDeckSolution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용하기 위해 큐로 초기화
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
            }
            return "No";
        }
        return "Yes";
    }
}
