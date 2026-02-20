package array;

public class MatrixMulSolution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 1. 각 row와 col을 추출
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int c2 = arr2[0].length;

        // 2. answer의 크기를 구한다
        int[][] answer = new int[r1][c2];

        // 3. 행렬의 곱셈을 실행해서 answer에 값을 채워넣음
        // arr1의 row를 순회해야할 i, arr2의 row를 순회해야할 j(왜냐하면 2차원 배열은 row를 기준으로 밖에 순회를 못하기 때문)
        // 행렬의 곱을 수행하기 위해 추가적인 인덱스 k가 필요함
        // 시간복잡도: O(10^2 * 10^2 * 10^2) = O(10^6), O.K!
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }

        return answer;
    }
}
