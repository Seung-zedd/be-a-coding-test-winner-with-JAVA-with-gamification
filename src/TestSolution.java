import java.util.*;

public class TestSolution {
    public static void main(String[] args) {
        // --- 오늘 정복해야 할 모든 퀘스트 (복습) ---
        // 1. [복습 1회차] 예상 대진표 (트리)
        testExpectedTournament();

        // 2. [복습 3회차] 트리 순회 (트리) - 일반 자동완성 봉인 룰 적용
        // testTreeTraversal();

        // 3. [복습 3회차] 메뉴 리뉴얼 (해시) - 베테랑(3/3) 자동완성 봉인 룰 적용
        // testMenuRenewal();
    }

    private static void testExpectedTournament() {
        tree.ExpectedTournamentSolution solver = new tree.ExpectedTournamentSolution();
        System.out.println("\n--- 1. [복습 1회차] 예상 대진표 (Expected Tournament) ---");

        int n = 8;
        int a = 4;
        int b = 7;
        int expected = 3;
        int result = solver.solution(n, a, b);

        System.out.println("Result: " + (expected == result ? "PASS ✅" : "FAIL ❌"));
        System.out.println("  Expected: " + expected);
        System.out.println("  Actual:   " + result);
    }

    private static void testTreeTraversal() {
        tree.TreeTraversalSolution solver = new tree.TreeTraversalSolution();
        System.out.println("\n--- 2. [복습 3회차] 트리 순회 (Tree Traversal) ---");

        int[] nodes = { 1, 2, 3, 4, 5, 6, 7 };
        String[] expected = {
                "1 2 4 5 3 6 7", // 전위
                "4 2 5 1 6 3 7", // 중위
                "4 5 2 6 7 3 1"  // 후위
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
            System.out.println("모든 순회 루트를 확보했습니다.");
        } else {
            System.out.println("순회 경로에 차원이 어긋나 있습니다.");
        }
    }

    private static void testMenuRenewal() {
        hash.MenuRenewalSolution solver = new hash.MenuRenewalSolution();
        System.out.println("\n--- 3. [복습 3회차] 메뉴 리뉴얼 (Menu Renewal) ---");

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] expected = {"AC", "ACDE", "BCFG", "CDE"};
        String[] result = solver.solution(orders, course);

        System.out.println("Result: " + (Arrays.equals(expected, result) ? "PASS ✅" : "FAIL ❌"));
        System.out.println("  Expected: " + Arrays.toString(expected));
        System.out.println("  Actual:   " + Arrays.toString(result));
    }
}
