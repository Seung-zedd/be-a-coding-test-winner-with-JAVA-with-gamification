import queue.FunDevSolution;
import queue.CardDeckSolution;
import stack.TableEditSolution;
import hash.MakeSumSolution;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        // [복습] Table Edit Quest (Lv. 2 Review: 3회차)
        // testTableEdit();

        // [복습] Function Development Quest (Lv. 1 Review: 1회차)
        testFunDev();

        // [신규] Make Sum Quest (Quest 18: Hash)
        // testMakeSum();

        // [복습] Card Deck Quest (Lv. 1 Review: 1회차)
        // testCardDeck();
    }

    private static void testTableEdit() {
        TableEditSolution solver = new TableEditSolution();
        System.out.println("\n--- [복습] (Table Edit) ---");
        int n = 8;
        int k = 2;
        String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
        String expected = "OOOOXOOO";
        String result = solver.solution(n, k, cmd);
        System.out.println("Test Case 1: " + (expected.equals(result) ? "PASS" : "FAIL"));
        System.out.println("Result: " + result);
    }

    private static void testFunDev() {
        FunDevSolution solver = new FunDevSolution();
        System.out.println("\n--- [복습] (Function Development) ---");

        // Case 1
        int[] p1 = { 93, 30, 55 };
        int[] s1 = { 1, 30, 5 };
        int[] exp1 = { 2, 1 };
        int[] res1 = solver.solution(p1, s1);
        System.out.println("Test Case 1: " + (Arrays.equals(exp1, res1) ? "PASS" : "FAIL"));
        System.out.println("Result: " + Arrays.toString(res1));

        // Case 2
        int[] p2 = { 95, 90, 99, 99, 80, 99 };
        int[] s2 = { 1, 1, 1, 1, 1, 1 };
        int[] exp2 = { 1, 3, 2 };
        int[] res2 = solver.solution(p2, s2);
        System.out.println("Test Case 2: " + (Arrays.equals(exp2, res2) ? "PASS" : "FAIL"));
        System.out.println("Result: " + Arrays.toString(res2));
    }

    private static void testMakeSum() {
        MakeSumSolution solver = new MakeSumSolution();
        System.out.println("\n--- [신규] (Make Sum - Quest 18) ---");

        // Case 1
        int[] arr1 = { 1, 2, 3, 4, 8 };
        int target1 = 6;
        boolean res1 = solver.solution(arr1, target1);
        System.out.println("Test Case 1: " + (res1 == true ? "PASS" : "FAIL"));
        System.out.println("Result: " + res1);

        // Case 2
        int[] arr2 = { 2, 3, 5, 9 };
        int target2 = 10;
        boolean res2 = solver.solution(arr2, target2);
        System.out.println("Test Case 2: " + (res2 == false ? "PASS" : "FAIL"));
        System.out.println("Result: " + res2);
    }

    private static void testCardDeck() {
        CardDeckSolution solver = new CardDeckSolution();
        System.out.println("\n--- [복습] (Card Deck) ---");

        // Case 1
        String[] c1_1 = { "i", "drink", "water" };
        String[] c2_1 = { "want", "to" };
        String[] g1 = { "i", "want", "to", "drink", "water" };
        String result1 = solver.solution(c1_1, c2_1, g1);
        System.out.println("Test Case 1: " + ("Yes".equals(result1) ? "PASS" : "FAIL"));
        System.out.println("Result: " + result1);

        // Case 2
        String[] c1_2 = { "i", "water", "drink" };
        String[] c2_2 = { "want", "to" };
        String[] g2 = { "i", "want", "to", "drink", "water" };
        String result2 = solver.solution(c1_2, c2_2, g2);
        System.out.println("Test Case 2: " + ("No".equals(result2) ? "PASS" : "FAIL"));
        System.out.println("Result: " + result2);
    }
}
