package queue;

import java.util.*;

/*
, 양의 정수 K(≤ N)가 주어진다.  한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.


*/

public class JosephusSolution {
    public int[] solution(int n, int k) {
        List<Integer> answer = new ArrayList<>();

        // 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.offer(i + 1);
        }
        // N명의 사람이 모두 제거될 때까지 계속된다.
        // 이제 순서대로 K번째 사람을 제거한다.
        while (!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }
            answer.add(q.poll());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}
