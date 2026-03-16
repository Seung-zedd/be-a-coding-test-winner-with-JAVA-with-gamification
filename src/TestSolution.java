
public class TestSolution {
    public static void main(String[] args) {
        // [복습 1회차] Quest 20 - Discount Promotion
        testDiscountPromotion();

        // [복습 4회차] Quest 17 - Card Deck
        // testCardDeck();

        // [신규] Quest 21 - Open Chat
        testOpenChat();
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
