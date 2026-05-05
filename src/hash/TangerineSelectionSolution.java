package hash;

/*
[문제 해석]
경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다.
-> tangerine 배열 중 k개를 골라서 해시셋에 담아서 중복 및 순서를 제거한 가지 수를 리턴

귤을 "크기별로 분류"했을 때 "서로 다른 종류의 수를 최소화"하고 싶습니다.
-> 서로 다른 종류의 수를 카운팅?
-> //? "최소화"라는게 무슨 말이지?
-> 상자의 빈자리를 "가장 숫자가 많은 종류로 채우는 것이 무조건 이득"입니다. 숫자가 적은 종류를 먼저 담으면 빈자리가 금방 차버리고, 결국 더 많은 종류를 담아야 하니까요.


- 제약 조건 - 
1. 1 <= k <= tangerine.length <= 10^5
2. 1 <= tangerine[i] <= 10^7

*/

import java.util.*;

public class TangerineSelectionSolution {
    public int solution(int k, int[] tangerine) {
        // 서로 다른 귤의 종류를 먼저 카운팅
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.merge(t, 1, Integer::sum);
        }

        // 내림차순 정렬
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // 정렬된 리스트 내에서 k - list.values()
        int answer = 0; // 서로 다른 종류의 수
        for (Map.Entry<Integer, Integer> entry : list) {
            k -= entry.getValue();
            answer++;

            // k개의 귤을 다 담았으면 종료
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}
