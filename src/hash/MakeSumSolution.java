package hash;

import java.util.*;

public class MakeSumSolution {
    public boolean solution(int[] arr, int target) {
        // target을 만들 수 있으면 true, 그렇지 않으면 false를 반환하라
        // complement = target - num
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            int complement = target - i;
            if (set.contains(complement)) {
                return true;
            }
            set.add(i); // 현재 순회하고 있는 데이터를 삽입
        }
        
        return false;
    }
}
