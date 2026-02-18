package stack;

import java.util.*;

public class ValidParenthesisLeftRotateSolution {
    public int solution(String s) {
        int answer = 0;
        // 1. s를 0 ~ s.len - 1 만큼 순회하기 위해 for문 사용
        for (int i = 0; i < s.length(); i++) {
            String str = leftLotate(i, s);
            answer += isValid(str);
        }

        return answer;
    }

    private static String leftLotate(int x, String s) {
        // x만큼 왼쪽으로 회전: x부터 끝까지 + 처음부터 x전까지
        return s.substring(x) + s.substring(0, x);
    }

    private static int isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            // 괄호 짝 매칭: !st.isEmpty()가 모든 || 조건을 보호하도록 괄호로 묶음
            //! 연산자 순서가 애매하면 괄호로 안전하게 묶자!
            if (!st.isEmpty() && ((st.peek() == '(' && c == ')') ||
                    (st.peek() == '{' && c == '}') ||
                    (st.peek() == '[' && c == ']'))) {
                st.pop();
            } else if (c == ')' || c == '}' || c == ']') {
                // 짝이 맞지 않는 닫힌 괄호가 오거나 스택이 비어있는데 닫힌 괄호가 온 경우
                return 0;
            } else {
                st.push(c);
            }
        }
        return st.isEmpty() ? 1 : 0;
    }
}
