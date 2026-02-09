package array;

import java.util.*;
import java.util.stream.Collectors;
/*
1. 10^2 * 10^2 = 10^4 < 10^8이므로 완전탐색 가능!

<코드 설계>
1. 행벡터와 열벡터를 각각 저장할 크기 100인 리스트를 초기화(1차원 배열은 원소 1개만 저장 가능하므로)
2. 각각의 벡터를 (x, y) 좌표로 치환해서 생각
    2.1. Coordinate라는 커스텀 클래스 생성 필요




 */


public class MatrixMulSolution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. 행렬 곱의 size = (m x k) x (k x n) = m x n
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        int[][] answer = new int[r1][c2]; // 리턴할 정답 배열

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                // 내부 차원에서의 성분 곱
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
