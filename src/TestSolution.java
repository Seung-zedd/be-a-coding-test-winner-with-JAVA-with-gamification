import array.MatrixMulSolution;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        MatrixMulSolution solver = new MatrixMulSolution();

        // Test Case 1
        int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
        int[][] arr2 = { { 3, 3 }, { 3, 3 } };
        int[][] expected1 = { { 15, 15 }, { 15, 15 }, { 15, 15 } };
        int[][] result1 = solver.solution(arr1, arr2);
        printResult(1, expected1, result1);

        // Test Case 2
        int[][] arr3 = { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } };
        int[][] arr4 = { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } };
        int[][] expected2 = { { 22, 22, 11 }, { 36, 28, 18 }, { 29, 20, 14 } };
        int[][] result2 = solver.solution(arr3, arr4);
        printResult(2, expected2, result2);
    }

    private static void printResult(int n, int[][] expected, int[][] result) {
        boolean match = Arrays.deepEquals(expected, result);
        System.out.println("Test Case " + n + ": " + (match ? "PASS" : "FAIL"));
        if (!match) {
            System.out.println("  Expected: " + Arrays.deepToString(expected));
            System.out.println("  Actual:   " + Arrays.deepToString(result));
        }
    }
}
