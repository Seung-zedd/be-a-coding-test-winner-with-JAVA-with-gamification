package tree;

public class TreeTraversalSolution {
    /*
     * [문제 25] 트리 순회 (Tree Traversal)
     * - 지문 분석 내용(0-based 완전 이진 트리 공식 등)을 토대로 백지 복습
     * - trim() 사용 주의
     */
    public String[] solution(int[] nodes) {
        StringBuilder sb = new StringBuilder();
        String[] ans = new String[3];

        String res0 = preOrder(nodes, sb, 0).trim();
        ans[0] = res0;
        sb.setLength(0);
        String res1 = inOrder(nodes, sb, 0).trim();
        ans[1] = res1;
        sb.setLength(0);
        String res2 = postOrder(nodes, sb, 0).trim();
        ans[2] = res2;
        return ans;

    }

    private static String preOrder(int[] nodes, StringBuilder sb, int i) {
        // base condition
        if (i > nodes.length - 1) {
            return null;
        }

        sb.append(String.valueOf(nodes[i])).append(" ");
        preOrder(nodes, sb, 2 * i + 1);
        preOrder(nodes, sb, 2 * i + 2);

        return sb.toString();
    }

    private static String inOrder(int[] nodes, StringBuilder sb, int i) {
        // base condition
        if (i > nodes.length - 1) {
            return null;
        }

        inOrder(nodes, sb, 2 * i + 1);
        sb.append(String.valueOf(nodes[i])).append(" ");
        inOrder(nodes, sb, 2 * i + 2);

        return sb.toString();
    }

    private static String postOrder(int[] nodes, StringBuilder sb, int i) {
        // base condition
        if (i > nodes.length - 1) {
            return null;
        }

        postOrder(nodes, sb, 2 * i + 1);
        postOrder(nodes, sb, 2 * i + 2);
        sb.append(String.valueOf(nodes[i])).append(" ");

        return sb.toString();
    }
}
