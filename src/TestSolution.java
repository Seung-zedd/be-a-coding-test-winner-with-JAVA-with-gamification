import java.util.Arrays;
import tree.*;

public class TestSolution {
    public static void main(String[] args) {
        // [오늘의 수련 과제 세팅] - Rule 3
        testExpectedTournament(); // [복습] 3회차 (Overdue) - 자동완성 봉인
        // testToothbrushSales(); // [복습] 2회차 (Overdue)
        // testSheepAndWolf(); // [복습] 1회차 (Today)
        // testPathFindingGame(); // [신규] 문제 29
    }

    private static void testExpectedTournament() {
        ExpectedTournamentSolution sol = new ExpectedTournamentSolution();
        System.out.println("\n--- [문제 26] 예상 대진표 Test (Review 3) ---");
        int result = sol.solution(8, 4, 7);
        int expected = 3;
        System.out.println("Case 1: " + (result == expected) + " (Result: " + result + ")");
    }

    private static void testToothbrushSales() {
        ToothbrushSalesSolution sol = new ToothbrushSalesSolution();
        System.out.println("\n--- [문제 27] 다단계 칫솔 판매 Test (Review 2) ---");

        String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaemin", "younghe", "edane" };
        String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaemin", "edward" };
        String[] seller = { "younghe", "john", "edane", "emily", "mary" };
        int[] amount = { 12, 4, 2, 5, 10 };
        int[] expected = { 360, 958, 108, 0, 450, 18, 180, 1080 };

        int[] result = sol.solution(enroll, referral, seller, amount);
        System.out.println("Case 1: " + Arrays.equals(result, expected));
        if (!Arrays.equals(result, expected)) {
            System.out.println("  Expected: " + Arrays.toString(expected));
            System.out.println("  Actual:   " + Arrays.toString(result));
        }
    }

    private static void testSheepAndWolf() {
        SheepAndWolfSolution sol = new SheepAndWolfSolution();
        System.out.println("\n--- [문제 28] 양과 늑대 Test (Review 1) ---");

        int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
                { 4, 6 }, { 8, 9 } };
        int result = sol.solution(info, edges);
        int expected = 5;
        System.out.println("Case 1: " + (result == expected) + " (Result: " + result + ")");
    }

    private static void testPathFindingGame() {
        PathFindingGameSolution sol = new PathFindingGameSolution();
        System.out.println("\n--- [문제 29] 길 찾기 게임 Test (New) ---");

        int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
                { 2, 2 } };
        int[][] expected = { { 7, 4, 6, 9, 1, 8, 5, 2, 3 }, { 9, 6, 5, 8, 1, 4, 3, 2, 7 } };

        int[][] result = sol.solution(nodeinfo);
        System.out.println("Case 1: " + (result.length > 0 && Arrays.deepEquals(result, expected)));
        if (result.length > 0 && !Arrays.deepEquals(result, expected)) {
            System.out.println("  Actual Preorder:  " + Arrays.toString(result[0]));
            System.out.println("  Actual Postorder: " + Arrays.toString(result[1]));
        }
    }
}
