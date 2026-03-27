import java.util.*;

public class TestSolution {
    public static void main(String[] args) {
        // [오늘의 퀘스트] 5회차 승급전 시련 (자동완성 봉인 해제 불가)
        // testDiscountPromotion();
        testOpenChat();
    }

    private static void testDiscountPromotion() {
        hash.DiscountPromotionSolution solver = new hash.DiscountPromotionSolution();
        System.out.println("\n--- [5회차 승급전] 할인 행사 (Discount Promotion) ---");

        String[] want = { "banana", "apple", "rice", "pork", "pot" };
        int[] number = { 3, 2, 2, 2, 1 };
        String[] discount = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana" };
        int expected = 3;

        int res = solver.solution(want, number, discount);
        System.out.println("Test Case: " + (res == expected ? "PASS" : "FAIL") + " (Expected: " + expected
                + ", Actual: " + res + ")");
    }

    private static void testOpenChat() {
        hash.OpenChatSolution solver = new hash.OpenChatSolution();
        System.out.println("\n--- [5회차 승급전] 오픈 채팅방 (Open Chat) ---");

        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        String[] expected = {
                "Prodo님이 들어왔습니다.",
                "Ryan님이 들어왔습니다.",
                "Prodo님이 나갔습니다.",
                "Prodo님이 들어왔습니다."
        };

        String[] res = solver.solution(record);
        System.out.println("Test Case: " + (Arrays.equals(res, expected) ? "PASS" : "FAIL"));
        if (!Arrays.equals(res, expected)) {
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(res));
        }
    }
}
