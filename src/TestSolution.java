import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        // [훈련] 오늘 정복할 퀘스트 목록
        testBestAlbum(); // 1. 베스트 앨범 (복습 1회차 / 2회차 정복 도전)
        // testReportResult(); // 2. 신고 결과 받기 (최초 정복 도전)
    }

    private static void testBestAlbum() {
        hash.BestAlbumSolution solver = new hash.BestAlbumSolution();
        System.out.println("\n--- [복습 1회차] 베스트 앨범 (Best Album) ---");

        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        int[] expected = { 4, 1, 3, 0 };
        int[] res = solver.solution(genres, plays);

        boolean match = Arrays.equals(res, expected);
        System.out.println("Test Case 1: " + (match ? "PASS" : "FAIL"));
        if (!match) {
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(res));
        }
    }

    private static void testReportResult() {
        hash.ReportResultSolution solver = new hash.ReportResultSolution();
        System.out.println("\n--- [최초 정복] 신고 결과 받기 (Report Result) ---");

        // Test Case 1
        String[] id_list1 = { "muzi", "frodo", "apeach", "neo" };
        String[] report1 = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k1 = 2;
        int[] expected1 = { 2, 1, 1, 0 };
        int[] res1 = solver.solution(id_list1, report1, k1);
        System.out.println("Test Case 1: " + (Arrays.equals(res1, expected1) ? "PASS" : "FAIL"));

        // Test Case 2
        String[] id_list2 = { "con", "ryan" };
        String[] report2 = { "ryan con", "ryan con", "ryan con", "ryan con" };
        int k2 = 3;
        int[] expected2 = { 0, 0 };
        int[] res2 = solver.solution(id_list2, report2, k2);
        System.out.println("Test Case 2: " + (Arrays.equals(res2, expected2) ? "PASS" : "FAIL"));
    }
}
