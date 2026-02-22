import stack.TableEditSolution;

public class TestSolution {
    public static void main(String[] args) {
        // Table Edit Test
        testTableEdit();
    }

    private static void testTableEdit() {
        TableEditSolution solver = new TableEditSolution();
        System.out.println("\n--- Table Edit Test ---");
        int n = 8;
        int k = 2;
        String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
        String expected = "OOOOXOOO";
        String result = solver.solution(n, k, cmd);

        System.out.println("Test Case 1: " + (expected.equals(result) ? "PASS" : "FAIL"));
        if (!expected.equals(result)) {
            System.out.println("  Expected: " + expected);
            System.out.println("  Actual:   " + result);
        }
    }
}
