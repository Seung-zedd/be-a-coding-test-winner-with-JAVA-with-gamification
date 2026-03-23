import java.util.*;

public class TestSolution {
    public static void main(String[] args) {
        // [훈련] 오늘 정복할 퀘스트 목록
        testReportResult(); // 1. 신고 결과 받기 (2회차 복습)
        // testTableEdit();
        // testMenuRenewal();
    }

    private static void testTableEdit() {
        stack.TableEditSolution solver = new stack.TableEditSolution();
        System.out.println("\n--- [Master 도전] 표 편집 (Table Edit) ---");

        // Test Case 1
        int n1 = 8;
        int k1 = 2;
        String[] cmd1 = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
        String expected1 = "OOOOXOOO";
        String res1 = solver.solution(n1, k1, cmd1);
        System.out.println("Test Case 1: " + (expected1.equals(res1) ? "PASS" : "FAIL"));
        if (!expected1.equals(res1)) {
            System.out.println("Expected: " + expected1);
            System.out.println("Actual:   " + res1);
        }

        // Test Case 2
        int n2 = 8;
        int k2 = 2;
        String[] cmd2 = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };
        String expected2 = "OOXOXOOO";
        String res2 = solver.solution(n2, k2, cmd2);
        System.out.println("Test Case 2: " + (expected2.equals(res2) ? "PASS" : "FAIL"));
        if (!expected2.equals(res2)) {
            System.out.println("Expected: " + expected2);
            System.out.println("Actual:   " + res2);
        }
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

    private static void testReportResult() {
        hash.ReportResultSolution solver = new hash.ReportResultSolution();
        System.out.println("\n--- [복습 2회차] 신고 결과 받기 (Report Result) ---");

        // [Test Case 1]
        String[] id_list1 = { "muzi", "frodo", "apeach", "neo" };
        String[] report1 = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k1 = 2;
        int[] expected1 = { 2, 1, 1, 0 };
        int[] res1 = solver.solution(id_list1, report1, k1);
        System.out.println("Test Case 1: " + (Arrays.equals(res1, expected1) ? "PASS" : "FAIL"));
        if (!Arrays.equals(res1, expected1)) {
            System.out.println("Expected: " + Arrays.toString(expected1) + " / Actual: " + Arrays.toString(res1));
        }

        // [Test Case 2]
        String[] id_list2 = { "con", "ryan" };
        String[] report2 = { "ryan con", "ryan con", "ryan con", "ryan con" };
        int k2 = 3;
        int[] expected2 = { 0, 0 };
        int[] res2 = solver.solution(id_list2, report2, k2);
        System.out.println("Test Case 2: " + (Arrays.equals(res2, expected2) ? "PASS" : "FAIL"));
        if (!Arrays.equals(res2, expected2)) {
            System.out.println("Expected: " + Arrays.toString(expected2) + " / Actual: " + Arrays.toString(res2));
        }
    }
}
