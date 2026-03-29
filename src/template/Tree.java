package template;

import java.util.*;

public class Tree {
    public static class Node {
        int value;
        Node left, right;

        // 노드 객체 생성
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // 1. Level-order(BFS)
    public List<Integer> levelOrder(Node root) {
        // base condition
        // ! null 대신 빈 리스트를 리턴해야 NullPointerException을 방지할 수 있음
        if (root == null) {
            return new ArrayList<>();
        }

        // 사전 세팅: root 노드를 먼저
        List<Integer> result = new ArrayList<>();
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            result.add(curNode.value);

            // 인접 노드 탐색
            if (curNode.left != null) {
                q.offer(curNode.left);
            }
            if (curNode.right != null) {
                q.offer(curNode.right);
            }
        }

        // 탐색을 다 했으면 result 리턴
        return result;
    }

    // DFS
    // 2. pre-order traversal: 루트 노드를 가장 먼저 방문
    // 방문: 노드의 값에 접근하는 것(출력, 저장 등)을 의미
    public List<Integer> preOrder(Node root) {
        List<Integer> result = new ArrayList<>();

        preHelper(root, result);
        return result;
    }

    private void preHelper(Node root, List<Integer> result) {
        // base condition
        // ? 매 노드 방문마다 새로운 리스트가 생성되어, 트리가 클 경우 힙 메모리에 과부하를 주기 때문에 CQS 원칙에 따라 void를 리턴하게
        // 한다
        if (root == null) {
            return;
        }

        result.add(root.value);
        preHelper(root.left, result);
        preHelper(root.right, result);
    }

    // 2. in-order traversal: 루트 노드를 2번째로 방문
    public List<Integer> inOrder(Node root) {
        List<Integer> result = new ArrayList<>();

        inHelper(root, result);
        return result;
    }

    private void inHelper(Node root, List<Integer> result) {
        // base condition
        if (root == null) {
            return;
        }

        inHelper(root.left, result);
        result.add(root.value);
        inHelper(root.right, result);
    }

    // 2. post-order traversal: 루트 노드를 가장 마지막으로 방문
    public List<Integer> postOrder(Node root) {
        List<Integer> result = new ArrayList<>();

        postHelper(root, result);
        return result;
    }

    private void postHelper(Node root, List<Integer> result) {
        // base condition
        if (root == null) {
            return;
        }

        postHelper(root.left, result);
        postHelper(root.right, result);
        result.add(root.value);
    }
}
