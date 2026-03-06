package queue;

import java.util.ArrayDeque;
import java.util.Queue;

/*
[문제 해석]
코니는 '영어 단어'가 적힌 '카드 뭉치 두 개'를 선물로 받았습니다. 
-> 카드 뭉치 2개에 주목하자.

카드에 적힌 단어들을 사용해 '원하는 순서'의 단어 배열을 만들 수 있는지 알고 싶습니다.
-> 입출력 예시를 보니까 큐가 될 수 밖에 없구나.

원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
-> cards1 또는 cards2에서 q.poll()을 함

한 번 사용한 카드는 다시 사용할 수 없습니다.
-> q.poll()은 걍 버림

카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
-> 무조건 cards1 또는 cards2를 선택했으면 무조건 q.poll()을 해야함
-> 만약에 둘다 없으면 그냥 "No"를 리턴하면 됨

기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.
-> 큐에 있는 그대로 사용

요구사항: cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return

- 제한사항 - 
1. 1 ≤ cards1[i]의 길이, cards2[i]의 길이 ≤ 10
    1.1. card1과 cards2는 서로 unique하다. 즉, 교집합이 없다.
2. 2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
    2.1. 1 ≤ goal[i]의 길이 ≤ 10
    2.2. goal의 원소는 cards1과 cards2의 원소들로만 이루어져 있습니다.

*/

public class CardDeckSolution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.
        Queue<String> q1 = new ArrayDeque<>();
        Queue<String> q2 = new ArrayDeque<>();

        // 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
        for (String c1 : cards1) {
            q1.offer(c1);
        }

        for (String c2 : cards2) {
            q2.offer(c2);
        }

        // 먼저 goal을 순회
        // goal의 단어를 하나씩 만들 수 있다면 answer 1씩 감소
        int answer = goal.length;
        for (int i = 0; i < goal.length; i++) {
            // card1과 cards2는 서로 unique하다.
            if (!q1.isEmpty() && q1.peek().equals(goal[i])) {
                q1.poll();
                answer--;
            }
            if (!q2.isEmpty() && q2.peek().equals(goal[i])) {
                q2.poll();
                answer--;
            }
            // 카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
            
        }

        return answer == 0 ? "Yes" : "No";
    }
}
