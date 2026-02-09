/*
 * n^2 Array Slicing Problem
 */

public class TestSolution {
    public int[] solution(int n, long left, long right) {
        // [재도전 퀘스트: 내일의 나에게]
        // 1. 결과 배열 크기 설정 (right - left + 1)
        // 2. 반복문 제어 (결과 배열 index 0부터 len-1까지)
        // 3. 실제 인덱스 k 소환 (left + i)
        // 4. n차 격자 좌표 매핑 (row = k / n, col = k % n)
        // 5. 규칙 적용 (Math.max(row, col) + 1)

        // ? [비밀 단서 1] 세상 전체의 크기(n^2)는 long이지만, 한 줄의 길이(n)는 int 범위임을 기억하라.
        // ? [비밀 단서 2] 보물은 전체 지도(k번지)에 있지만, 내 가방(arr)은 0번(i)부터 채워야 한다.

        return null; // 내일의 용사여, 이곳을 다시 정복하시오!
    }
}
