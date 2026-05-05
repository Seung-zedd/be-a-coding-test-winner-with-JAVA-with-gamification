import java.util.Arrays;
import hash.*;

public class TestSolution {
    public static void main(String[] args) {
        // [오늘의 수련 과제 세팅] - Rule 3
        testTangerineSelection(); // [정복] 신규 퀘스트 (Lv. 2)
    }

    private static void testTangerineSelection() {
        TangerineSelectionSolution sol = new TangerineSelectionSolution();
        System.out.println("\n--- [Lv. 2] 귤 고르기 Test (New Quest) ---");

        // Case 1
        int k1 = 6;
        int[] tangerine1 = { 1, 3, 2, 5, 4, 5, 2, 3 };
        int expected1 = 3;
        int result1 = sol.solution(k1, tangerine1);
        System.out.println("Case 1: " + (result1 == expected1));
        if (result1 != expected1) {
            System.out.println("  Expected: " + expected1);
            System.out.println("  Actual:   " + result1);
        }

        // Case 2
        int k2 = 4;
        int[] tangerine2 = { 1, 3, 2, 5, 4, 5, 2, 3 };
        int expected2 = 2;
        int result2 = sol.solution(k2, tangerine2);
        System.out.println("Case 2: " + (result2 == expected2));
        if (result2 != expected2) {
            System.out.println("  Expected: " + expected2);
            System.out.println("  Actual:   " + result2);
        }

        // Case 3
        int k3 = 2;
        int[] tangerine3 = { 1, 1, 1, 1, 2, 2, 2, 3 };
        int expected3 = 1;
        int result3 = sol.solution(k3, tangerine3);
        System.out.println("Case 3: " + (result3 == expected3));
        if (result3 != expected3) {
            System.out.println("  Expected: " + expected3);
            System.out.println("  Actual:   " + result3);
        }
    }
}
