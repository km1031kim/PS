
import java.util.ArrayList;
import java.util.HashMap;


class Solution {
    public String[] solution(String[] orders, int[] course) {

        HashMap<Integer, Course> map = new HashMap<>();

        for (int i = 0; i < course.length; i++) {
            int key = course[i];
            map.put(key, new Course());
        }

        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {
                int limit = course[j];
                String[] target = orders[i].split("");
                ArrayList<String> temp = new ArrayList<>();
                for (String s : target) {
                    temp.add(s);
                }
                temp.sort(null);

                String[] sortedArray = temp.toArray(String[]::new);

                // (0, 2, {"A","B","C","D"}, "")
                DFS(0, limit, sortedArray, new ArrayList<String>(), map);
            }
        }

        ArrayList<String> answer = new ArrayList<>();

        for (Integer key : map.keySet()) {
            Course c = map.get(key);
            String[] popularComb = c.getPopularComb();
            // System.out.println("c = " + c);
            for (int i = 0; i < popularComb.length; i++) {

                answer.add(popularComb[i]);
            }
        }
        answer.sort(null);

        return answer.stream().toArray(String[]::new);
    }


    public void DFS(int start, int limit, String[] target, ArrayList<String> answer, HashMap<Integer, Course> map) {
        // (0, 2, {"A","B","C","D"}, "")
        if (answer.size() == limit) {
            // System.out.println("answer = " + answer);
            StringBuilder sb = new StringBuilder();
            for (String s : answer) {
                sb.append(s);
            }
            String result = sb.toString();
             System.out.println("result = " + result);
            Course course = map.get(limit);
            course.add(result);
            return;
        }

        for (int i = start; i < target.length; i++) {
              if(target.length - start < limit - answer.size()) {
                return;
            }
            String s = target[start];
            answer.add(s); // answer = {"A"}

            // 현재 answer의 길이 + 추가로 갈 수 있는 길이
            // 5개 중 3개를 선택했음
            // {ABCDE} 에서 {ACD}
            // 4개가 되는지 확인이 필요함
            // 현재 길이 + 남은 길이(target-length-start+1) < limit 면 의미없음
          
            DFS(++start, limit, target, answer, map);
            answer.remove(answer.size() - 1);
        }
    }

    static class Course {

        int max;
        private final HashMap<String, Integer> combination = new HashMap<>();

        public void add(String courseName) {
            int cnt = combination.getOrDefault(courseName, 0) + 1;
            combination.put(courseName, cnt); // 있으면 가져오고 없으면 0이다
            if (cnt > max) {
                // max 갱신
                max = cnt;
            }
        }

        public String[] getPopularComb() {
            // 인기 많은 조합 내보내기
            ArrayList<String> arrayList = new ArrayList<>();
            if (max == 1) {
                return new String[]{};
            }
            for (String key : combination.keySet()) {
                if (combination.get(key) == max) {
                    arrayList.add(key);
                }
            }
            return arrayList.toArray(String[]::new);
        }

        @Override
        public String toString() {
            return "Course{" +
                    "max=" + max +
                    ", combination=" + combination +
                    '}';
        }
    }
}

