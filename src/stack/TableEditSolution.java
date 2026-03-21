package stack;

import java.util.*;

/*
[문제 해석]
인턴인 앙몬드는 "명령어 기반"으로 표의 행을 "선택, 삭제, 복구"하는 프로그램을 작성하는 과제
-> 명령어 기반으로 선택, 삭제, 복구를 한다 == switch-case문으로 만들자

파란색으로 칠해진 칸은 현재 **선택된 행**을 나타냅니다. 
단, 한 번에 한 행만 선택할 수 있으며, 
-> 현재 가리키고 있는 행을 무엇으로 표시하는지가 중요

표의 범위(0행 ~ 마지막 행)를 벗어날 수 없습니다.
-> 0 <= 현재 행 <= 마지막 행

이때, 다음과 같은 "명령어"를 이용하여 표를 편집합니다.
- "U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
- "D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
-> //? split(" ")으로 하면 안되는 이유가 명령어 파라미터가 랜덤으로 주어지고, C, Z와 같이 뒤에 공백이 없으면 예외가 터져서 그런가?

- "C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 
-> 선택된 행 삭제 > 아래 행으로 이동
단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
-> if 선택된 행 삭제 행이 마지막 행: 위로 이동

- "Z" : "가장 최근에 삭제된 행을 원래대로 복구"합니다. 
-> 가장 최근? 아! LIFO 스택 쓰라는 말이군! && 선택된 행이 삭제된 행 번호를 기억하는 것이 중요

단, 현재 선택된 행은 바뀌지 않습니다.


- 예시 -
4행이 삭제되면서 아래 있던 행들이 하나씩 밀려 올라오고, 
-> 행 번호는 논리적으로 연결되었기 때문에 Doubly-Linked List를 떠올리라는데.... 이게 실전에서 가능해!??

수정된 표에서 다시 4행을 선택하는 것과 동일합니다
-> "C"의 '바로 아래 행을 선택합니다.' 맥락과 동일

param:
n: 처음 표의 행 개수를 나타내는 정수 
k: 처음에 선택된 행의 위치를 나타내는 정수 
cmd: 수행한 명령어들이 담긴 문자열 배열 

요구사항: 
1. 모든 명령어를 수행한 후 
-> for문으로 cmd 순회

표의 상태와 처음 주어진 표의 상태를 비교하여 
-> 표의 상태 == boolean으로 처리하라는 의미
boolean[] isDeleted로 명령어 순회하면서 플래그 표시

삭제되지 않은 행은 O, 삭제된 행은 X로 표시하여 문자열 형태로 return

- 제한 사항 - 
1. 5 ≤ n ≤ 10^6
2. 0 ≤ k < n
3. 1 ≤ cmd의 원소 개수 ≤ 2 * 10^5
    3.1. cmd의 각 원소는 "U X", "D X", "C", "Z" 중 하나입니다.
    3.2. X는 1 이상 300,000 이하인 자연수이며 0으로 시작하지 않습니다.
    -> "U"와 "D"에 포함되는 X는 substring(2)을 사용하라는 의미

    3.3. X가 나타내는 자연수에 ',' 는 주어지지 않습니다. 예를 들어 123,456의 경우 123456으로 주어집니다.
    3.4. cmd에 등장하는 모든 X들의 값을 합친 결과가 10^6 이하인 경우만 입력으로 주어집니다.
    -> //? 이게 무엇을 의미하는거지? -> cmd for문 내에서 while (x --> 0)는 분할 및 소집에 해당되므로 O(N + K)가 되서 10^8을 넘지 않음

    3.5. 표의 모든 행을 제거하여, 행이 하나도 남지 않는 경우는 입력으로 주어지지 않습니다.
    -> //? null 처리할 필요 없다는 의미? ㅇㅇ

    3.6. 본문에서 각 행이 제거되고 복구되는 과정을 보다 자연스럽게 보이기 위해 "이름" 열을 사용하였으나, "이름"열의 내용이 실제 문제를 푸는 과정에 필요하지는 않습니다. "이름"열에는 서로 다른 이름들이 중복없이 채워져 있다고 가정하고 문제를 해결해 주세요.
    -> 이것이 Doubly-linked List를 사용하라는 단서였는데, 우리는 원시 배열로 대신해서 사용할 것이다.

4. 표의 범위를 벗어나는 이동은 입력으로 주어지지 않습니다.
-> isValid() 경계 처리 할 필요 X

5. 원래대로 복구할 행이 없을 때(즉, 삭제된 행이 없을 때) "Z"가 명령어로 주어지는 경우는 없습니다.
-> 이건 어짜피 cmd가 랜덤으로 주어지니까 대충 스킵

6. 정답은 표의 0행부터 n - 1행까지에 해당되는 O, X를 순서대로 이어붙인 문자열 형태로 return 해주세요.
-> 대충 boolean[] isDeleted = new boolean[n]하라는 소리

<정확성 테스트 케이스 제한 사항>
5 ≤ n ≤ 1,000
1 ≤ cmd의 원소 개수 ≤ 1,000

<효율성 테스트 케이스 제한 사항>
주어진 조건 외 추가 제한사항 없습니다.
*/

public class TableEditSolution {
    public String solution(int n, int k, String[] cmd) {
        // 행 번호를 먼저 완성(0번 ~ n-1번)
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1; // 0번 이전은 없으므로 -1
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        // 행을 삭제 및 복구하기 위한 스택<행 번호를 저장>
        Deque<Integer> st = new ArrayDeque<>();

        // 표의 상태 == boolean으로 처리하라는 의미
        boolean[] isDeleted = new boolean[n];

        // cmd 순회
        for (String c : cmd) {
            Character command = c.charAt(0);

            switch (command) {
                case 'U':
                    int x = Integer.parseInt(c.substring(2));
                    // x만큼 이동
                    while (x-- > 0) {
                        k = prev[k]; // 현재 선택한 k행을 x만큼 위로 이동
                    }
                    break;
                case 'D':
                    int y = Integer.parseInt(c.substring(2));
                    while (y-- > 0) {
                        k = next[k]; // 현재 선택한 k행을 x만큼 아래로 이동
                    }
                    break;
                case 'C':
                    st.push(k); // 현재 선택한 행 제거
                    isDeleted[k] = true;
                    if (prev[k] != -1) {
                        next[prev[k]] = next[k];
                    }
                    if (next[k] != -1) {
                        prev[next[k]] = prev[k];
                    }
                    // 선택된 행 삭제 > 아래 행으로 이동, 단 if 선택된 행 삭제 행이 마지막 행: 위로 이동
                    k = next[k] == -1 ? prev[k] : next[k];
                    break;
                case 'Z':
                    int z = st.pop();
                    isDeleted[z] = false;
                    // 연결 다시 조립
                    if (prev[z] != -1) {
                        next[prev[z]] = z;
                    }
                    if (next[z] != -1) {
                        prev[next[z]] = z;
                    }
                    // 단, 현재 선택된 행은 바뀌지 않습니다.
                    break;
            }
        }

        // 삭제되지 않은 행은 O, 삭제된 행은 X로 표시하여 문자열 형태로 return
        StringBuilder sb = new StringBuilder();

        for (boolean b : isDeleted) {
            if (b == true) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }
    
        return sb.toString();
    }
}
