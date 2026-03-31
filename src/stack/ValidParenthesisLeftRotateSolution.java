package stack;

import java.util.*;
import java.util.stream.*;

/*
Valid Parenthesis + Rotate
s를 "왼쪽"으로 x 칸만큼 회전시켰을 때 올바른 괄호 문자열이 되는 x의 개수를 return
*/

public class ValidParenthesisLeftRotateSolution {
    public int solution(String s) {
        int count = 0;
        // 1. s를 순회하면서 하나씩 x칸만큼 회전
        // x는 인덱스
        for (int i = 0; i < s.length(); i++) {
            // 1-Pass: 연산
            String result = leftRotateWithX(s, i);
            // 2-Pass: 검증
            count += isValidParenthesis(result);
        }

        return count;
    }

    private static String leftRotateWithX(String s, int x) {
        Deque<Character> q = new ArrayDeque<>();
        // 먼저 q에 채운다
        for (int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }

        // x칸만큼 회전
        while (x-- > 0) {
            q.offer(q.poll());
        }
        //! q.toString()은 콤마를 넣어서 리턴
        // 대신에 stream API를 사용해서 collect(Collectors.joining())을 쓴다
        return q.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static int isValidParenthesis(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            // 스택에 이미 열린 괄호가 있고 짝이 맞으면 pop()
            if (!st.isEmpty() && ((st.peek() == '(' && c == ')') || (st.peek() == '{' && c == '}')
                    || (st.peek() == '[' && c == ']'))) {
                st.pop();
            } else if (c == ')' || c == '}' || c == ']') {
                return 0;
            } else {
                st.push(s.charAt(i));
            }
        }

        return st.size() == 0 ? 1 : 0;
    }
}
