package hash;

import java.util.*;

/*
[문제 해석]
1. 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
    1.1. 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
    -> M: N 카디널리티
    1.2. 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
    -> 해시맵으로 생각해보면, 동일한 유저id를 put()해도 동일하기 때문에 1회로 처리 == 멱등성

2. if reported(유저) >= k: 게시판 이용 정지, 
        해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
        -> 멀티캐스팅 방식, 즉 1(신고당한 유저): k(해당 유저를 신고한 모든 유저)
    2.1. 유저가 신고한 모든 내용을 취합하여 
    마지막에 한꺼번에 게시판 이용 정지를 시키면서 **정지 메일을 발송**합니다.
    -> 처리 결과 메일은 k번 신고를 받아 정지된 ID가 존재할 때 answer[userid]++;

3. 입출력 예시를 보고 수정한 해시맵: 
<String, String>I

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

*/

public class ReportResultSolution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 신고 명단 작성 중...
        // reportMap의 역할: userid -> 신고당한 reportid의 셋
        // ! 리스트는 reportid가 같아도 다르게 취급하기 때문에 해시셋 사용
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String r : report) {
            String[] msg = r.split(" ");
            String userid = msg[0];
            String reportid = msg[1];

            reportMap.computeIfAbsent(userid, str -> new HashSet<>()).add(reportid);
        }

        // countMap의 역할: 신고당한 reportid의 신고 횟수
        // 누가 총 몇 표를 받았는가?
        // ? 바깥루프: 2 * 10^5인데, 내부루프는 합이 2* 10^5이므로, 최종적으로 2*10^5밖에 안걸린다?? -> 신고를 하지 않은 userid가 있을 수 있기 때문
        Map<String, Integer> countMap = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : reportMap.entrySet()) {
            for (String reportid : entry.getValue()) {
                countMap.merge(reportid, 1, Integer::sum);
            }
        }

        // 처리 결과 메일
        // id_list를 순회하면서 당선됬으면 reportMap의 key한테 메일 발송
        for (int i = 0; i < id_list.length; i++) {
            String userid = id_list[i]; // 메일을 받을 후보자

            // userid가 신고한 녀석들을 먼저 추출
            Set<String> reportedSet = reportMap.get(userid);

            // 실제로 정지된 유저가 몇 명?
            // ! "neo" 없음 없음과 같이 신고를 하지 않은 userid가 있을 수 있다
            if (reportedSet != null) {
                for (String r : reportedSet) {
                    // 정지 기준이 되는 횟수 k를 넘기면
                    if (countMap.get(r) >= k) {
                        answer[i]++; // 메일을 받는다
                    }
                }
            }
            
        }

        return answer;
    }
}
