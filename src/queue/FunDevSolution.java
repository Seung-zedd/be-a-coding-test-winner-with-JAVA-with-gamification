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

        return new int[] {};
    }
}
