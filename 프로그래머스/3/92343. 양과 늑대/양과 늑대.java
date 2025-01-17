import java.util.ArrayList;
import java.util.List;

class Solution {

        private static int answer;
        private static final List<List<Integer>> GRAPH = new ArrayList<>();

        public int solution(int[] info, int[][] edges) {

            // 1. 초기 세팅
            for (int i = 0; i < info.length; i++) {
                GRAPH.add(i, new ArrayList<>());
            }

            for (int[] edge : edges) {
                GRAPH.get(edge[0]).add(edge[1]);
            }

            /**
             *  dfs(info[] node, 0, 빈 리스트 0, 0 )
             *
             */
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0); // 루트 노드 추가

            dfs(info, list, 0, 0, 0);
            return answer;
        }

        public void dfs(int[] info, ArrayList<Integer> list, int node, int sheep, int wolf) {
            if (info[node] == 0) {
                sheep++;
            } else {
                wolf++;
            }

            if (sheep <= wolf) {
                return;
            }

            answer = Math.max(answer, sheep);


            // 리스트 복사
            ArrayList<Integer> next = new ArrayList<>(list);

            // 자신의 자식 노드들 넣기.
            if (!GRAPH.get(node).isEmpty()) {
                // 자식이 있는 경우
                next.addAll(GRAPH.get(node));
            }

            // 자기는 뺀다.
            next.remove(Integer.valueOf(node));

            for (int n : next) {
                dfs(info, next, n, sheep, wolf);
            }
        }
}