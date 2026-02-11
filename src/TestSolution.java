/*
 * n^2 Array Slicing Problem 
 */

public class TestSolution {
    public int[] solution(int n, long left, long right) {
        // [재도전 퀘스트: 내일의 나에게]
        // 1. 결과 배열 크기 설정 (right - left + 1)
        int len = (int) (right - left + 1);
        int[] arr = new int[len];

        // 2. 반복문 제어 (결과 배열 index 0부터 len-1까지)
        for (int i = 0; i < len; i++) {
            // 3. 실제 인덱스 k 소환 (left + i)
            long k = left + i;

            // 4. n차 격자 좌표 매핑 (row = k / n, col = k % n)
            long row = k / n;
            long col = k % n;

            // 5. 규칙 적용 (Math.max(row, col) + 1)
            // ? [비밀 단서 1] 세상 전체의 크기(n^2)는 long이지만, 한 줄의 길이(n)는 int 범위임을 기억하라.
            // ? [비밀 단서 2] 보물은 전체 지도(k번지)에 있지만, 내 가방(arr)은 0번(i)부터 채워야 한다.
            // ! 이제야 깨달았음. value는 이미 2차원에서 정해진 값인데, 그것을 1차원으로 자른 것이고, 그 부분을 left, right에 따라
            //! 슬라이딩 윈도우처럼 움직이는 구조이기 때문에 고정값인 value를 1차원으로 설정한 arr에 반복문으로 채워나가기만 하면 되는거였음.
            arr[i] = (int) Math.max(row, col) + 1;
        }

        return arr;
    }
}
