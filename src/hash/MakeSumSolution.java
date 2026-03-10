package hash;

import java.util.*;

/*
⚔️ [퀘스트] 문제 18: 두 개의 수로 특정값 만들기 (Make Sum)
 🔗 원전: 코딩 테스트 합격자 되기: 자바 편 (177p) / LeetCode: Two Sum 유사

n개의 양의 정수로 이루어진 리스트 arr와 정수 target이 주어졌을 때, 
arr에 있는 정수 중에서 서로 다른 두 수를 더해 target을 만들 수 있는지 
여부를 반환하는 solution() 함수를 작성하세요.
-> 서로 다른 두 수를 더해 target을 만들 수 있는가? == 보수의 접근법을 활용
즉, num + x = target, x = target - num으로 현재 순회하고 있는 데이터를 num으로 설정한다.

[입력]
- arr: n개의 양의 정수로 이루어진 배열
- target: 목표 합계 정수

[출력]
- target을 만들 수 있으면 true, 없으면 false

[제한 사항]
- n은 2 이상 10^4 이하의 자연수입니다.
- arr의 각 원소는 1 이상 1,000,000 이하의 자연수입니다.
- target은 1 이상 2,000,000 이하의 자연수입니다.
*/

public class MakeSumSolution {
    public boolean solution(int[] arr, int target) {
        // 스택 아니면 큐 -> 덱으로 풀 수 있을 것 같은데? 왜냐하면 target만 만족하는 데이터만 가져오면 되는거 아님?
        // ! 덱은 front 또는 rear에서만 데이터 접근이 가능하기 때문에 인덱스에 상관없이 조회를 원하면 HashSet을 사용하면 된다!
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            int complement = target - i;
            if (set.contains(complement)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }
}
