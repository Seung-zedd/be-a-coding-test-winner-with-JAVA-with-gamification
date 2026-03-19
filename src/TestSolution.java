import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        // [훈련] 오늘 정복할 퀘스트 목록
        testDiscountPromotion(); // 1. 할인 행사 (복습 4회차)
        // testOpenChat(); // 2. 오픈 채팅방 (복습 4회차)
        // testBestAlbum(); // 3. 베스트 앨범 (복습 2회차)
    }

    private static void testDiscountPromotion() {
        hash.DiscountPromotionSolution solver = new hash.DiscountPromotionSolution();
        System.out.println("\n--- [복습 4회차] 할인 행사 (Discount Promotion) ---");

        // Test Case 1
        String[] want1 = { "banana", "apple", "rice", "pork", "pot" };
        int[] number1 = { 3, 2, 2, 2, 1 };
        String[] discount1 = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana" };
        int expected1 = 3;
        int res1 = solver.solution(want1, number1, discount1);
        System.out.println("Test Case 1: " + (res1 == expected1 ? "PASS" : "FAIL"));

        // Test Case 2
        String[] want2 = { "apple" };
        int[] number2 = { 10 };
        String[] discount2 = { "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                "banana" };
        int expected2 = 0;
        int res2 = solver.solution(want2, number2, discount2);
        System.out.println("Test Case 2: " + (res2 == expected2 ? "PASS" : "FAIL"));
    }

    private static void testOpenChat() {
        hash.OpenChatSolution solver = new hash.OpenChatSolution();
        System.out.println("\n--- [복습 4회차] 오픈 채팅방 (Open Chat) ---");

        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };
        String[] expected = { "Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다." };
        String[] res = solver.solution(record);

        boolean match = Arrays.equals(res, expected);
        System.out.println("Test Case 1: " + (match ? "PASS" : "FAIL"));
        if (!match) {
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(res));
        }
    }

    private static void testBestAlbum() {
        hash.BestAlbumSolution solver = new hash.BestAlbumSolution();
        System.out.println("\n--- [복습 2회차] 베스트 앨범 (Best Album) ---");

        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        int[] expected = { 4, 1, 3, 0 };
        int[] res = solver.solution(genres, plays);

        boolean match = Arrays.equals(res, expected);
        System.out.println("Test Case 1: " + (match ? "PASS" : "FAIL"));
        if (!match) {
            System.out.println("Expected: " + Arrays.toString(expected));
            System.out.println("Actual: " + Arrays.toString(res));
        }
    }
}
