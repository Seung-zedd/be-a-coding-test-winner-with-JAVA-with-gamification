package stack;

import java.util.*;

/*
가격이 떨어지지 않은 기간은 몇 초?
 */


public class StockPriceSolution {
    public int[] solution(int[] prices) {
        // 떨어지지 않은 텀을 담기 위한 리스트
        int[] answer = new int[prices.length];

        // 특정 조건을 체크하기 위한 컬렉션: 스택
        // s[0] = price, s[1] = idx
        Stack<int[]> s = new Stack<>();


        for (int i = 0; i < prices.length; i++) {
            // 현재 가격보다 과거의 가격이 높으면
            //! while문으로 처리해야 하는 이유: 스택에 남아있는 원소들이 현재 가격보다 계속 높을 수 있기 때문
            while (!s.isEmpty() && s.peek()[0] > prices[i]) {
                calculateTerm(s, i, answer);
            }

            s.push(new int[]{prices[i], i});
        }

        // 남아있는 스택을 처리, 즉 가격이 떨어지지 않은 주식가격들의 기간을 계산
        while (!s.isEmpty()) {
            calculateTerm(s, (prices.length - 1), answer);
        }

        return answer;
    }

    private static void calculateTerm(Stack<int[]> s, int length, int[] answer) {
        int prevSec = s.pop()[1];
        int term = length - prevSec;
        answer[prevSec] = term;
    }
}
