package queue;

import java.util.*;

/*
⚔️ [퀘스트] 문제 16: 기능 개발
 🔗 원전: 프로그래머스
 (https://school.programmers.co.kr/learn/courses/30/lessons/42586)

각 기능은 '진도'가 100%일 때 '서비스에 반영'할 수 있습니다.
-> if 진도 == 100%: 서비스 반영
? 진도는 제한 사항의 progresses[i]와 매핑

각 기능의 '개발속도'는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
-> speeds[i]는 unique
? 개발속도는 제한 사항의 speeds[i]와 매핑

이때 뒤에 있는 기능은 앞에 있는 기능이 '배포'될 때 함께 배포됩니다.
-> 무조건 대기큐의 앞에 있는 기능이 배포될 때 뒤에 있는 기능이 배포되어야함, 즉 순서가 있다는 의미



요구사항: 먼저 배포되어야 하는 '순서대로' 작업의 진도가 적힌 정수 배열 progresses
-> 배열이라고 해서 리스트를 사용하면 x, 왜냐하면 리스트 또는 배열은 RAM이기 때문에 순서와 무관
-> 따라서, 순서와 관련된 큐 또는 스택을 사용한다. But "뒤에 있는 기능은 앞에 있는 기능이 '배포'될 때 함께 배포됩니다."라고 하였기 때문에, 큐를 사용하는데, 배포되기 전의 기능들이기 때문에 ReadyQueue<Progress>로 초기화 

각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 

각 배포마다 몇 개의 기능이 배포되는지를 return

 * [입력]
 * progresses: 먼저 배포되어야 하는 순서대로 작업 진도가 적힌 정수 배열
 * speeds: 각 작업의 개발 속도가 적힌 정수 배열
 * 
 * [출력]
 * 각 배포마다 몇 개의 기능이 배포되는지 담긴 정수 배열
 * 
 * [제한 사항]
 * 배포는 하루에 한 번만 할 수 있으며,
 * [예시]
 * progresses: [93, 30, 55], speeds: [1, 30, 5]
 * -> [2, 1]
 */
public class FunDevSolution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 정답의 길이가 작업 진도의 길이와 맞지 않기 때문에 리스트로 초기화
        List<Integer> answer = new ArrayList<>();

        // 남은 개발 날짜를 의미하는 StagingQueue 초기화
        Queue<Integer> q = new ArrayDeque<>();

        // progresses를 순회하면서 계산
        for (int i = 0; i < progresses.length; i++) {
            // 남은 작업 진도 계산
            int remainedProgress = 100 - progresses[i];
            // 남은 개발 날짜를 계산
            int day = remainedProgress / speeds[i];
            int remained = remainedProgress % speeds[i];
            if (remained != 0) {
                day++;
            }

            // 스테이징 큐에 남은 개발 날짜를 순서대로 추가
            q.offer(day);
        }

        // 하루에 배포할 수 있는 기능 계산
        
        while (!q.isEmpty()) {
            int feature = 0; // 스테이징 큐에서 기능 계산 시작
            int maxDate = q.poll(); // 최고 날짜 업데이트
            feature++; // 큐에서 꺼낼 때마다 카운팅

            // ! 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 '함께' 배포됩니다. -> 부등호 주의!
            while (!q.isEmpty() && (maxDate >= q.peek())) {
                // 최고 날짜로 계속 업데이트(잡아먹는 구조)
                // maxDate = Math.max(maxDate, q.poll());
                q.poll(); //? while문이 단조 스택과 유사한 역할을 하기 때문에 maxDate는 유지됨
                feature++;
            }
            answer.add(feature);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
