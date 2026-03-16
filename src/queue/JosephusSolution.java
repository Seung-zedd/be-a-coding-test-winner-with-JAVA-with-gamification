package queue;

import java.util.*;

/*
⚔️ [퀘스트] 문제 15: 요세푸스 문제 
 🔗 원형 큐의 순환 논리 및 CQS 원칙 학습

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 순서대로 K번째 사람을 제거합니다.
한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 N명이 모두 제거될 때까지 반복합니다.
요세푸스 순열을 구하는 프로그램을 작성하세요.

[입력]
- n: 사람의 수
- k: 제거할 순서

[출력]
- 요세푸스 순열 (제거된 순서대로의 배열)
*/

public class JosephusSolution {
    public int[] solution(int n, int k) {
        // 덱으로 큐 초기화
        Deque<Integer> q = new ArrayDeque<>();

        // 먼저 "N명의 사람이 원을 이루면서 앉아있고"를 구현하기 위해 원형 큐에 삽입
        for (int i = 1; i < n + 1; i++) {
            q.offer(i);
        }

        // 요세푸스 순열을 리스트로 초기화
        List<Integer> answer = new ArrayList<>();

        // N명이 모두 제거될 때까지 반복
        
        while (!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }

            answer.add(q.poll()); // K번째 사람 answer에 삽입
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
