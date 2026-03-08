import queue.FunDevSolution;
import queue.JosephusSolution;
import hash.MakeSumSolution;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        // [복습] Josephus Problem Quest (Lv. 3 Review: 3회차)
        testJosephus();

        // [복습] Function Development Quest (Lv. 1 Review: 1회차)
        // testFunDev();

        // [신규] Make Sum Quest (Quest 18: Hash)
        // testMakeSum();
    }

    private static void testJosephus() {
        JosephusSolution solver = new JosephusSolution();
        System.out.println("\n--- [복습] (Josephus Problem) ---");

        // Case 1
        int n1 = 5, k1 = 2;
        int[] exp1 = { 2, 4, 1, 5, 3 };
        int[] res1 = solver.solution(n1, k1);
        System.out.println("Test Case 1: " + (Arrays.equals(exp1, res1) ? "PASS" : "FAIL"));
        System.out.println("Result: " + Arrays.toString(res1));

        // Case 2
        int n2 = 7, k2 = 3;
        int[] exp2 = { 3, 6, 2, 7, 5, 1, 4 };
        int[] res2 = solver.solution(n2, k2);
        System.out.println("Test Case 2: " + (Arrays.equals(exp2, res2) ? "PASS" : "FAIL"));
        System.out.println("Result: " + Arrays.toString(res2));
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
}
