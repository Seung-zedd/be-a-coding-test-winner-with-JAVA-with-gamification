import java.util.Arrays;
import tree.ToothbrushSalesSolution;

public class TestSolution {
    public static void main(String[] args) {
        testToothbrushSales();
    }

    private static void testToothbrushSales() {
        ToothbrushSalesSolution sol = new ToothbrushSalesSolution();
        System.out.println("--- Toothbrush Sales Test ---");

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
