package template;

import java.util.*;

public class Backtrack {
    // 1. 순열
    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];

        permuteHelper(arr, curr, ans, visited);
        return ans;
    }

    private static void permuteHelper(int[] arr, List<Integer> curr, List<List<Integer>> ans, boolean[] visited) {
        // base condition
        if (curr.size() == arr.length) {
            ans.add(new ArrayList<>(curr)); // 깊은 복사(즉, curr의 원소들을 삽입한다)
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true; // 먼저 방문을 하고
                curr.add(arr[i]); // 상태 노드를 추가
                permuteHelper(arr, curr, ans, visited);
                curr.remove(curr.size() - 1); // 상태 노드를 제거하고
                visited[i] = false; // 방문을 해제
            }
        }
    }

    // 2. 조합
    public static List<List<Integer>> combine(int[] arr, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        combineHelper(arr, curr, ans, k, 0);
        return ans;
    }

    private static void combineHelper(int[] arr, List<Integer> curr, List<List<Integer>> ans, int k, int start) {
        // base condition
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < arr.length; i++) {
                curr.add(arr[i]);
                combineHelper(arr, curr, ans, k, i + 1); // 내 오른쪽만 재귀적으로 탐색
                curr.remove(curr.size() - 1);
        }
    }

    // 3. 부분집합
    public static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        for (int k = 0; k < arr.length + 1; k++) {
            subsetHelper(arr, curr, ans, k, 0);
        }

        return ans;
    }

    private static void subsetHelper(int[] arr, List<Integer> curr, List<List<Integer>> ans, int k, int start) {
        // base condition
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < arr.length; i++) {
                curr.add(arr[i]);
                combineHelper(arr, curr, ans, k, i + 1); // 내 오른쪽만 재귀적으로 탐색
                curr.remove(curr.size() - 1);
        }
    }
}
