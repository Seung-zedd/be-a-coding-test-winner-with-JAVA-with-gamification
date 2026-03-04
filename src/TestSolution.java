import queue.JosephusSolution;
import queue.FunDevSolution;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
    
        // [신규] Function Development Quest
        testFunDev();
    }

    private static void testFunDev() {
        FunDevSolution solver = new FunDevSolution();
        System.out.println("\n--- (Function Development) ---");

        // Case 1
        int[] prog1 = { 93, 30, 55 };
        int[] speeds1 = { 1, 30, 5 };
        int[] expected1 = { 2, 1 };
        int[] result1 = solver.solution(prog1, speeds1);
        System.out.println("Test Case 1: " + (Arrays.equals(expected1, result1) ? "PASS" : "FAIL"));
        System.out.println("Result: " + Arrays.toString(result1));

        // Case 2
        int[] prog2 = { 95, 90, 99, 99, 80, 99 };
        int[] speeds2 = { 1, 1, 1, 1, 1, 1 };
        int[] expected2 = { 1, 3, 2 };
        int[] result2 = solver.solution(prog2, speeds2);
        System.out.println("Test Case 2: " + (Arrays.equals(expected2, result2) ? "PASS" : "FAIL"));
        System.out.println("Result: " + Arrays.toString(result2));
    }
}
