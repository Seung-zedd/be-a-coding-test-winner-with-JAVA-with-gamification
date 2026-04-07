import hash.ExpectedTournamentSolution;
import hash.ReportResultSolution;
import tree.ToothbrushSalesSolution;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        testExpectedTournament();
        // testReportResult();
        // testToothbrushSales();
    }

    private static void testExpectedTournament() {
        ExpectedTournamentSolution sol = new ExpectedTournamentSolution();
        System.out.println("--- Expected Tournament Test ---");
        System.out.println("Case 1: " + (sol.solution(8, 4, 7) == 3));
    }

    private static void testReportResult() {
        ReportResultSolution sol = new ReportResultSolution();
        System.out.println("--- Report Result Test ---");
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int[] result = sol.solution(id_list, report, 2);
        System.out.println("Case 1: " + Arrays.equals(result, new int[]{2,1,1,0}));
    }

    private static void testToothbrushSales() {
        ToothbrushSalesSolution sol = new ToothbrushSalesSolution();
        System.out.println("--- Toothbrush Sales Test ---");
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaemin", "younghe", "edane"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaemin", "mary"};
        String[] seller = {"younghe", "edane", "tod", "sam", "edward", "mary", "jaemin", "younghe"};
        int[] amount = {12, 4, 2, 5, 10}; // Note: Example test cases usually match seller/amount lengths
        // Full test cases will be adjusted during actual combat.
        System.out.println("Ready for combat.");
    }
}
