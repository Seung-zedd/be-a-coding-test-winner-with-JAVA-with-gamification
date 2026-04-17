package tree;

import java.util.*;

/*
[문제 해석]
판매원이 칫솔을 판매하면 그 이익이 피라미드 조직을 타고 조금씩 분배되는 형태의 판매망입니다.
-> if 판매원 칫솔 판매: child node에 이익 분배됨

조직의 이익 분배 규칙은 간단합니다. 모든 판매원은 칫솔의 판매에 의하여 발생하는 이익에서 10% 를 계산하여 
-> ir * 0.1

자신을 조직에 참여시킨 추천인에게 배분하고 
-> ref += ir * 0.1
나머지는 자신이 가집니다.

모든 판매원은 자신이 칫솔 판매에서 발생한 이익 뿐만 아니라, 
                
자신이 조직에 추천하여 가입시킨 판매원에게서 발생하는 이익의 10%까지 자신에 이익이 됩니다.
-> 자신의 이익 += (자신의 칫솔 판매) + 판매원의 ir * 0.1
자신에게 발생하는 이익 또한 마찬가지의 규칙으로 자신의 추천인에게 분배됩니다.
-> 자신의 부모 노드한테 ir * 0.1을 리턴한다

? 이거 완전 tree propagate 구조인데?

단, 10% 를 계산할 때에는 원 단위에서 절사하며, 
-> //? 뭔소리               
10%를 계산한 금액이 1 원 미만인 경우에는 이득을 분배하지 않고 자신이 모두 가집니다.
-> if (ir * 0.1 < 1): 자신의 칫솔 판매

예를 들어, 아래와 같은 판매 기록이 있다고 가정하겠습니다. 칫솔의 판매에서 발생하는 이익은 개당 100 원으로 정해져 있습니다.
-> 판매원을 먼저 for문으로 순회 
-> 이익금 = 판매 수량 * 100 (e.g. 12 * 100 = 1200원)

if mary의 2원 * 0.1 = 0.2인데, int로 캐스팅하면(원 단위에서 절사하면) 배분할 금액이 없기 때문에 mary는 재귀호출하기 전의 ir * 0.1을 본인이 가짐

- param - 
enroll: 각 판매원의 이름을 담은 배열
referral: 각 판매원을 다단계 조직에 참여시킨 다른 판매원의 이름을 담은 배열(즉, 부모 노드) 
seller: 판매량 집계 데이터의 판매원 이름을 나열한 배열
amount: 판매량 집계 데이터의 판매 수량을 나열한 배열 
-> seller와 amount는 일대일 대응 관계

요구사항: 각 판매원이 득한 이익금을 나열한 배열을 return
판매원에게 배분된 이익금의 총합을 계산하여(int로), 입력으로 주어진 enroll에 이름이 포함된 순서에 따라 나열하면 됩니다.

- 제약 조건 - 
1. enroll의 길이는 1 이상 10^4 이하입니다.
    1.1. enroll에 민호의 이름은 없습니다.(민호 == root)
     따라서 enroll의 길이는 민호를 제외한 조직 구성원의 총 수입니다.
2. referral.length == enroll.length(10^4)
    2.1. referral[i] = enroll[i]의 부모 노드
    2.2. 어느 누구의 추천도 없이 조직에 참여한 사람에 대해서는 referral 배열 내에 추천인의 이름이 기입되지 않고 “-“ 가 기입됩니다. 위 예제에서는 john 과 mary 가 이러한 예에 해당합니다.
    -> root인 민호의 이름은 없다고 했기 때문에 "-"로 표시.
    2.3. enroll[i]: level-order 순으로 트리를 순회
        2.3.1. 즉, enroll[i]이 이미 등장했으면, referral[i]번째 원소는 이미 enroll[j] 번째 (j < i) 에 등장했음이 보장됩니다.
        -> 위와 같은 의미
3. seller의 길이는 1 이상 10^5 이하입니다.
    3.1. seller[i]: 판매 집계 데이터가 어느 판매원에 의한 것인지를 나타냅니다.
    3.2. seller 에는 같은 이름이 중복해서 들어있을 수 있습니다.
    -> countMap으로 집계?

4. amount.length == seller.length(10^5)
    4.1. amount[i]: 판매 집계 데이터의 판매량
    4.2. 1 <= amount[i] <= 10^2
5. 칫솔 한 개를 판매하여 얻어지는 이익은 100 원으로 정해져 있습니다.
-> 이익금 = amount * 100
6. 모든 조직 구성원들의 이름은 10 글자 이내의 영문 알파벳 소문자들로만 이루어져 있습니다.

[로직 설계]
2. enroll for문 순회
    2.1. enroll - referral 맵 구성, Map<String, String> referMap으로 매핑("입력으로 주어진 enroll에 이름이 포함된 순서에 따라 나열하면 됩니다." => 신고 결과의 옵저버 패턴과 동일함, 그러니까 마지막에 enroll을 for문으로 돌리면서 이익금을 저장하면 됨)
3. amount for문 순회하면서 이익금 계산(seller와 amount는 일대일 대응 관계)
    3.1. money = amount[i] * 100
    3.2. 나의 돈과 나눠야할 돈을 분배
        myMoney = money * 0.9
        referMoney = money * 0.1
    업데이트된 이익금을 게산해야함 => Map<String, Integer> moneyMap
    3.4. person, referral을 분배 // person = seller[i], referral = referMap.get(seller[i])
    3.3. while (referral != null):
        3.3.1. moneyMap.merge(person, myMoney, Integer::sum); person이 누군가에게는 referral이 될 수 있으므로
        person = referral // 
        
4. enroll for문 순회
    4.1. 위에서 tallyMap.merge(seller[i], money, Integer::sum)로 업데이트한 money를 answer[i]로 저장 // 어짜피 판매원의 중복된 판매 리스트는 tallyMap에서 계산
5. answer를 리턴
*/

public class ToothbrushSalesSolution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // [백지 복습] 2회차: 상향 전파와 기하급수적 감쇠의 논리를 재구성하십시오.
        return new int[enroll.length];
    }
}
