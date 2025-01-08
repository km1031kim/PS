
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

 class Solution {
        public int[] solution(int N, int[] stages) {

            List<Number[]> list = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                // 스테이지를 순회하며 해당 스테이지에 도달한 사람의 수, 해당 스테이지에서 실패한 사람의 수를 계산한다.
                int total = 0; // 해당 스테이지에 도달한 사람의 수
                int fail = 0; // 해당 스테이지에 머물고 있는 사람, 즉 아직 클리어 하지 못한 사람의 수
                double failure = 0.0;

                for (int stage : stages) {
                    // {2,1,2,6,2,4,3,3}
                    if (stage >= i) {
                        // 현재 스테이지에 있지만 클리어 하지 못한 사람과 현재 스테이지를 클리어 한 사람 모두 카운트
                        total++;
                        if (stage == i) { // 코드 수정.
                            fail++; // 현재 스테이지에 있지만 아직 클리어하지 못한 사람.
                        }
                    }
                }

                // 스테이지에 도달한 사람이 없는 경우 해당 스테이지에 실패율은 0으로 정의함
                if (total == 0) {
                    failure = 0.;
                } else {
                    failure = (double) fail / total;
                }
                list.add(new Number[]{i, failure}); // 리스트에 넣음.
            }

            list.sort(new Comparator<Number[]>() {
                @Override
                public int compare(Number[] o1, Number[] o2) { // {1, 0.18} {2, 0.3}
                    // 내림차순이니까 순서 바꿔야함
                    int compare = Double.compare((double)o2[1], (double)o1[1]);
                    if (compare != 0) {
                        return compare;
                    }
                    return Integer.compare((int)o1[0], (int)o1[0]); // 실패율이 같다면 오름차순
                }
            });

            // List<Number[]> list = new ArrayList<>();

            // 정렬 완료. 스트림 사용해서 배열로 반환.
            int[] solution = list.stream().mapToInt(arr -> (int) arr[0]).toArray();
            return solution;
        }
    }


