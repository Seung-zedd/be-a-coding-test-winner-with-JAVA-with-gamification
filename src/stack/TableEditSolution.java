package stack;

import java.util.*;

/**
 * [복습] 문제 14: 표 편집 (Table Edit)
 * "현재 선택된 행"이 문제 지문에서 가장 중요한 부분을 차지함. 왜 why? 'Z' 복구에서도 "단, 현재 선택된 행은 바뀌지
 * 않습니다."라고 못을 박아놨기 때문
 * 
 * 
 * 3. n=10^6, cmd=2*10^5 규모의 효율성 테스트를 통과해야 합니다.
 */
public class TableEditSolution {
    public String solution(int n, int k, String[] cmd) {
        // 행의 개수만큼 prev와 next의 개수를 초기화
        int[] prev = new int[n];
        int[] next = new int[n];

        // 'C'와 'Z'를 수행하기 위한 스택
        Stack<Integer> st = new Stack<>();
        boolean[] isDeleted = new boolean[n];

        // 행의 개수를 초기화
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1; // 0 ≤ k < n이기 때문에 k는 0번부터 시작
            next[i] = i + 1;
        }
        next[n - 1] = -1; // 마찬가지

        // cmd 순회
        for (String s : cmd) {
            // 명령어 매핑
            Character arrow = s.charAt(0);
            // ! 'C'나 'Z'는 X값이 없기 때문에 여기에 int x = Integer.parseInt(s.substring(2));를 작성하면
            // OutOfIndex 에러가 발생함!

            switch (arrow) {
                // X는 1 이상 300,000 이하인 자연수
                case 'U':
                    int x = Integer.parseInt(s.substring(2));
                    while (x-- > 0) {
                        k = prev[k];
                    }
                    break;
                case 'D':
                    int y = Integer.parseInt(s.substring(2));
                    while (y-- > 0) {
                        k = next[k];
                    }
                    break;
                case 'C':
                    // prev[2] = 1, next[1] = 2, next[2] = 3, prev[3] = 2
                    // ! if문의 조건이 참이 되려면 '내 윗집'이 실제로 존재해야 합니다.("1번 사물함한테 2번 말고 3번으로 연결해!"가 가능하기 위해서는
                    // '1번 사물함'이 존재해야 한다.)
                    // * 함성함수의 정의 조건으로 치환해서 생각하면 훨씬 쉽다
                    if (prev[k] != -1) {
                        next[prev[k]] = next[k];
                    }
                    // 마찬가지
                    if (next[k] != -1) {
                        prev[next[k]] = prev[k];
                    }
                    st.push(k);
                    isDeleted[k] = true;
                    // 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
                    // if (next[k] == -1) {
                    // k = prev[k];
                    // } else {
                    // k = next[k];
                    // }
                    k = (next[k] == -1) ? prev[k] : next[k];
                    break;
                case 'Z':
                    int z = st.pop();
                    isDeleted[z] = false;
                    // 가장 최근에 삭제된 행을 원래대로 복구합니다.
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

        // isDeleted 순회해서 O, X 마킹
        // 삭제되지 않은 행은 O, 삭제된 행은 X로 표시
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
