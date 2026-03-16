
public class TestSolution {
    public static void main(String[] args) {
        // [복습 1회차] Quest 20 - Discount Promotion
        // testDiscountPromotion();

        // [복습 4회차] Quest 17 - Card Deck
        // testCardDeck();

        // [신규] Quest 21 - Open Chat
        // testOpenChat();

        // [마스터 도전] Quest 15 - Josephus Problem
        // testJosephus();

        // [마스터 도전] Quest 16 - Function Development
        testFunctionDevelopment();
    }

    private static void testFunctionDevelopment() {
        queue.FunDevSolution solver = new queue.FunDevSolution();
        System.out.println("\n--- [마스터 도전] (Function Development - Quest 16) ---");

        int[] p1 = { 93, 30, 55 };
        int[] s1 = { 1, 30, 5 };
        int[] expected1 = { 2, 1 };
        int[] res1 = solver.solution(p1, s1);
        System.out.println("Test Case 1: " + (java.util.Arrays.equals(res1, expected1) ? "PASS" : "FAIL"));

        int[] p2 = { 95, 90, 99, 99, 80, 99 };
        int[] s2 = { 1, 1, 1, 1, 1, 1 };
        int[] expected2 = { 1, 3, 2 };
        int[] res2 = solver.solution(p2, s2);
        System.out.println("Test Case 2: " + (java.util.Arrays.equals(res2, expected2) ? "PASS" : "FAIL"));
    }

    private static void testJosephus() {
        queue.JosephusSolution solver = new queue.JosephusSolution();
        System.out.println("\n--- [마스터 도전] (Josephus Problem - Quest 15) ---");

        int n1 = 5, k1 = 2;
        int[] expected1 = { 2, 4, 1, 5, 3 };
        int[] res1 = solver.solution(n1, k1);
        System.out.println("Test Case 1 (n=5, k=2): " + (java.util.Arrays.equals(res1, expected1) ? "PASS" : "FAIL"));
        if (!java.util.Arrays.equals(res1, expected1)) {
            System.out.println("Expected: " + java.util.Arrays.toString(expected1));
            System.out.println("Actual: " + java.util.Arrays.toString(res1));
        }

        int n2 = 7, k2 = 3;
        int[] expected2 = { 3, 6, 2, 7, 5, 1, 4 };
        int[] res2 = solver.solution(n2, k2);
        System.out.println("Test Case 2 (n=7, k=3): " + (java.util.Arrays.equals(res2, expected2) ? "PASS" : "FAIL"));
    }

    private static void testDiscountPromotion() {
        hash.DiscountPromotionSolution solver = new hash.DiscountPromotionSolution();
        System.out.println("\n--- [복습 1회차] (Discount Promotion - Quest 20) ---");

        String[] want1 = { "banana", "apple", "rice", "pork", "pot" };
        int[] number1 = { 3, 2, 2, 2, 1 };
        String[] discount1 = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana" };
        int res1 = solver.solution(want1, number1, discount1);
        System.out.println("Test Case 1: " + (res1 == 3 ? "PASS" : "FAIL"));

        String[] want2 = { "apple" };
        int[] number2 = { 10 };
        String[] discount2 = { "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                "banana" };
        int res2 = solver.solution(want2, number2, discount2);
        System.out.println("Test Case 2: " + (res2 == 0 ? "PASS" : "FAIL"));
    }

    private static void testCardDeck() {
        queue.CardDeckSolution solver = new queue.CardDeckSolution();
        System.out.println("\n--- [복습 4회차] (Card Deck - Quest 17) ---");

        String[] c1_1 = { "apple", "strawberry", "banana" };
        String[] c1_2 = { "watermelon", "kiwi" };
        String[] g1 = { "apple", "watermelon", "strawberry", "kiwi", "banana" };
        String res1 = solver.solution(c1_1, c1_2, g1);
        System.out.println("Test Case 1: " + ("Yes".equals(res1) ? "PASS" : "FAIL"));

        String[] c2_1 = { "apple", "strawberry", "banana" };
        String[] c2_2 = { "watermelon", "kiwi" };
        String[] g2 = { "apple", "strawberry", "watermelon", "kiwi", "banana" };
        String res2 = solver.solution(c2_1, c2_2, g2);
        System.out.println("Test Case 2: " + ("Yes".equals(res2) ? "PASS" : "FAIL"));
    }

    private static void testOpenChat() {
        hash.OpenChatSolution solver = new hash.OpenChatSolution();
        System.out.println("\n--- [신규] (Open Chat - Quest 21) ---");

        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };
        String[] expected = { "Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다." };
        String[] res = solver.solution(record);

        if (res == null) {
            System.out.println("Test Case 1: FAIL (Result is null)");
            return;
        }

        boolean match = java.util.Arrays.equals(res, expected);
        System.out.println("Test Case 1: " + (match ? "PASS" : "FAIL"));
        if (!match) {
            System.out.println("Expected: " + java.util.Arrays.toString(expected));
            System.out.println("Actual: " + java.util.Arrays.toString(res));
        }
    }
}
