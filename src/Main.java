import array.MockTestSolution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MockTestSolution m = new MockTestSolution();
        System.out.println(Arrays.toString(m.solution(new int[] { 1, 2, 3, 4, 5 })));
        System.out.println(Arrays.toString(m.solution(new int[] { 1, 3, 2, 4, 2 })));
    }
}