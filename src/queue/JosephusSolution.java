package queue;

import java.util.*;

/*
[문제 매핑]
1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고
-> N의 크기

이제 '순서대로' K번째 사람을 제거한다.
-> 큐가 FIFO 구조이므로 순서대로와 적합!

한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
-> if 3번째 사람 제거: 그 다음 사람인 4번째 사람부터 과정 반복

이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 
-> while(!q.isEmtpy())

요세푸스 순열을 구하는 프로그램을 작성
-> 

*/

public class JosephusSolution {
    public int[] solution(int n, int k) {
        // [복습] 요세푸스 문제
        //* ArrayDeque는 원형 배열로 구현되었기 때문에 LinkedList와 달리 Node 객체를 생성할 필요가 없어서 메모리 및 성능이 좋음.
        //? ArrayDeque 어디에서 원형 배열로 구현된 것을 확인할 수 있지?
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();

        // 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고
        for (int i = 1; i < n + 1; i++) {
            q.offer(i);
        }

        // 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
        //! Iterator가 있는 컨테이너는 읽기/쓰기 분리할 것!
        while (!q.isEmpty()) {
            // 이제 '순서대로' K번째 사람을 제거한다.
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }

            // K번째 사람 제거
            answer.add(q.poll());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
