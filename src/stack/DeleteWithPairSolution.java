package stack;

import java.util.*;

public class DeleteWithPairSolution {
    public int solution(String s) {
        // 짝 제거
        return deletePair(s) ? 1 : 0;


    }

    private static boolean deletePair(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
