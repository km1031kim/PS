import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


    class Solution {
        public int[] solution(int[][] score) {
            int[] answer = new int[score.length];
            double[] avgArray = new double[score.length];
            ArrayList<Double> avgList = new ArrayList<>();
            HashMap<Double, Integer> avgMap = new HashMap<>();

            for (int i = 0; i < score.length; i++) {
                double avg = (score[i][0] + score[i][1]) / (double) 2 ;
                avgArray[i] = avg;
                avgList.add(avg);
            }

            // 정렬함
            avgList.sort(Comparator.reverseOrder());

            // 맵에 순위 넣기
            int rank = 1;
            double previousAvg = -1;
            for (Double avg : avgList) {
                // 이전과 같으면 랭크가 같음.
                if (avg == previousAvg) {
                    rank++;
                    continue;
                }
                // 다르면 맵에 넣기.
                avgMap.put(avg, rank);
                previousAvg = avg;
                rank++;
            }

            // 정답 뽑기
            for (int i = 0; i < avgArray.length; i++) {
                answer[i] = avgMap.get(avgArray[i]);
            }
            return answer;
        }
    }
