import stack.CraneClawMachineSolution;

public class TestSolution {
    public static void main(String[] args) {

        // Crane Claw Machine Test
        testCraneClawMachine();
    }

    private static void testCraneClawMachine() {
        CraneClawMachineSolution solver = new CraneClawMachineSolution();
        System.out.println("\n--- Crane Claw Machine Test ---");
        int[][] board = {
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 3 },
                { 0, 2, 5, 0, 1 },
                { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 }
        };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
        int expected = 4;
        int result = solver.solution(board, moves);

        System.out.println("Test Case 1: " + (expected == result ? "PASS" : "FAIL"));
        if (expected != result) {
            System.out.println("  Expected: " + expected);
            System.out.println("  Actual:   " + result);
        }
    }
}
