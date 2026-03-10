import java.util.*;

/*

이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 합니다.
-> if num[i] + num[j] + num[k] == 0: 삼총사

딱 봐도 two sum을 응용한 문제인 것 같은데 해시맵으로 풀 수 있지 않을까?
*/

class Solution {
    public int solution(int[] number) {
        int count = 0;
        int n = number.length;

        // x + y + z = 0에서 x를 상수로 고정(차원 하나를 고정시킴)
        //? 배열의 길이가 n일 때, z가 도달할 수 있는 최대 idx는 n - 1, y는 n - 2고, x는 n - 3이 된다
        for (int i = 0; i < n - 2; i++) {
            int x = number[i];
            int target = -x; // y + z = -x

            // two sum 응용, 즉 보수를 활용한다
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                int y = number[j];
                int complement = target - y;

                // 이전에 저장한 해시맵에 보수가 있으면 위의 식이 성립하므로 그 개수만큼 정답 조합이 존재
                if (map.containsKey(complement)) {
                    count += map.get(complement);
                }

                // 그렇지 않으면 y값을 해시맵에 저장하여 다음 순회에서 보수의 후보로 만듦
                //? 리트코드의 Two sum 문제는 2개의 인덱스를 리턴하는 거였는데 이 문제는 방법의 수를 리턴하는거라서 default로 0을 설정하고 y를 넣을 때 방법 수 1을 더하였음
                map.put(y, map.getOrDefault(y, 0) + 1);
            }
        }

        return count;
    }
}