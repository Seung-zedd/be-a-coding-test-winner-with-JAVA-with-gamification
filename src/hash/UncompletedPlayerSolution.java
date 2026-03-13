package hash;

import java.util.*;

public class UncompletedPlayerSolution {
    public String solution(String[] participant, String[] completion) {
        // [복습 3회차] 완주하지 못한 선수
        Map<String, Integer> marathonMap = new HashMap<>();

        // 참가자 먼저 카운팅
        for (String p : participant) {
            marathonMap.merge(p, 1, Integer::sum);
        }
        // 완주자 매칭
        // ! 람다식은 새로운 변수를 넣어야함
        for (String c : completion) {
            marathonMap.computeIfPresent(c, (k, v) -> v == 1 ? null : v - 1);
        }

        // 완주하지 못한 선수 리턴
        for (String p : participant) {
            if (marathonMap.get(p) != null) {
                return p;
            }
        }

        return "";
    }
}
