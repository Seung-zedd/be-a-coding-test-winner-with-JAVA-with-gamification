package hash;

// F(N): 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지?

public class ExpectedTournamentSolution {
    public int solution(int n, int a, int b) {
        // base condtion: 둘이 서로 만나면 1 라운드를 따냄
        if ((a + 1) / 2 == (b + 1) / 2) {
            return 1;
        }

        // 현재 상태: A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정, 즉 1라운드 먼저 따냄
        // F(Next): 각 게임에서 이긴 사람은 다음 라운드에 진출할 수 있습니다. 이때, 다음 라운드에 진출할 참가자의 번호는 다시 1번부터 N/2번을 차례대로 배정받습니다. 
        return 1 + solution(n, (a + 1) / 2, (b + 1) / 2);
    }
}
