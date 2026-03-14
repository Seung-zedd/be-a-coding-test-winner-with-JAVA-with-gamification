package hash;

import java.util.*;

public class MakeSumSolution {
    public boolean solution(int[] arr, int target) {
        // [복습 2회차] 두 개의 수 합
        // x = target - num
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            int complement = target - i;
            if (set.contains(complement)) {
                return true;
            } else {
                set.add(i); // 현재 데이터를 삽입
            }
        }
        return false;
    }
}
