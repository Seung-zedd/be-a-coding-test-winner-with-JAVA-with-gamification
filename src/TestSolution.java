import java.util.Arrays;
import tree.*;

public class TestSolution {
    public static void main(String[] args) {
        // [오늘의 수련 과제 세팅] - Rule 3
        testToothbrushSales(); // [복습] 2회차 (Overdue)
    }

    private static void testToothbrushSales() {
        ToothbrushSalesSolution sol = new ToothbrushSalesSolution();
        System.out.println("\n--- [문제 27] 다단계 칫솔 판매 Test (Review 2) ---");

        // 프로그래머스 정석 테케 준수 (Rule 16)
        String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] seller = { "young", "john", "tod", "emily", "mary" };
        int[] amount = { 12, 4, 2, 5, 10 };
        int[] expected = { 360, 958, 108, 0, 450, 18, 180, 1080 };

        int[] result = sol.solution(enroll, referral, seller, amount);
        System.out.println("Case 1: " + Arrays.equals(result, expected));
        if (!Arrays.equals(result, expected)) {
            System.out.println("  Expected: " + Arrays.toString(expected));
            System.out.println("  Actual:   " + Arrays.toString(result));
        }

        // Case 2
        String[] enroll2 = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] referral2 = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] seller2 = { "sam", "emily", "jaimie", "edward" };
        int[] amount2 = { 2, 3, 5, 4 };
        int[] expected2 = { 0, 110, 378, 180, 270, 450, 0, 0 };

        int[] result2 = sol.solution(enroll2, referral2, seller2, amount2);
        System.out.println("Case 2: " + Arrays.equals(result2, expected2));
        if (!Arrays.equals(result2, expected2)) {
            System.out.println("  Expected: " + Arrays.toString(expected2));
            System.out.println("  Actual:   " + Arrays.toString(result2));
        }
    }
}
