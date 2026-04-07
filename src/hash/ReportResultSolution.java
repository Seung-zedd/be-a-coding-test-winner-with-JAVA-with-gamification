package hash;

import java.util.*;

public class ReportResultSolution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 1. 완성된 해시맵을 먼저 만든다
        // 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다. -> Set
        Map<String, Set<String>> reportMap = new HashMap<>();

        // report의 원소는 "이용자id 신고한id"형태의 문자열
        for (String r : report) {
            String[] msg = r.split(" ");

            // 신고당한 유저가 있으면
            //? 문제하고 입출력 예시에는 신고당한 유저가 없다는 힌트가 전혀 없는데 이걸 어떻게 유추?
            if (msg.length > 1) {
                String userId = msg[0];
                String reportId = msg[1];
                reportMap.computeIfAbsent(userId, key -> new HashSet<>()).add(reportId);
            }
        }

        // 2. 신고 횟수 카운팅
        // T.C: 200,000 == 2 * 10^5
        Map<String, Integer> countMap = new HashMap<>();

        // 분할 및 소집
        for (Set<String> reportSet : reportMap.values()) {
            for (String r : reportSet) {
                countMap.merge(r, 1, Integer::sum);
            }
        }

        // 신고 결과
        for (int i = 0; i < id_list.length; i++) {
            String userId = id_list[i];
            Set<String> reportSet = reportMap.get(userId);

            // 신고당한 유저가 없을 수도 있으므로
            if (reportSet != null) {
                for (String r : reportSet) {
                    if (countMap.get(r) >= k) {
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }
}
