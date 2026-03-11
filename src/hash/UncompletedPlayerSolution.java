package hash;

import java.util.*;

public class UncompletedPlayerSolution {
    public String solution(String[] participant, String[] completion) {
        // [베테랑 복습] 자동완성 봉인 룰 적용 대상입니다.
        // HashMap: <participant, count>
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }

        for (String p : participant) {
            if (map.get(p) != 0) {
                return p;
            }
        }
        return "";
    }
}
