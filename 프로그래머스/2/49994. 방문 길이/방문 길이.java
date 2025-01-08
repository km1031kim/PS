import java.util.HashSet;
import java.util.Set;


 class Solution {
        public int solution(String dirs){
            int answer = 0;
            int[] start = {0, 0};
            String[] pathway = dirs.split("");
            Set<String> set = new HashSet<>();

            for (int i = 0; i < pathway.length; i++) {
                String startPoint;
                String destPoint;
                String history;
                String reverse;

                switch (pathway[i]) {
                    case "U" :
                        // 출발지
                        startPoint = start[0] + "" + start[1];

                        // 이동
                        if (start[0] + 1 > 5) {
                            continue;
                        }

                        start[0]++;

                        // 목적지
                        destPoint = start[0] + "" + start[1];

                        // 출발지 목적지 기록
                        history = startPoint + destPoint;

                        // 역순 기록
                        reverse = destPoint + startPoint;

                        // set에 추가
                        set.add(history);
                        set.add(reverse);
                        break;
                    case "D" :
                        startPoint = start[0] + "" + start[1];
                        if (start[0] - 1 < -5) {
                            continue;
                        }
                        start[0]--;
                        destPoint = start[0] + "" + start[1];
                        history = startPoint + destPoint;
                        reverse = destPoint + startPoint;
                        set.add(history);
                        set.add(reverse);
                        break;
                    case "R" :
                        startPoint = start[0] + "" + start[1];
                        if (start[1] + 1 > 5) {
                            continue;
                        }
                        start[1]++;
                        destPoint = start[0] + "" + start[1];
                        history = startPoint + destPoint;
                        reverse = destPoint + startPoint;
                        set.add(history);
                        set.add(reverse);
                        break;
                    case "L" :
                        startPoint = start[0] + "" + start[1];
                        if (start[1] - 1 < -5) {
                            continue;
                        }
                        start[1]--;
                        destPoint = start[0] + "" + start[1];
                        history = startPoint + destPoint;
                        reverse = destPoint + startPoint;
                        set.add(history);
                        set.add(reverse);
                        break;
                }
            }
            return set.size() / 2;
        }
    }

