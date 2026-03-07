package stack;

import java.util.*;

public class TableEditSolution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];

        // 표 초기화(0 <= k <= n - 1)
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1; // -1은 없음을 의미
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        // 행 제거 및 복구를 위한 스택
        Deque<Integer> st = new ArrayDeque<>();

        // 삭제 상태 표시를 위한 배열
        boolean[] isDeleted = new boolean[n];

        // 명령어 순회
        for (String s : cmd) {
            Character command = s.charAt(0);

            switch (command) {
                case 'U':
                    int x = Integer.parseInt(s.substring(2));
                    // 행을 위로 이동
                    while (x-- > 0) {
                        k = prev[k];
                    }
                    break;
                case 'D':
                    int y = Integer.parseInt(s.substring(2));
                    // 행을 아래로 이동
                    while (y-- > 0) {
                        k = next[k];
                    }
                    break;
                case 'C':
                    // 선택된 행을 제거
                    st.push(k);
                    isDeleted[k] = true;

                    // 연결을 끊고 다음 부분으로 연결
                    if (prev[k] != -1) {
                        next[prev[k]] = next[k];
                    }
                    if (next[k] != -1) {
                        prev[next[k]] = prev[k];
                    }
                    // 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
                    k = next[k] == -1 ? prev[k] : next[k];
                    break;
                case 'Z':
                    // 선택된 행을 복구
                    int z = st.pop();
                    isDeleted[z] = false;

                    // 끊겨진 연결을 다시 재연결
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

        StringBuilder sb = new StringBuilder();
        // 삭제되지 않은 행은 O, 삭제된 행은 X로 표시
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
