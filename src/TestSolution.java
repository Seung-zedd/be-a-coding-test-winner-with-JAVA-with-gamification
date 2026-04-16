import java.util.Arrays;
import tree.SheepAndWolfSolution;

public class TestSolution {
    public static void main(String[] args) {
        testSheepAndWolf();
    }

    private static void testSheepAndWolf() {
        SheepAndWolfSolution sol = new SheepAndWolfSolution();
        System.out.println("\n--- [문제 28] Sheep and Wolf Test ---");

        // Case 1
        int[] info1 = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
        int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
                { 4, 6 }, { 8, 9 } };
        int result1 = sol.solution(info1, edges1);
        int expected1 = 5;
        System.out.println("Case 1: " + (result1 == expected1));
        if (result1 != expected1) {
            System.out.println("  Expected: " + expected1);
            System.out.println("  Actual:   " + result1);
        }

        // Case 2
        int[] info2 = { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0 };
        int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 7 }, { 4, 8 }, { 5, 9 },
                { 9, 10 } };
        int result2 = sol.solution(info2, edges2);
        int expected2 = 5;
        System.out.println("Case 2: " + (result2 == expected2));
        if (result2 != expected2) {
            System.out.println("  Expected: " + expected2);
            System.out.println("  Actual:   " + result2);
        }
    }
}
