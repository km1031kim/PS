
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



 class Solution {

        // [1,8], [2,4]
        static final List<List<Integer>> childNodeList = new ArrayList<>();
        static int answer = 0;

     int solution(int[] info, int[][] edges) {

            // 노드의 수만큼 ArrayList 생성
            for (int i = 0; i < info.length; i++) {
                childNodeList.add(new ArrayList<>());
            }

            // 자식노드끼리 모으기, 부모가 누구인지는 info 배열로 접근.
            for (int i = 0; i < edges.length; i++) {
                childNodeList.get(edges[i][0]).add(edges[i][1]);
            }

            // 상태가 필요하다. 참조로 넘기면 안된다. 독립적인 상태 필요.
            ArrayList<Integer> currentCandidate = new ArrayList<>();
            currentCandidate.add(0); // 루트 노드 넣기.

            dfs(info, currentCandidate, 0, 0, 0);

            return answer;
        }

        private static void dfs(int[] info, ArrayList<Integer> currentCandidate, int node, int sheep, int wolf) {
            if (info[node] == 0) {
                // 앙이면?
                sheep += 1;
            } else {
                // 늑대면?
                wolf += 1;
            }

            // 잡아먹히면 함수 종료
            if (sheep <= wolf) {
                return;
            }

            // 잡아먹히지 않은 경우, answer 갱신
            answer = Math.max(answer, sheep);

            // 현재 리스트 가져옴
            ArrayList<Integer> tmpCandidate = new ArrayList<>(currentCandidate);

            // 자식 정보 추가
            if (!childNodeList.get(node).isEmpty()) {
                tmpCandidate.addAll(childNodeList.get(node));
            }

            // 자기 자신은 뺀다
            tmpCandidate.remove(Integer.valueOf(node)); // int 를 집어넣으면 해당 인덱스가 제거됨.

            // 상태를 공유하는 노드 재귀 호출.
            for (int n : tmpCandidate) {
                dfs(info, tmpCandidate, n, sheep, wolf);
            }
        }
    }
