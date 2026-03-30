package hash;

import java.util.*;

/*
[문제 해석]
1. 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
    1.1. 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
    -> M: N 카디널리티
    1.2. 한 유저를 여러 번 신고할 수도 있지만, **동일한 유저에 대한 신고 횟수는 1회로 처리**됩니다.
    -> 해시셋으로 수정!

2. if reported(유저) >= k: 게시판 이용 정지, 
        해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
        -> 

    2.1. 유저가 신고한 모든 내용을 취합하여 
    마지막에 한꺼번에 게시판 이용 정지를 시키면서 **정지 메일을 발송**합니다.
    -> 처리 결과 메일은 k번 신고를 받아 정지된 ID가 존재할 때 answer[userid]++;

3. 입출력 예시를 보고 수정한 해시맵: 
<String, Set<String>>

(param)
id_list: 이용자의 ID가 담긴 문자열 배열  
report: 각 이용자 -> 신고한 이용자의 ID 정보가 담긴 문자열 배열
k: 정지 기준이 되는 신고 횟수 

요구사항: 각 유저별로 **처리 결과 메일**을 받은 횟수를 배열에 담아 return

- 제한 사항 -
1. 2 ≤ id_list의 길이 ≤ 10^3
    1.1. id_list에는 같은 아이디가 중복해서 들어있지 않습니다.(해시키는 unique)
2. 1 ≤ report의 길이 ≤ 2 * 10^5
    2.1. report의 원소는 "이용자id 신고한id"형태의 문자열입니다.
    -> split(" ") 필요
    2.2. 자기 자신을 신고하는 경우는 없습니다.
3. 1 ≤ k ≤ 200, k는 자연수입니다.
4. return 하는 배열은 id_list에 담긴 id 순서대로 각 유저가 받은 결과 메일 수를 담으면 됩니다.

[문제의 흐름]
1. report를 순회하면서 신고
2. k번 이상 신고된 유저를 계산
3. 정지 메일 발송

*/

public class ReportResultSolution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] ans = new int[id_list.length];
        // 1.2. 한 유저를 여러 번 신고할 수도 있지만, **동일한 유저에 대한 신고 횟수는 1회로 처리**됩니다.
        Map<String, Set<String>> reportMap = new HashMap<>();

        // 1. 신고자 -> 신고 받은 해시맵을 먼저 집계
        // report의 원소는 "이용자id 신고한id"형태의 문자열입니다.
        for (String r : report) {
            String[] msg = r.split(" ");
            String userId = msg[0];
            String reportId = msg[1];
            reportMap.computeIfAbsent(userId, key -> new HashSet<>()).add(reportId);
        }

        // 2. k번 이상 신고된 유저를 계산
        // O(N + K): 분할 및 소집
        Map<String, Integer> countMap = new HashMap<>();
        for (Set<String> reportSet : reportMap.values()) {
            for (String r : reportSet) {
                countMap.merge(r, 1, Integer::sum);
            }
        }

        // 3. k번 이상 신고된 유저가 있으면 신고자한테 정지 메일 발송
        for (int i = 0; i < id_list.length; i++) {
            String userId = id_list[i];
            // 내가 누구를 신고했지?
            Set<String> reportSet = reportMap.get(userId);
            // 신고를 안 한 사람이 있을 수도 있으므로
            if (reportSet != null) {
                for (String r : reportSet) {
                    if (countMap.get(r) >= k) {
                        ans[i]++;
                    }
                }
            }
        }

        return ans;
    }
}
