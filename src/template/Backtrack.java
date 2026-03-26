package template;

import java.util.*;

public class Backtrack {
    // 1. 순열
    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        permuteHelper(arr, curr, ans);
        return ans;
    }

    private static void permuteHelper(int[] arr, List<Integer> curr, List<List<Integer>> ans) {
        // base condition
        if (curr.size() == arr.length) {
            ans.add(new ArrayList<>(curr)); // 깊은 복사(즉, curr의 원소들을 삽입한다.)
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!curr.contains(arr[i])) {
                curr.add(arr[i]);
                permuteHelper(arr, curr, ans);
                curr.remove(curr.size() - 1);
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
            if (!curr.contains(arr[i])) {
                curr.add(arr[i]);
                combineHelper(arr, curr, ans, k, i + 1);
                curr.remove(curr.size() - 1);
            }
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
            if (!curr.contains(arr[i])) {
                curr.add(arr[i]);
                combineHelper(arr, curr, ans, k, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
