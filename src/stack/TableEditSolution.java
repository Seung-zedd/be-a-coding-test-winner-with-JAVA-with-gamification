package stack;

import java.util.*;

/*
명령어 기반으로 표의 행을 선택, 삭제, 복구하는 프로그램을 작성하는 과제
-> 명령어를 for문으로 돌려서 선택, 삭제, 복구하는 로직을 구현하라는 의미

위 그림에서 파란색으로 칠해진 칸은 '현재 선택된 행'을 나타냅니다. 
//? -> 선택된 행이 무엇을 의미하는거지?

단, 한 번에 한 행만 선택할 수 있으며, 표의 범위(0행 ~ 마지막 행)를 벗어날 수 없습니다.
-> 0 <= 선택된 행 < n.length

이때, 다음과 같은 명령어를 이용하여 표를 편집합니다.
-> 위의 한 번에 한 행만 선택할 수 있는 현재 선택된 행의 지문과 연결

"U X": '현재 선택된 행'에서 X칸 위에 있는 행을 선택합니다.
"D X": '현재 선택된 행'에서 X칸 아래에 있는 행을 선택합니다.
"C" : 현재 선택된 행을 '삭제'한 후, 
        -> 삭제를 위한 무언가의 장치가 필요 -> 스택!

바로 아래 행을 선택합니다. 
-> '현재 선택된 행'을 아래 행으로 이동
        
단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
-> if 삭제된 '현재 선택된 행'이 n-1: 위의 행으로 이동

"Z" : '가장 최근에 삭제된 행'을 '원래대로 복구'합니다. 
-> 스택은 LIFO 구조이기 때문에 적절!, 이때 스택은 행 타입이 들어가야함.
-> 또한, 원래의 행으로 복구해야 하기 때문에 원래 행에 대한 기억이 필요
단, 현재 선택된 행은 바뀌지 않습니다.
-> 선택된 행은 그대로(포인터 유지) 

[입력]
n: 처음 표의 행 개수를 나타내는 정수
k: 처음에 선택된 행의 위치를 나타내는 정수 
cmd: 수행한 명령어들이 담긴 문자열 배열

[요구사항]
모든 명령어를 수행한 후 
-> cmd를 for문으로 다 순회한 후

'표의 상태와 처음 주어진 표의 상태를 비교하여'
-> 상태 == boolean 타입의 플래그로 비교하라는 의미

삭제되지 않은 행은 O, 
        
삭제된 행은 X로 표시하여 
-> 스택에 들어가있는 행을 의미

문자열 형태로 return
-> 여기서 StringBuilder를 사용함으로써 O(N^2) 방지!

[제한사항]
1. 5 ≤ n ≤ 10^6
-> 반드시 O(N)으로만 하라는 의미
2. 0 ≤ k < n
3. 1 ≤ cmd의 원소 개수 ≤ 2* 10^5
-> 마찬가지로 O(N)만 가능
    3.1. cmd의 각 원소는 "U X", "D X", "C", "Z" 중 하나
    -> 바로 switch-case 문이 떠오름.

    3.2. X는 1 이상 300,000 이하인 자연수이며 0으로 시작하지 않습니다.

    3.3. X가 나타내는 자연수에 ',' 는 주어지지 않습니다.
    -> 그냥 파싱하라는 의미

    3.4. cmd에 등장하는 모든 X들의 값을 합친 결과가 1,000,000 이하인 경우만 입력으로 주어집니다.
    -> 아무리 커도 n보다 크지 않다는 의미(O(N))

    3.5. 표의 모든 행을 제거하여, 행이 하나도 남지 않는 경우는 입력으로 주어지지 않습니다.
    -> 문자열 리턴값에 모두 "O"인 값은 없다는 의미

    3.6. "이름"열에는 서로 다른 이름들이 중복없이 채워져 있다고 가정하고 문제를 해결해주세요
    -> 포인터나 인덱스로 행을 이동하라는 의미(모든 행은 unique하다)

    3.7. 표의 범위를 벗어나는 이동은 입력으로 주어지지 않습니다.
    -> isValid() 같은 유효 검사 로직 구현할 필요 X

    3.8.원래대로 복구할 행이 없을 때(즉, 삭제된 행이 없을 때) "Z"가 명령어로 주어지는 경우는 없습니다.
    -> 역시 예외 로직 짤 필요 X

    3.9. 정답은 표의 0행부터 n - 1행까지에 해당되는 O, X를 순서대로 이어붙인 문자열 형태로 return
    -> boolean 타입의 상태 배열을 표의 크기로 초기화
*/

/*
[코드 설계]
1. cmd를 for문으로 순회
 1.1. 그 안에서 switch-case문으로 cmd 문자열 배열을 명령어와 X로 파싱
2. 표의 상태와 처음 주어진 표의 상태를 비교하기 위한 boolean 타입의 isDeleted 배열을 표의 크기로 초기화
3. 여기서 StringBuilder를 사용함으로써 O(N^2) 방지!
4. isDeleted를 for문으로 순회
 4.1. 삭제되지 않은 행은 O == false면 "O"
 4.2. 삭제된 행은 X == true면 "X"
 로 append()

5. return sb.toString()

*/

public class TableEditSolution {
    public String solution(int n, int k, String[] cmd) {
        // 표를 Doubly-Linked List로 접근하기 위해 원시 배열로 초기화
        int[] prev = new int[n];
        int[] next = new int[n];

        // 표를 크기 n만큼 초기화(0 ~ n - 1)
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1; // -1로 없음을 표시
            next[i] = i + 1;
        }
        next[n - 1] = -1; // n 행은 없음

        // 스택 초기화
        Stack<Integer> s = new Stack<>();

        // 표의 상태와 처음 주어진 표의 상태를 비교하기 위한 boolean 타입의 isDeleted 배열을 표의 크기로 초기화
        boolean[] isDeleted = new boolean[n];

        // cmd 순회
        // ? 프레임워크(스택, 큐, 해시맵 등)를 읽으면서 동시에 쓰기를 진행하면 ConcurrentException이 터짐, But 컨테이너
        // 타입이 아닌 것은 상관 X
        for (String str : cmd) {
            String result = str;
            Character command = result.charAt(0); // 명령어

            switch (command) {
                case 'U':
                    // ! X가 없으면 예외가 터지기 때문에 X가 존재하는 'U' 아니면 'D'에서만 파싱을 한다
                    int x = Integer.parseInt(result.substring(2)); // 횟수
                    while (x-- > 0) {
                        k = prev[k]; // 현재 선택된 행인 k를 위로 이동(e.g. k = 2이면, prev[k]인 1을 k로 업데이트)
                    }
                    break;
                case 'D':
                    int y = Integer.parseInt(result.substring(2)); // 횟수
                    while (y-- > 0) {
                        k = next[k]; // 현재 선택된 행인 k를 위로 이동
                    }
                    break;
                case 'C':
                    // 현재 선택된 행을 '삭제'
                    s.push(k);

                    // 삭제 상태를 표시
                    isDeleted[k] = true;

                    // 다음 행으로 연결하기 위해서는 이전 행이 존재해야 한다.
                    if (prev[k] != -1) {
                        next[prev[k]] = next[k];
                    }
                    if (next[k] != -1) {
                        prev[next[k]] = prev[k];
                    }

                    // 바로 아래 행을 선택, 단, 현재 선택된 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택
                    k = next[k] == -1 ? prev[k] : next[k];
                    break;

                case 'Z':
                    // '가장 최근에 삭제된 행'을 '원래대로 복구'
                    int z = s.pop();

                    // 삭제 상태를 복구
                    isDeleted[z] = false;

                    // ? z에 대한 연결은 이미 표를 크기 n만큼 초기화에서 연결이 되어있기 때문에 끊어진 연결만 다시 원복시켜주면 됨
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

        

        // 3. 여기서 StringBuilder를 사용함으로써 O(N^2) 방지!
        StringBuilder sb = new StringBuilder();

        // 4. isDeleted를 for문으로 순회
        for (boolean b : isDeleted) {
            // 4.1. 삭제되지 않은 행은 O == false면 "O"
            if (b == false) {
                sb.append("O");
            } else {
                // 4.2. 삭제된 행은 X == true면 "X"
                sb.append("X");
            }
        }

        // 5. return sb.toString()
        return sb.toString();
    }
}
