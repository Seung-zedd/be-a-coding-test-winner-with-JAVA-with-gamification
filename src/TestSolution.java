
public class TestSolution {
    public static void main(String[] args) {
        // [복습 4회차] Quest 10 - 괄호 회전하기
        testRotationParentheses();

        // [신규] Quest 22 - 베스트 앨범
        // testBestAlbum();
    }

    private static void testRotationParentheses() {
        stack.ValidParenthesisLeftRotateSolution solver = new stack.ValidParenthesisLeftRotateSolution();
        System.out.println("\n--- [복습 4회차] (Rotation Parentheses - Quest 10) ---");

        String s1 = "[](){}";
        int expected1 = 3;
        int res1 = solver.solution(s1);
        System.out.println("Test Case 1: " + (res1 == expected1 ? "PASS" : "FAIL"));

        String s2 = "}]()[{";
        int expected2 = 2;
        int res2 = solver.solution(s2);
        System.out.println("Test Case 2: " + (res2 == expected2 ? "PASS" : "FAIL"));

        String s3 = "[)(]";
        int expected3 = 0;
        int res3 = solver.solution(s3);
        System.out.println("Test Case 3: " + (res3 == expected3 ? "PASS" : "FAIL"));

        String s4 = "}}}";
        int expected4 = 0;
        int res4 = solver.solution(s4);
        System.out.println("Test Case 4: " + (res4 == expected4 ? "PASS" : "FAIL"));
    }

    private static void testBestAlbum() {
        hash.BestAlbumSolution solver = new hash.BestAlbumSolution();
        System.out.println("\n--- [신규] (Best Album - Quest 22) ---");

        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        int[] expected = { 4, 1, 3, 0 };
        int[] res = solver.solution(genres, plays);

        if (res == null) {
            System.out.println("Test Case 1: FAIL (Result is null)");
            return;
        }

        boolean match = java.util.Arrays.equals(res, expected);
        System.out.println("Test Case 1: " + (match ? "PASS" : "FAIL"));
        if (!match) {
            System.out.println("Expected: " + java.util.Arrays.toString(expected));
            System.out.println("Actual: " + java.util.Arrays.toString(res));
        }
    }
}
