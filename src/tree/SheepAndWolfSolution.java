package tree;

import java.util.*;

/*
[문제 해석]
2진 트리 모양 초원의 각 노드에 양 또는 늑대가 있습니다.
-> 2진 트리? 혹시 인덱스로 자식 노드들을 배치할 수 있다는건가?

루트 노드에서 출발하여 각 노드를 방문하며 양을 모으려 합니다.
각 노드를 방문할 때마다 해당 노드의 양이나 늑대가 따라오게 됩니다.
-> 양이나 늑대의 노드를 저장하거나 어떤 행동을 취해야 한다는 의미

if (양의 수 <= 늑대의 수): 늑대가 모든 양을 잡아먹습니다.

요구사항: 늑대에게 잡아먹히지 않으면서(양의 수 > 늑대 수) && 최대한 많은 양을 모아서 루트 노드로 돌아와야 합니다. (노드를 다시 방문할 수도 있음)
루트 노드에는 항상 양이 있습니다

[제한 사항]
- info: 각 노드의 동물을 담은 배열 (0: 양, 1: 늑대), 길이는 2~17 (매우 작음 -> 비트마스킹 or 완전탐색 가능)
    - info[0]의 값은 항상 0입니다. 즉, 0번 노드(루트 노드)에는 항상 양이 있습니다.
- edges: 부모, 자식 관계를 담은 2차원 배열
edges의 세로(행) 길이 = info의 길이 - 1

[입출력 예시]
여기서는 0번, 1번 노드를 방문하여 양을 2마리 모은 후, 8번 노드로 이동한 후(양 2마리 늑대 1마리) 이어서 7번, 9번 노드를 방문하면 양 4마리 늑대 1마리가 됩니다.
-> 방문한 노드를 중복해서 방문할 수 있으며, 양과 늑대의 마리수를 기억하기 위한 데이터 구조가 필요함
int[] sheepRes, wolfRes 크기는 최대 17로 하자

*/

/*
[로직 설계]
1. edges[0]을 기준으로 오름차순 정렬(루트 노드부터 시작하므로)
2. 트리끼리 접합
3. 트리를 재귀적으로 구성
4. backtrack(tree, info) 내부에서 info를 순회하면서 valueMap으로 {idx:노드 번호, val: 양 또는 늑대)을 저장
5. backtrack
*/

public class SheepAndWolfSolution {
    public int solution(int[] info, int[][] edges) {
        // 1. 트리 구성 로직
        // ? 인접 배열을 통해 트리 생성
        int n = info.length;
        int[][] tree = new int[n][2];

        // ? 0번 노드가 루트이므로 -1로 반드시 초기화를 해야함!
        for (int[] row : tree) {
            Arrays.fill(row, -1);
        }

        // for문으로 트리 구성
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            if (tree[parent][0] == -1) {
                tree[parent][0] = child;
            } else {
                tree[parent][1] = child; // 왼쪽이 채워졌으면 오른쪽을 자식 노드로 채움
            }
        }

        // 2. 트리 탐색
        int[] maxSheep = { 0 };
        List<Integer> curr = new ArrayList<>();
        curr.add(0); // 루트 노드부터 방문
        backtrack(0, 0, 0, curr, tree, info, maxSheep);
        return maxSheep[0];
    }

    private static void backtrack(int node, int s, int w, List<Integer> curr, int[][] tree, int[] info, int[] max) {
        // 상태 갱신
        //? if-else문 대신 삼항 연산자 사용
        int ns = s + (info[node] == 0? 1 : 0);
        int nw = w + (info[node] == 1? 1 : 0);
        
        // base condition(탈출 조건)
        if (ns <= nw) {
            return;
        }

        // 양 개수 갱신
        //? 요구사항이 최대 양의 개수를 구하는 것
        max[0] = Math.max(max[0], ns);

        // 상태를 들고 후보군을 탐색
        List<Integer> nextNodes = new ArrayList<>(curr);
        
        // 자식 노드가 있으면 nextNodes에 추가
        // 트리 BFS 응용
        if (tree[node][0] != -1) {
            nextNodes.add(tree[node][0]);
        }
        if (tree[node][1] != -1) {
            nextNodes.add(tree[node][1]);
        }

        // 방문한 노드는 제거
        //? List.remove(int index): 인덱스에 위치한 데이터를 제거한다 vs List.remove(Object o): 데이터 o를 제거한다
        nextNodes.remove(Integer.valueOf(node));

        // 자식 노드에서 다시 탐색
        for (int next : nextNodes) {
            backtrack(next, ns, nw, nextNodes, tree, info, max);
        }
    }
}
