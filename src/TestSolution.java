import queue.JosephusSolution;

public class TestSolution {
    public static void main(String[] args) {
        // Josephus Problem Test
        testJosephus();
    }

    private static void testJosephus() {
        JosephusSolution solver = new JosephusSolution();
        System.out.println("\n--- Josephus Problem Test (BOJ 1158) ---");
        int n = 7;
        int k = 3;
        int[] expected = { 3, 6, 2, 7, 5, 1, 4 };
        int[] result = solver.solution(n, k);

        System.out.print("Result (N=7, K=3): " + java.util.Arrays.toString(result));
        System.out.println(" [" + (java.util.Arrays.equals(expected, result) ? "PASS" : "FAIL") + "]");
    }
}
