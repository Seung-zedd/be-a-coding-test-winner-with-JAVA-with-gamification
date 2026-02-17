package stack;

import java.util.*;

/*
괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻


*/

public class ValidParenthesisSolution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        // s 순회
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            // 괄호가 짝지어져있으면 팝
            if (!st.isEmpty() && st.peek() == '(' && c == ')') {
                st.pop();
                // 닫힌 괄호가 먼저 오면 false
            } else if (st.isEmpty() && c == ')') {
                return false;
            } else {
                st.push(c);
            }
        }

        return st.empty();
    }
}
