package stack;

import java.util.*;
import java.util.stream.*;

/*
Valid Parenthesis + Rotate(=> 원형 큐로 풀을 예정)
s를 "왼쪽"으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 
-> 요세푸스 순열과 논리의 결이 똑같음! 큐는 FIFO 구조인데, q.offer(q.poll())과 일치

s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return
*/

public class ValidParenthesisLeftRotateSolution {
    public int solution(String s) {
        // 0 ≤ x < (s의 길이)로 회전하기 위해 그냥 s를 for문으로 순회
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String result = leftRotate(i, s);
            answer += validParenthesis(result);
        }
        return answer;
    }

    private static String leftRotate(int x, String s) {
        // 원형 큐 초기화
        Deque<Character> q = new ArrayDeque<>();
        // 원형 큐에 문자열 삽입
        for (int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }

        // 요세푸스 순열 응용
        for (int i = 0; i < x; i++) {
            q.offer(q.poll());
        }

        return q.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static int validParenthesis(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // 짝이 맞으면 Pop
            if (!st.isEmpty() && ((st.peek() == '(' && c == ')') ||
                    (st.peek() == '{' && c == '}') ||
                    (st.peek() == '[' && c == ']'))) {
                st.pop();
            } else if (c == ')' || c == '}' || c == ']') {
                // 짝이 맞지 않는 닫힌 괄호가 오면 즉시 실패
                return 0;
            } else {
                // 열린 괄호는 무조건 Push
                st.push(c);
            }
        }

        return st.isEmpty() ? 1 : 0;
    }
}
