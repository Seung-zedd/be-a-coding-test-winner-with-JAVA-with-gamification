package stack;

import java.util.*;

public class DecimalBinarySolution {
    public static String solution(int decimal) {
        // 10진수 -> 2진수의 답은 LIFO라 스택을 사용
        Stack<Integer> s = new Stack<>();

        while (decimal >= 1) {
            s.push(decimal % 2);
            decimal /= 2;
        }

        StringBuilder str = new StringBuilder();
        // + 연산자에서 피연산자가 str이면 내부적으로 StringBuilder.append()를 호출
        while (!s.isEmpty()) {
            str.append(s.pop());
        }

        return str.toString();
    }
}
