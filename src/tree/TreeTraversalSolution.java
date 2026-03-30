package tree;

import java.util.*;

public class TreeTraversalSolution {
    public String[] solution(int[] nodes) {
        // [문제 25] 트리 순회 (트리)
        // 전입을 환영한다, 용사여. 트리라는 새로운 차원이 열렸다.
        // 0번 인덱스부터 시작하는 완전 이진 트리를 전위, 중위, 후위 순회로 정복하라.

        // 1. 전위 순회 (Pre-order): 루트 -> 왼쪽 -> 오른쪽
        // 2. 중위 순회 (In-order): 왼쪽 -> 루트 -> 오른쪽
        // 3. 후위 순회 (Post-order): 왼쪽 -> 오른쪽 -> 루트

        String[] ans = new String[3];
        StringBuilder sb = new StringBuilder(); // ! 힙 메모리 증가로 인한 GC 메모리 오버헤드를 줄이기 위함
        // nodes를 *순회한다
        String res0 = preOrder(nodes, 0, sb).trim();
        ans[0] = res0;
        sb.setLength(0); // 다음 순회를 위해 비우기
        String res1 = inOrder(nodes, 0, sb).trim();
        ans[1] = res1;
        sb.setLength(0);
        String res2 = postOrder(nodes, 0, sb).trim();
        ans[2] = res2;

        return ans;
    }

    // 파라미터로 넘긴 sb는 result와 같은 역할
    public String preOrder(int[] nodes, int start, StringBuilder sb) {
        // base condition: 잠수하는 인덱스가 nodes의 길이보다 크거나 같으면 null을 반환
        // ! nodes는 배열이기 때문에 0-based 기준으로 생각해야함
        if (start >= nodes.length) {
            return null;
        }

        // 재귀적으로 잠수하는 start 인덱스를 nodes.length보다 작을 때만 순회하게 함
        //! 재귀 자체가 for문하고 동급이기 때문에 for문을 사용하면 중복 사용이 됨
        if (start < nodes.length) {
            sb.append(nodes[start]).append(" "); // 먼저 root를 방문
            preOrder(nodes, 2 * start + 1, sb);
            preOrder(nodes, 2 * start + 2, sb);
        }

        return sb.toString();
    }

    public String inOrder(int[] nodes, int start, StringBuilder sb) {
        // base condition: 잠수하는 인덱스가 nodes의 길이보다 크거나 같으면 null을 반환
        // ! nodes는 배열이기 때문에 0-based 기준으로 생각해야함
        if (start >= nodes.length) {
            return null;
        }

        // 재귀적으로 잠수하는 start 인덱스를 nodes.length보다 작을 때만 순회하게 함
        if (start < nodes.length) {
            inOrder(nodes, 2 * start + 1, sb);
            //? StringBuilder는 T 타입을 삽입하면 객체 안에서 T 타입의 데이터가 저장된다.
            sb.append(nodes[start]).append(" "); // 먼저 root를 방문
            inOrder(nodes, 2 * start + 2, sb);
        }

        return sb.toString();
    }

    public String postOrder(int[] nodes, int start, StringBuilder sb) {
        if (start >= nodes.length) {
            return null;
        }

        if (start < nodes.length) {
            postOrder(nodes, 2 * start + 1, sb);
            postOrder(nodes, 2 * start + 2, sb);
            sb.append(nodes[start]).append(" ");
        }

        return sb.toString();
    }

}
