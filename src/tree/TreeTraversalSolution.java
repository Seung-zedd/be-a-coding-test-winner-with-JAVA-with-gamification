package tree;

import java.util.*;

public class TreeTraversalSolution {
    public String[] solution(int[] nodes) {
        // [문제 25] 트리 순회 (트리)
        // 전입을 환영한다, 용사여. 트리라는 새로운 차원이 열렸다.
        // 0번 인덱스부터 시작하는 완전 이진 트리를 전위, 중위, 후위 순회로 정복하라.
        String[] ans = new String[3];

        // 재귀함수에서 계속 호출하면 힙 메모리 터짐! && result 대용
        StringBuilder sb = new StringBuilder();

        String res0 = preOrder(nodes, sb, 0);
        ans[0] = res0.trim();
        sb.setLength(0); // sb.clear()
        String res1 = inOrder(nodes, sb, 0);
        ans[1] = res1.trim();
        sb.setLength(0);
        String res2 = postOrder(nodes, sb, 0);
        ans[2] = res2.trim();
        sb.setLength(0);

        return ans;
    }

    private static String preOrder(int[] nodes, StringBuilder sb, int i) {
        // base condition
        //! 0-based index
        if (i > nodes.length - 1) {
            return null;
        }

        if (i <= nodes.length - 1) {
            sb.append(String.valueOf(nodes[i])).append(" ");
            preOrder(nodes, sb, 2 * i + 1); // left child
            preOrder(nodes, sb, 2 * i + 2); // right child
        }

        return sb.toString();
    }

    private static String inOrder(int[] nodes, StringBuilder sb, int i) {
        if (i > nodes.length - 1) {
            return null;
        }

        if (i <= nodes.length - 1) {
            inOrder(nodes, sb, 2 * i + 1); // left child
            sb.append(String.valueOf(nodes[i])).append(" ");
            inOrder(nodes, sb, 2 * i + 2); // right child
        }

        return sb.toString();
    }

    private static String postOrder(int[] nodes, StringBuilder sb, int i) {
        if (i > nodes.length - 1) {
            return null;
        }

        if (i <= nodes.length - 1) {
            postOrder(nodes, sb, 2 * i + 1); // left child
            postOrder(nodes, sb, 2 * i + 2); // right child
            sb.append(String.valueOf(nodes[i])).append(" ");
        }

        return sb.toString();
    }

}
