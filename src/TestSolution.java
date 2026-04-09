import java.util.Arrays;
import tree.ToothbrushSalesSolution;
import tree.SheepAndWolfSolution;

public class TestSolution {
    public static void main(String[] args) {
        testToothbrushSales();
        // testSheepAndWolf();
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
        int[] info2 = { 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0 };
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

    private static void testToothbrushSales() {
        ToothbrushSalesSolution sol = new ToothbrushSalesSolution();
        System.out.println("--- [복습] Toothbrush Sales Test ---");

        // Case 1
        String[] enroll1 = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] referral1 = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] seller1 = { "young", "john", "tod", "emily", "mary" };
        int[] amount1 = { 12, 4, 2, 5, 10 };
        int[] result1 = sol.solution(enroll1, referral1, seller1, amount1);
        int[] expected1 = { 360, 958, 108, 0, 450, 18, 180, 1080 };
        System.out.println("Case 1: " + Arrays.equals(result1, expected1));
        if (!Arrays.equals(result1, expected1)) {
            System.out.println("  Expected: " + Arrays.toString(expected1));
            System.out.println("  Actual:   " + Arrays.toString(result1));
        }

        // Case 2
        String[] enroll2 = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] referral2 = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] seller2 = { "sam", "emily", "jaimie", "edward" };
        int[] amount2 = { 2, 3, 5, 4 };
        int[] result2 = sol.solution(enroll2, referral2, seller2, amount2);
        int[] expected2 = { 0, 110, 378, 180, 270, 450, 0, 0 };
        System.out.println("Case 2: " + Arrays.equals(result2, expected2));
        if (!Arrays.equals(result2, expected2)) {
            System.out.println("  Expected: " + Arrays.toString(expected2));
            System.out.println("  Actual:   " + Arrays.toString(result2));
        }
    }
}
