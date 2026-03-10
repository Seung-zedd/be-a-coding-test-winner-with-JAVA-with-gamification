import hash.MakeSumSolution;

public class TestSolution {
    public static void main(String[] args) {
        // [복습] Card Deck Quest (Lv. 1 Review: 2회차)
        // testCardDeck();

        // [신규] Make Sum Quest (Quest 18: Hash)
        testMakeSum();
    }

    private static void testCardDeck() {
        queue.CardDeckSolution solver = new queue.CardDeckSolution();
        System.out.println("\n--- [복습] (Card Deck) ---");

        // Case 1
        String[] c1_1 = { "i", "drink", "water" };
        String[] c2_1 = { "want", "to" };
        String[] g1 = { "i", "want", "to", "drink", "water" };
        String res1 = solver.solution(c1_1, c2_1, g1);
        System.out.println("Test Case 1: " + ("Yes".equals(res1) ? "PASS" : "FAIL"));

        // Case 2
        String[] c1_2 = { "i", "water", "drink" };
        String[] c2_2 = { "want", "to" };
        String[] g2 = { "i", "want", "to", "drink", "water" };
        String res2 = solver.solution(c1_2, c2_2, g2);
        System.out.println("Test Case 2: " + ("No".equals(res2) ? "PASS" : "FAIL"));
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
}
