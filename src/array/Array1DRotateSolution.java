package array;

import java.util.*;

public class Array1DRotateSolution {
    public int[] solution(int[] numbers, String direction) {
        List<Integer> numlist = new ArrayList<>();

        // 먼저 리스트에 원소들을 다 채움
        for (int num : numbers) {
            numlist.add(num);
        }

        if (direction.equals("right")) {
            Integer removedEl = numlist.remove(numlist.size() - 1);
            numlist.add(0, removedEl);
        } else {
            Integer removedEl = numlist.remove(0);
            numlist.add(removedEl);
        }

        return numlist.stream().mapToInt(Integer::intValue).toArray();
    }
}
