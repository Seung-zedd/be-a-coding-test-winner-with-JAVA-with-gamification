package stack;

import java.util.*;

/*
param: "N x N 크기의 정방행렬"이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다. 
Q. 크레인과 바구니는 무엇을 의미? 
A. 바구니는 스택을 의미(아래부터 차곡차곡 쌓임)
그리고 크레인은 board의 col을 의미

각 격자 칸에는 다양한 인형이 들어 있으며 
=> unique value 암시

인형이 없는 칸은 빈칸입니다. 
=> 빈칸에는 0

모든 인형은 "1 x 1" 크기의 격자 한 칸을 차지하며
=> 원소 하나만 존재(이건 당연함, 왜냐하면 2D Array의 각 격자에는 원소 하나만 존재할 수 밖에 없기 때문)
    
격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다. 
=> ??? 원래는 arr[r][c]으로 초기화하고, fori, forj로 arr_00부터 순회하는데 아래 칸부터 쌓여있다??

게임 사용자는 크레인을 좌우로 움직여서 
=> arr의 col을 움직여서

멈춘 위치에서 "가장 위에 있는 인형"을 집어 올릴 수 있습니다. => 가장 위에 있는 row를 선택

만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 "두 인형은 터뜨려지면서" 바구니에서 사라지게 됩니다.
=> Valid Parenthesis 로직과 유사, but Stack<Integer>로 LIFO 구조를 활용해서 훨씬 쉽게 구현할 수 있음

크레인 작동 시 인형이 집어지지 않는 경우는 없으나 
=> 원소가 존재하면 무조건 인형을 집어야함.

만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다. 
=> if 원소 존재 x(원소가 0): 그대로 continue

또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. 
=> 어짜피 컬렉션 프레임워크의 Stack은 dynamic capacity이기 때문에 상관 x

param: 2D board, 
        moves => board의 col만 움직임
요구사항: 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return

- 제약 조건 - 
1. 5 x 5 <= N x N <= 30 x 30 = 900 ≒ 10^3
2. 0<= board[r][c] <= 100
    2.1. 0은 빈칸을 의미
    if 만약 인형이 없는 곳에서 크레인을 작동시키는 경우 => if board[r][c] == 0:
    2.2. 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.(즉, unique하지 않을 수 있음)
3. 1 <= moves.length <= 10^3
    3.1. 1 <= moves[i] <= board[c]
*/

public class CraneClawMachineSolution {
    public int solution(int[][] board, int[] moves) {
        // 1. 바구니(스택) 초기화
        Stack<Integer> s = new Stack<>();
        int r = board.length;
        // 2. 크레인을 먼저 움직임
        // moves의 원소가 크레인의 위치를 의미하므로 for-each문으로 순회
        int answer = 0;
        for (int m : moves) {
            // row를 순회
            for (int i = 0; i < r; i++) {
                if (board[i][m - 1] == 0) {
                    continue;
                } else {
                    s.push(board[i][m - 1]);
                    // 같은 원소의 값이 존재하는지 검증
                    answer += AfterExploding(s);
                    board[i][m - 1] = 0; // 인형 꺼냄
                    break; // moves는 1번만 움직이기 때문
                }
            }
        }

        return answer;
    }

    private static int AfterExploding(Stack<Integer> s) {
        // stack의 top 이전 원소와 현재 들어가고 있는 값을 비교
        if (!s.isEmpty() && (s.size() > 1 && (s.get(s.size() - 2) == s.peek()))) {
            // 2개를 터뜨림
            s.pop();
            s.pop();

            return 2;
        }

        return 0;
    }
}
