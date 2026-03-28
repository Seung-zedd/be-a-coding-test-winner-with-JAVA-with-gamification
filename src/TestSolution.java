import java.util.*;

public class TestSolution {
    public static void main(String[] args) {
        // [오늘의 퀘스트] 복습 2회차 개시
        testMenuRenewal();
    }

    private static void testMenuRenewal() {
        hash.MenuRenewalSolution solver = new hash.MenuRenewalSolution();
        System.out.println("\n--- [복습 2회차] 메뉴 리뉴얼 (Menu Renewal) ---");

        String[][] ordersArr = {
                { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" },
                { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" },
                { "XYZ", "XWY", "WXA" }
        };
        int[][] courseArr = {
                { 2, 3, 4 },
                { 2, 3, 5 },
                { 2, 3, 4 }
        };
        String[][] expectedArr = {
                { "AC", "ACDE", "BCFG", "CDE" },
                { "ACD", "AD", "ADE", "CD", "XYZ" },
                { "WX", "XY" }
        };

        for (int i = 0; i < ordersArr.length; i++) {
            String[] result = solver.solution(ordersArr[i], courseArr[i]);
            System.out.println("Test Case " + (i + 1) + ": " +
                    (Arrays.equals(result, expectedArr[i]) ? "PASS ✅" : "FAIL ❌"));
            System.out.println("  Expected: " + Arrays.toString(expectedArr[i]));
            System.out.println("  Actual:   " + Arrays.toString(result));
        }

        System.out.println("\n전장 세팅 완료. 백지 위에서 검을 휘두르십시오.");
    }
}
