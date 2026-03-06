import queue.JosephusSolution;
import queue.CardDeckSolution;
import stack.TableEditSolution;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        // [복습] Table Edit Quest (Lv. 2 Review)
        // testTableEdit();

        // [복습] Josephus Problem Quest (Lv. 2 Review)
        testJosephus();

        // [신규] Card Deck Quest
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

    private static void testJosephus() {
        JosephusSolution solver = new JosephusSolution();
        System.out.println("\n--- [복습] (Josephus Problem) ---");
        int n = 7;
        int k = 3;
        int[] expected = { 3, 6, 2, 7, 5, 1, 4 };
        int[] result = solver.solution(n, k);
        System.out.println("Test Case 1: " + (Arrays.equals(expected, result) ? "PASS" : "FAIL"));
        System.out.println("Result: " + Arrays.toString(result));
    }

    private static void testCardDeck() {
        CardDeckSolution solver = new CardDeckSolution();
        System.out.println("\n--- [신규] (Card Deck) ---");

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
