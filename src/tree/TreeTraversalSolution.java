package tree;

import java.util.*;

public class TreeTraversalSolution {
    public String[] solution(int[] nodes) {
        // [복습 2회차] 트리 순회 (Tree Traversal)
        // 0-based 인덱스 완전 이진 트리: 왼쪽 자식(2i+1), 오른쪽 자식(2i+2)
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[3];

        //! 결과값인 "1 2 4 5 3 6 7 "에서 문자열 끝에 보이지 않는 공백 한 칸을 제거하기 위해 trim()을 사용해줘야함
        String res0 = preOrder(nodes, sb, 0).trim();
        answer[0] = res0;
        sb.setLength(0);
        String res1 = inOrder(nodes, sb, 0).trim();
        answer[1] = res1;
        sb.setLength(0);
        String res2 = postOrder(nodes, sb, 0).trim();
        answer[2] = res2;
        return answer;
    }

    private String preOrder(int[] nodes, StringBuilder sb, int i) {
        if (i > nodes.length - 1) {
            return null;
        } else {
            sb.append(String.valueOf(nodes[i])).append(" ");
            preOrder(nodes, sb, 2 * i + 1);
            preOrder(nodes, sb, 2 * i + 2);
        }

        return sb.toString();
    }

    private String inOrder(int[] nodes, StringBuilder sb, int i) {
        if (i > nodes.length - 1) {
            return null;
        } else {
            inOrder(nodes, sb, 2 * i + 1);
            sb.append(String.valueOf(nodes[i])).append(" ");
            inOrder(nodes, sb, 2 * i + 2);
        }

        return sb.toString();
    }

    private String postOrder(int[] nodes, StringBuilder sb, int i) {
        if (i > nodes.length - 1) {
            return null;
        } else {
            postOrder(nodes, sb, 2 * i + 1);
            postOrder(nodes, sb, 2 * i + 2);
            sb.append(String.valueOf(nodes[i])).append(" ");
        }

        return sb.toString();
    }
}
