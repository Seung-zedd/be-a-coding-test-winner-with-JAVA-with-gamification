package template;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 테스트용 배열 초기화
        int[] nums = { 1, 3, 5, 7 };

        System.out.println("=== 1. 순열 (Permutation: 4P4) ===");
        // List<List<Integer>> 형태의 반환값을 기대하는 테스트 케이스
        List<List<Integer>> permuteResult = Backtrack.permute(nums);
        if (permuteResult != null) {
            System.out.println("총 개수: " + permuteResult.size());
            for (List<Integer> list : permuteResult) {
                System.out.println(list);
            }
        }

        System.out.println("\n=== 2. 조합 (Combination: 4C2) ===");
        int k = 2; // 2개만 뽑아보는 조합
        List<List<Integer>> combineResult = Backtrack.combine(nums, k);
        if (combineResult != null) {
            System.out.println("총 개수: " + combineResult.size());
            for (List<Integer> list : combineResult) {
                System.out.println(list);
            }
        }

        System.out.println("\n=== 3. 부분집합 (Subset) ===");
        List<List<Integer>> subsetResult = Backtrack.subset(nums);
        if (subsetResult != null) {
            System.out.println("총 개수: " + subsetResult.size());
            for (List<Integer> list : subsetResult) {
                System.out.println(list);
            }
        }
    }
}
