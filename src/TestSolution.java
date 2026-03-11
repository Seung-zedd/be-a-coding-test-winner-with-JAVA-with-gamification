
public class TestSolution {
    public static void main(String[] args) {
        // [복습] 2회차: Quest 18 - Make Sum
        testMakeSum();

        // [복습] 2회차: Quest 19 - Uncompleted Player
        testUncompletedPlayer();

        // [신규] Quest 20 - Discount Promotion
        // testDiscountPromotion();
    }

    private static void testMakeSum() {
        hash.MakeSumSolution solver = new hash.MakeSumSolution();
        System.out.println("\n--- [복습 2회차] (Make Sum - Quest 18) ---");

        int[] arr1 = { 1, 2, 3, 4, 8 };
        int target1 = 6;
        boolean res1 = solver.solution(arr1, target1);
        System.out.print("Test Case 1: ");
        System.out.println(res1 == true ? "PASS" : "FAIL");

        int[] arr2 = { 2, 3, 5, 9 };
        int target2 = 10;
        boolean res2 = solver.solution(arr2, target2);
        System.out.print("Test Case 2: ");
        System.out.println(res2 == false ? "PASS" : "FAIL");
    }

    private static void testUncompletedPlayer() {
        hash.UncompletedPlayerSolution solver = new hash.UncompletedPlayerSolution();
        System.out.println("\n--- [복습 2회차] (Uncompleted Player - Quest 19) ---");

        String[] p1 = { "leo", "kiki", "eden" };
        String[] c1 = { "eden", "kiki" };
        String res1 = solver.solution(p1, c1);
        System.out.print("Test Case 1: ");
        System.out.println("leo".equals(res1) ? "PASS" : "FAIL");

        String[] p2 = { "marina", "josipa", "nikola", "vinko", "filipa" };
        String[] c2 = { "josipa", "filipa", "marina", "nikola" };
        String res2 = solver.solution(p2, c2);
        System.out.print("Test Case 2: ");
        System.out.println("vinko".equals(res2) ? "PASS" : "FAIL");

        String[] p3 = { "mislav", "stanko", "mislav", "ana" };
        String[] c3 = { "stanko", "ana", "mislav" };
        String res3 = solver.solution(p3, c3);
        System.out.print("Test Case 3: ");
        System.out.println("mislav".equals(res3) ? "PASS" : "FAIL");
    }

    private static void testDiscountPromotion() {
        hash.DiscountPromotionSolution solver = new hash.DiscountPromotionSolution();
        System.out.println("\n--- [신규] (Discount Promotion - Quest 20) ---");

        String[] want1 = { "banana", "apple", "rice", "pork", "pot" };
        int[] number1 = { 3, 2, 2, 2, 1 };
        String[] discount1 = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
                "pot", "banana", "apple", "banana" };
        int res1 = solver.solution(want1, number1, discount1);
        System.out.println("Test Case 1: " + (res1 == 3 ? "PASS" : "FAIL"));
        System.out.println("Result: " + res1);

        String[] want2 = { "apple" };
        int[] number2 = { 10 };
        String[] discount2 = { "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                "banana" };
        int res2 = solver.solution(want2, number2, discount2);
        System.out.println("Test Case 2: " + (res2 == 0 ? "PASS" : "FAIL"));
        System.out.println("Result: " + res2);
    }
}
