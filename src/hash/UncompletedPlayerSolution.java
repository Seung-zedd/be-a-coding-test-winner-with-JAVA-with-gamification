package hash;

import java.util.*;

/*
⚔️ [퀘스트] 문제 19: 완주하지 못한 선수 (Uncompleted Player)
🔗 원전: 프로그래머스 (Programmers) / 코딩 테스트 합격자 되기: 자바 편 (183p)

수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
-> "completion의 길이는 participant의 길이보다 1 작습니다."

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

[제한 사항]
- 마라톤 경기에 참여한 선수의 수는 1명 이상 10^5명 이하입니다.
//! -> participant와 completion 이중 for문 사용 불가!
- completion의 길이는 participant의 길이보다 1 작습니다.
- 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
- 참가자 중에는 동명이인이 있을 수 있습니다.
-> 동명이인이 있을 수 있다는 것은, hash collision이 발생할 수도 있다는거 아님? && HashSet은 중복이 없는 자료구조이기 때문에 사용 불가!
-> HashMap만 가능하다
-> 그런데 무엇을 value로 저장?
*/

public class UncompletedPlayerSolution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        // 먼저 참가자 수를 순회하면서 카운팅을 한다
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주자 수를 순회하면서 참가자 수와 매칭
        for (String c : completion) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        
        // 다시 참가자 수를 순회하면서 카운팅된 값이 남아있으면 그것이 곧 완주하지 못한 선수
        for (String p : participant) {
            if (map.get(p) != 0) {
                return p;
            }
        }
        return "";
    }
}
