import java.util.*;

public class TestSolution {
    public static void main(String[] args) {
        // --- 🛡️ 오늘의 수련 리스트 (Today's Quest) ---

        // [복습 3회차] 메뉴 리뉴얼 (해시) - ⚠️ 봉인 발동: 자동완성 금지
        testMenuRenewal();

        // [신규 정복] 다단계 칫솔 판매 (트리) - Lv. 20급 대규모 전장
        testMultiLevelToothbrushSales();
    }

    private static void testMenuRenewal() {
        hash.MenuRenewalSolution solver = new hash.MenuRenewalSolution();
        System.out.println("\n--- 1. [복습 3회차] 메뉴 리뉴얼 (Menu Renewal) ---");
        System.out.println("⚠️ 베테랑 룰: 자동완성이 봉인되었습니다. 백지 타이핑 역량을 증명하십시오.");

        String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        int[] course = { 2, 3, 4 };
        String[] expected = { "AC", "ACDE", "BCFG", "CDE" };
        String[] result = solver.solution(orders, course);

        System.out.println("Result: " + (Arrays.equals(expected, result) ? "PASS ✅" : "FAIL ❌"));
        System.out.println("  Expected: " + Arrays.toString(expected));
        System.out.println("  Actual:   " + Arrays.toString(result));
    }

    private static void testMultiLevelToothbrushSales() {
        tree.MultiLevelToothbrushSalesSolution solver = new tree.MultiLevelToothbrushSalesSolution();
        System.out.println("\n--- 2. [신규 정복] 다단계 칫솔 판매 (Multi-level Toothbrush Sales) ---");

        String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
        String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
        String[] seller = { "young", "john", "tod", "emily", "mary" };
        int[] amount = { 12, 4, 2, 5, 10 };
        int[] expected = { 360, 958, 108, 0, 450, 18, 180, 108 };

        int[] result = solver.solution(enroll, referral, seller, amount);

        System.out.println("Result: " + (Arrays.equals(expected, result) ? "PASS ✅" : "FAIL ❌"));
        System.out.println("  Expected: " + Arrays.toString(expected));
        System.out.println("  Actual:   " + Arrays.toString(result));
    }
}
