
public class TestSolution {
    public static void main(String[] args) {
        // [신규] Uncompleted Player Quest (Quest 19: Hash) - Veteran Exemption Applied
        testUncompletedPlayer();
    }

    private static void testUncompletedPlayer() {
        hash.UncompletedPlayerSolution solver = new hash.UncompletedPlayerSolution();
        System.out.println("\n--- [신규] (Uncompleted Player - Quest 19) ---");

        // Case 1
        String[] p1 = { "leo", "kiki", "eden" };
        String[] c1 = { "eden", "kiki" };
        String res1 = solver.solution(p1, c1);
        System.out.println("Test Case 1: " + ("leo".equals(res1) ? "PASS" : "FAIL"));
        System.out.println("Result: " + res1);

        // Case 2
        String[] p2 = { "marina", "josipa", "nikola", "vinko", "filipa" };
        String[] c2 = { "josipa", "filipa", "marina", "nikola" };
        String res2 = solver.solution(p2, c2);
        System.out.println("Test Case 2: " + ("vinko".equals(res2) ? "PASS" : "FAIL"));
        System.out.println("Result: " + res2);

        // Case 3 (동명이인)
        String[] p3 = { "mislav", "stanko", "mislav", "ana" };
        String[] c3 = { "stanko", "ana", "mislav" };
        String res3 = solver.solution(p3, c3);
        System.out.println("Test Case 3: " + ("mislav".equals(res3) ? "PASS" : "FAIL"));
        System.out.println("Result: " + res3);
    }
}
