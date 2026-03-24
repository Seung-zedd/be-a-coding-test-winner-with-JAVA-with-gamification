import java.util.*;

public class TestSolution {
    public static void main(String[] args) {
        // [오늘의 퀘스트] 최초 정복 도전
        testMenuRenewal();
    }

    private static void testMenuRenewal() {
        hash.MenuRenewalSolution solver = new hash.MenuRenewalSolution();
        System.out.println("\n--- [최초 정복] 메뉴 리뉴얼 (Menu Renewal) ---");

        // Test Case 1
        String[] orders1 = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        int[] course1 = { 2, 3, 4 };
        String[] expected1 = { "AC", "ACDE", "BCFG", "CDE" };
        String[] res1 = solver.solution(orders1, course1);
        System.out.println("Test Case 1: " + (Arrays.equals(res1, expected1) ? "PASS" : "FAIL"));
        if (!Arrays.equals(res1, expected1)) {
            System.out.println("Expected: " + Arrays.toString(expected1));
            System.out.println("Actual: " + Arrays.toString(res1));
        }

        // Test Case 2
        String[] orders2 = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
        int[] course2 = { 2, 3, 5 };
        String[] expected2 = { "ACD", "AD", "ADE", "CD", "XYZ" };
        String[] res2 = solver.solution(orders2, course2);
        System.out.println("Test Case 2: " + (Arrays.equals(res2, expected2) ? "PASS" : "FAIL"));
        if (!Arrays.equals(res2, expected2)) {
            System.out.println("Expected: " + Arrays.toString(expected2));
            System.out.println("Actual: " + Arrays.toString(res2));
        }
    }
}
