package array;

import java.util.*;

public class VisitedLenSolution {
    public int solution(String dirs) {
        // 1. 명령어 초기화(key: 명령어, value: 좌표)
        Map<Character, int[]> map = new HashMap<>();
        initDirection(map);

        // 2. 캐릭터 원점
        int startX = 0, startY = 0;

        // "처음 걸어본 길"을 구하기 위해 Set<String> edge 초기화
        Set<String> edge = new HashSet<>();

        // 3. 파라미터의 dirs를 순회
        for (int i = 0; i < dirs.length(); i++) {
            // String -> Char
            Character c = dirs.charAt(i);

            // init과 move를 분리하고, map.getKey()를 통해 좌표를 할당
            int[] result = map.get(c);
            int offsetX = result[0];
            int offsetY = result[1];
            
            // 이동한 거리 설정
            int nextX = startX + offsetX;
            int nextY = startY + offsetY;

            if (isValid(nextX, nextY)) {
                // edge 추가
                edge.add(startX + "," + startY + " " + nextX + "," + nextY);
                edge.add(nextX + "," + nextY + " " + startX + "," + startY);

                // 이동한 값을 시점으로 초기화
                startX = nextX;
                startY = nextY;
            }
        }
        return edge.size() / 2;
    }

    private static void initDirection(Map<Character, int[]> map) {
        map.put('U', new int[] { 0, 1 });
        map.put('D', new int[] { 0, -1 });
        map.put('L', new int[] { -1, 0 });
        map.put('R', new int[] { 1, 0 });
    }

    private static boolean isValid(int x, int y) {
        return -5 <= x && x <= 5 && -5 <= y && y <= 5 ? true : false;
    }
}
