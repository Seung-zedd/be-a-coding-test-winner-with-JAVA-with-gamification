package array;

import java.util.*;


public class ArrayControlSolution {
    public static int[] solution(int[] arr) {
        // 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 리턴
//        return Arrays.stream(arr).distinct().boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        //? HashSet: 중복 제거 + 순서 보장 x
        // TreeSet: 중복 제거 + 순서(정렬) 보장
        //* Set으로 중복 제거 + 생성자 인자에 Collections.reverseOrder()를 넣어서 내림차순 정렬
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i : arr) {
            set.add(i);
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
