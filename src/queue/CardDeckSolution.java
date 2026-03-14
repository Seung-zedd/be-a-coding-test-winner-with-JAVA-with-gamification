package queue;

import java.util.*;

public class CardDeckSolution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // [복습 4회차] 카드 뭉치
        Deque<String> d1 = new ArrayDeque<>();
        Deque<String> d2 = new ArrayDeque<>();

        // 카드를 순서대로 꺼내기 위해 덱으로 삽입
        for (String c : cards1) {
            d1.offer(c);
        }

        for (String c : cards2) {
            d2.offer(c);
        }

        // goal을 순회하면서 단어 매칭 시작
        //? 2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
        for (String g : goal) {
            if (!d1.isEmpty() && d1.peek().equals(g)) {
                d1.poll();
                continue;
            } else if (!d2.isEmpty() && d2.peek().equals(g)) {
                d2.poll();
                continue;
            }
            // d1, d2 모두에 매칭되는 단어가 없으면 No를 리턴
            return "No";
        }

        return "Yes";
    }
}
