package stack;

import java.util.*;

/*
 * [문제 14] 표 편집 (Programmers Lv. 3)
 * 핵심 포인트: 엑셀의 행 관리 시스템을 "원시 자료구조(배열)"로 구현하여 효율성 극대화
 * 
 * 1. 지문 분석 및 제약 조건 파훼
 *  - n = 10^7, cmd = 2 * 10^6: 객체 기반 자료구조(Node, HashMap) 사용 시 메모리 초과(OOM) 가능성 매우 높음.
 *  - "U X", "D X": 삭제된 행을 건너뛰어야 함. 산술 연산(k-X)이 아닌 '논리적 이동' 필요.
 *  - "C": 삭제 시 다음 행 선택, 마지막 행이면 윗 행 선택. 행 번호는 변하지 않음(데이터 불변성).
 *  - "Z": LIFO(마지막에 삭제된 순) 복구 -> 스택 사용 필수.
 *  - 누적 X 합계 <= 10^7: 연결 리스트의 노드 탐색(Link Traversal)을 다 합쳐도 O(N) 급으로 가능함.
 *  - 효율적 리턴: String + 루프(O(N^2)) 금지 -> StringBuilder(O(N)) 사용 필수.
 * 
 * 2. 전술적 설계 (Data Structures - 원시 배열 포인터 전술)
 *  - int[] prev, next: i번째 행의 위/아래 행 번호를 저장하는 '배열 기반 Doubly Linked List'.
 *  - boolean[] isDeleted: 각 행의 삭제 여부를 마킹하는 플래그 (BFS/DFS의 visited와 유사한 원리).
 *  - Stack<Integer> deleted: 삭제된 행 번호를 저장하여 복구 순서 관리.
 * 
 * 3. 커맨드별 작동 원리
 *  - 이동(U/D): k = next[k] 또는 k = prev[k]를 X번 반복하여 '살아있는 이웃'으로 점프.
 *  - 삭제(C): 
 *      - deleted.push(k), isDeleted[k] = true
 *      - 내 윗집의 아랫집을 내 아랫집으로 연결: next[prev[k]] = next[k]
 *      - 내 아랫집의 윗집을 내 윗집으로 연결: prev[next[k]] = prev[k]
 *      - 현재 위치 이동: k = (next[k] == -1) ? prev[k] : next[k]
 *  - 복구(Z):
 *      - r = deleted.pop(), isDeleted[r] = false 마킹 해제.
 *      - 내 윗집의 아랫집을 다시 나로 연결: next[prev[r]] = r
 *      - 내 아랫집의 윗집을 다시 나로 연결: prev[next[r]] = r
 * 
 * 4. 최종 결과 도출
 *  - 루프 밖에서 단 하나의 StringBuilder를 생성하여 append() 후 toString()으로 마무리.
 */
public class TableEditSolution {
    public String solution(int n, int k, String[] cmd) {
        // ! 기존의 Node 객체로 더블링크드리스트를 구현하면 OOM이 터지니 배열 기반으로 구현
        // 객체 대신 인덱스로 연결하기(배열의 인덱스를 포인터처럼 사용)
        int[] prev = new int[n];
        int[] next = new int[n];

        // n만큼 초기화
        // ? prev[i] 또는 next[i]는 행 번호이면서 동시에 포인터 역할을 함
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1; // 0번 이전은 없으니까 -1 표시
            next[i] = i + 1; // 마찬가지로 n번 다음은 없으니까 그대로 n + 1 표시
        }
        next[n - 1] = -1; // n-1번째 다음은 없으므로 -1 표시

        // 삭제된 행 복구를 위한 스택
        // 행 번호를 그대로 더블리링크드리스트에 삽입하기 위해 행번호 int 타입을 사용
        Stack<Integer> s = new Stack<>();
        boolean[] isDeleted = new boolean[n];

        // cmd의 X를 i로 매핑
        for (String c : cmd) {
            // ! split()을 사용하면 result[1]을 참조하려고 하면 ArrayIndexOutOfBoundsException이 발생하기 때문에
            // 안전하게 substring으로 X를 파싱
            Character arrow = c.charAt(0);

            // 위에서 선언했던 배열 인덱스를 포인터로 사용(즉, 현재 가리키는 행인 k를 포인터로 사용)
            switch (arrow) {
                // U이면 X만큼 이동
                case 'U':
                    int x = Integer.parseInt(c.substring(2));
                    while (x-- > 0) {
                        k = prev[k]; // int 타입은 값을 복사하므로, k가 이전 행으로 업데이트(≒ ptr = ptr.prev;)
                    }
                    break;
                case 'D':
                    int y = Integer.parseInt(c.substring(2));
                    while (y-- > 0) {
                        k = next[k]; // 마찬가지로 k가 다음 행으로 업데이트(≒ ptr = ptr.next;)
                    }
                    break;
                case 'C':
                    // 삭제한 행을 스택에 푸시하고 삭제된 행번호를 true로 마킹
                    s.push(k);
                    isDeleted[k] = true;

                    // ? 행끼리 연결하기 위해서는 행이 존재해야 된다, 즉 prev[k] 또는 next[k]가 존재해야 한다는 말
                    //* Singly Linked List가 익숙하기 때문에 다음 행 연결을 먼저 작성하였음.
                    // "2번 말고 3번으로 가!"가 실행되기 위해서는 k가 가리키고 있는 행의 이전 행이 존재해야 함
                    if (prev[k] != -1) {
                        next[prev[k]] = next[k];
                    }
                    // "2번 말고 1번으로 가!"가 실행되기 위해서는 k가 가리키고 있는 행의 다음 행이 존재해야 함
                    if (next[k] != -1) {
                        prev[next[k]] = prev[k];
                    }

                    // 현재 위치 이동: 다음 행이 없으면 위로(마지막 행 삭제 시), 있으면 아래로
                    k = (next[k] == -1) ? prev[k] : next[k];
                    break;
                case 'Z':
                    //? 2번 사물함 안의 메모지는 여전히 "내 왼쪽은 1번, 오른쪽은 3번"을 기억하고 있음
                    // 삭제한 행을 다시 복구하는데, 위의 'C'에서 사용한 k가 z로만 변경된 것에 불과
                    int z = s.pop();
                    isDeleted[z] = false;
                    // "이제 3번 말고 2번과 연결해"!가 실행되기 위해서는 복구한 2번을 그대로 연결만 하면 됨
                    if (prev[z] != -1) {
                        next[prev[z]] = z; // z가 복구한 숫자
                    }
                    if (next[z] != -1) {
                        prev[next[z]] = z; // 마찬가지
                    }
                    break;
            }

        }
        //! 루프 안에서 "+" 연산자를 사용하면 객체를 2배로 복사하기 때문에 O(N^2)이 걸려서 시간 초과! -> StringBuilder 객체를 사용
        StringBuilder sb = new StringBuilder();

        for (boolean b : isDeleted) {
            if (b == true) {
                sb.append("X"); // 삭제된 행은 X
            } else {
                sb.append("O");
            }
        }

        return sb.toString();
    };

}
