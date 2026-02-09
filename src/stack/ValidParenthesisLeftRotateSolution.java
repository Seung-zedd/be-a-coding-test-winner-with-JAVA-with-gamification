package stack;

import java.util.*;

public class ValidParenthesisLeftRotateSolution {
    public int solution(String s) {
        // isEmpty()의 true 값을 카운팅하기 위한 장치 필요
        int count = 0;

        // 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때
        for (int i = 0; i < s.length(); i++) {
            // 회전을 순차적으로 하고
            count += rotateWithStreams(s, i);
        }

        return count;
    }

    /**
     *
     * @param s: 회전할 배열
     * @param k: 회전할 위치 수
     * @return
     */
    private static int rotateWithStreams(String s, int k) {
        // 왼쪽으로 1번만 회전
        //! 길지 않은 문자열 끼리는 + 연산자로 더할 수 있음
        String result = s.substring(k) + s.substring(0, k);
        // 왼쪽 회전 결과를 파라미터로 넘겨서 괄호 유효성 검사 함수 호출
        return isValidParenthesis(result) ? 1 : 0;

    }


    private static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // 열린 괄호는 무조건 푸시
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                if (s.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (s.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                }
            } else {
                // 닫힌 괄호는 매칭이 안되므로 false를 리턴
                return false;
            }
        }

        return stack.isEmpty();
    }
}


