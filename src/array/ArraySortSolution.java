package array;

import lombok.ToString;
import java.util.*;

/*
제약 조건: 2 <= arr.length <= 10^5
    -> sort()는 O(NlogN)이니까 10^5 * 16 < 10^8 : o.k




 */

@ToString
public class ArraySortSolution {
    public static int[] solution(int[] arr) {
        int[] clone = arr.clone();
        /*Arrays.sort(arr);

        return arr;*/

        return Arrays.stream(arr).sorted().toArray();
    }
}
