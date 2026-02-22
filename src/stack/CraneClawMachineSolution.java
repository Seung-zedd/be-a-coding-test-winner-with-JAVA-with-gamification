package stack;

import java.util.*;

/*
<문제 지문 해석>
"N x N" 크기의 정사각 격자
=> row와 col을 추출

위쪽에는 크레인이 있고 오른쪽에는 바구니
=> 크레인과 바구니가 무엇을 의미? -> 크레인은 moves, 바구니는 스택

인형이 없는 칸은 빈칸
=> 아래의 지문에서 크레인으로 인형을 집어올리면(스택에 원소가 푸시되면) 해당 좌표의 원소값은 0으로 만들어야함

크레인을 좌우로 움직여서 
=> col만 움직일 수 있음

멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다.
=> 멈춘 col 위치에서 row로 순회한다는 것을 의미

이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다. 
=> 아! 바구니는 스택을 의미하는구나?

만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다. 
=> stack[top - 1] == stack[top]: stack.pop() 두번

만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
=> if (board[r][c] == 0): continue;

바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. 
=> 스택은 가변 크기니까, 정적 배열로 사용하지 말라는 의미!

크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return
=> moves 순회가 끝나면 stack.pop()의 카운트를 리턴

- 제약 조건 - 
1. 5 x 5 <= board.length <= 30 x 30 = 10^3
2. 0 <= board[r][c] <= 100
    2.1. 0 == 빈칸
    2.2. 같은 숫자: 같은 모양의 인형
3. 1 <= moves.length <= 10^3
    3.1. 1 <= moves[i] <= board[c] == 30

<코드 설계>
예시) 크레인이 [1, 5, 3, 5, 1, 2, 1, 4] 번 위치에서 차례대로 인형을 집어서 바구니에 옮겨 담은 후
=> 1. moves를 순회
2. stack.push(board[r][c])
    2.1. stack 안에서 if (stack[top - 1] == stack[top]): stack.pop()을 푸시할 때마다 검증
    2.2. 인형을 집었으니까 해당 board의 좌표의 원소값은 0으로 설정
3. moves 순회가 끝나면 stack.pop()한 count를 리턴

*/

public class CraneClawMachineSolution {
    public int solution(int[][] board, int[] moves) {
        int count = 0;

        // 1. board의 row, col 추출
        int r = board.length;

        // 바구니 소환
        Stack<Integer> s = new Stack<>();

        // 2. 크레인 작동
        // moves[i]는 해당 board의 col이므로 고정시켜야함
        // 크레인은 한번만 작동 -> 스택에 담았으면 break로 다음 m 순회
        // 10^6 < 10^8이므로 이중 for문 가능!
        for (int m : moves) {
            for (int i = 0; i < r; i++) {
                // 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다.
                // moves의 길이가 1부터 시작하므로 zero-based로 맞춘다
                if (board[i][m - 1] == 0) {
                    continue;
                } else {
                    s.push(board[i][m - 1]);
                    board[i][m - 1] = 0;
                    count += afterExploding(s);
                    break;
                }
                
            }
        }

        return count;
    }

    private static int afterExploding(Stack<Integer> s) {
        // stack 안에서 if (stack[top - 1] == stack[top]): stack.pop()을 푸시할 때마다 검증
        //! stack도 마찬가지로 0부터 시작하기 떄문에 1을 빼줘서 보정을 해줘야함
        if (s.size() > 1 && (s.get(s.size() - 2) == s.peek())) {
            s.pop();
            s.pop();
            return 2;
        } else {
            return 0;
        }
    }
}
