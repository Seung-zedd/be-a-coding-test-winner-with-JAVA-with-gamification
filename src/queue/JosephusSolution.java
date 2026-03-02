package queue;

import java.util.*;

/**
 * ⚔️ [퀘스트] 문제 15: 요세푸스 문제 (Josephus Problem)
 * 🔗 원전: 백준 1158 (https://www.acmicpc.net/problem/1158)
 * 
 * [미션 설명]
 * 1번부터 N번까지 N명의 사람이 "원을 이루며 앉아 있습니다."
 * -> Circular Queue를 의미
 * 순서대로 K번째 사람을 제거합니다.
 * -> 큐를 마치 LED 전광판 마냥 맨 끝으로 보내면서 K번째 데이터만 poll을 해서 answer 배열에 담는다.
 * 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 반복합니다.
 * N명의 사람이 모두 제거될 때까지 제거되는 순서(요세푸스 순열)를 구하십시오.
 * 
 * [제한 사항]
 * 1 ≤ K ≤ N ≤ 5,000
 * 
 * [입력]
 * n: 전체 인원 수
 * k: 제거할 순서
 * 
 * [출력]
 * 제거된 순서대로 담긴 정수 배열 (int[])
 * 
 * [예시]
 * (7, 3) -> [3, 6, 2, 7, 5, 1, 4]
 */
public class JosephusSolution {
    public int[] solution(int n, int k) {
        // 출력을 위한 정답 배열 초기화
        List<Integer> answer = new ArrayList<>();

        // 요세푸스 순열을 위한 큐 초기화
        // ? 포인터 연결 작업이 없는 "배열 기반"이라 LinkedList보다 더 가벼움
        Queue<Integer> q = new ArrayDeque<>();

        // 먼저 크기 n만큼 deque에 담는다.
        // ? 코테에서는 offer(), poll(), peek()로 런타임 에러 비용을 낮춰서 디버깅을 편하게 한다.
        for (int i = 1; i < n + 1; i++) {
            q.offer(i);
        }

        // if k번째 사람이 큐의 맨 앞에 있으면: k번째 사람을 추출(idx = k - 1)하고 answer 배열에 추가
        //! for-each는 읽기 전용이라, 그 안에서 쓰기 연산을 하면 ConcurrentModificationException 에러 발생!(CQS 원칙과 연관지어서 이해하자)
        while (!q.isEmpty()) {
            // 간단하게 k-1번 순회를 한다.
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
            }
            answer.add(q.poll());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
