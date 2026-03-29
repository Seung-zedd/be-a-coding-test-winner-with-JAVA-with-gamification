import java.util.*;

public class TestSolution {
    public static void main(String[] args) {
        // [오늘의 퀘스트] [문제 25] 트리 순회 (트리)
        testTreeTraversal();
    }

    private static void testTreeTraversal() {
        tree.TreeTraversalSolution solver = new tree.TreeTraversalSolution();
        System.out.println("\n--- [문제 25] 트리 순회 (Tree Traversal) ---");

        int[] nodes = { 1, 2, 3, 4, 5, 6, 7 };
        String[] expected = {
                "1 2 4 5 3 6 7", // 전위
                "4 2 5 1 6 3 7", // 중위
                "4 5 2 6 7 3 1" // 후위
        };

        String[] result = solver.solution(nodes);
        boolean pass = true;

        for (int i = 0; i < 3; i++) {
            System.out.println("Result " + (i + 1) + ": " + (expected[i].equals(result[i]) ? "PASS ✅" : "FAIL ❌"));
            System.out.println("  Expected: " + expected[i]);
            System.out.println("  Actual:   " + result[i]);
            if (!expected[i].equals(result[i]))
                pass = false;
        }

        if (pass) {
            System.out.println("\n모든 순회 루트를 확보했습니다. 트리 차원의 주인이 되셨군요!");
        } else {
            System.out.println("\n순회 경로에 차원이 어긋나 있습니다. 로직을 재검토하십시오.");
        }
    }
}
