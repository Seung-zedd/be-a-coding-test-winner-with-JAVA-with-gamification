package array;

import java.util.*;

public class ArrayDivisorSolution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> divisorList = new ArrayList<>();

        // arr를 먼저 순회
        for (int el : arr) {
            if (el % divisor == 0) {
                divisorList.add(el);
            }
        }

        // divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 삽입
        if (divisorList.isEmpty()) {
            divisorList.add(-1);
        }

        return divisorList.contains(-1) ? new int[]{-1} : divisorList.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
