import java.util.*;

public class TestSolution {
    public static void main(String[] args) {
        // [오늘의 퀘스트] [복습 1회차] 트리 순회 (트리)
        // testTreeTraversal();

        // [오늘의 퀘스트] [복습 5회차] 괄호 회전하기 (마스터 도전)
        testValidParenthesisLeftRotate();

        // [오늘의 퀘스트] [문제 26] 예상 대진표 (신규)
        // testExpectedTournament();
    }

    private static void testTreeTraversal() {
        tree.TreeTraversalSolution solver = new tree.TreeTraversalSolution();
        System.out.println("\n--- [복습 1회차] 트리 순회 (Tree Traversal) ---");

        int[] nodes = { 1, 2, 3, 4, 5, 6, 7 };
        String[] expected = {
                "1 2 4 5 3 6 7", // 전위
                "4 2 5 1 6 3 7", // 중위
                "4 5 2 6 7 3 1" // 후위
        };

        String[] result = solver.solution(nodes);
        boolean pass = true;

        if (result == null || result.length < 3) {
            System.out.println("Result: FAIL ❌ (Output is null or wrong size)");
            return;
        }

        for (int i = 0; i < 3; i++) {
            String res = result[i] == null ? "null" : result[i];
            System.out.println("Result " + (i + 1) + ": " + (expected[i].equals(res) ? "PASS ✅" : "FAIL ❌"));
            System.out.println("  Expected: " + expected[i]);
            System.out.println("  Actual:   " + res);
            if (!expected[i].equals(res))
                pass = false;
        }

        if (pass) {
            System.out.println("\n모든 순회 루트를 확보했습니다. 트리 차원의 주인이 되셨군요!");
        } else {
            System.out.println("\n순회 경로에 차원이 어긋나 있습니다. 로직을 재검토하십시오.");
        }
    }

    private static void testValidParenthesisLeftRotate() {
        stack.ValidParenthesisLeftRotateSolution solver = new stack.ValidParenthesisLeftRotateSolution();
        System.out.println("\n--- [복습 5회차] 괄호 회전하기 (Valid Parenthesis Left Rotate) ---");

        String s = "[](){}";
        int expected = 3;
        int result = solver.solution(s);

        System.out.println("Result: " + (expected == result ? "PASS ✅" : "FAIL ❌"));
        System.out.println("  Expected: " + expected);
        System.out.println("  Actual:   " + result);
    }

    private static void testExpectedTournament() {
        tree.ExpectedTournamentSolution solver = new tree.ExpectedTournamentSolution();
        System.out.println("\n--- [문제 26] 예상 대진표 (Expected Tournament) ---");

        int n = 8;
        int a = 4;
        int b = 7;
        int expected = 3;
        int result = solver.solution(n, a, b);

        System.out.println("Result: " + (expected == result ? "PASS ✅" : "FAIL ❌"));
        System.out.println("  Expected: " + expected);
        System.out.println("  Actual:   " + result);
    }
}
