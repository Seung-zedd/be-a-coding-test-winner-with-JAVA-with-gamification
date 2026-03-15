package queue;

import java.util.*;

/*
⚔️ [퀘스트] 문제 16: 기능 개발
 🔗 원형 큐의 순환 논리 및 CQS 원칙 학습

각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다. 
뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있지만,
-> 개발 속도에 차이가 나기 때문에 개발 날짜는 상관 x

뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
-> 부등호 주의!

[입력]
- progresses: 작업 진도 배열
- speeds: 작업 속도 배열

[출력]
- 각 배포마다 배포되는 기능의 개수 배열
-> 배포는 하루에 한 번만 할 수 있기 때문에 하루에 배포 가능한 날짜를 계산해야함
-> progresses 배열과 speeds 배열은 일대일 대응
*/

public class FunDevSolution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 순서를 위해 덱을 기반으로 하는 큐 생성
        Deque<Integer> q = new ArrayDeque<>();

        // 남은 개발 일짜 계산
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            int remain = (100 - progresses[i]) % speeds[i];

            // 나누어 떨어지지 않으면 day 1 증가
            if (remain != 0) {
                day++;
            }

            q.offer(day);
        }
        
        // 배포 날짜 계산 시작
        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int feature = 0;
            int maxDate = q.poll();
            feature++; // 꺼냈으면 기능 1 추가
            // 단조 스택의 맹공 스킬을 활용해서 계속해서 잡아먹는다
            while (!q.isEmpty() && (maxDate >= q.peek())) {
                q.poll();
                feature++; 
            }

            answer.add(feature);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
