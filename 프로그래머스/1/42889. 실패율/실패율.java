import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] history = new int[N + 2];
        for (int stage : stages) {
            history[stage]++;
        }

        int userCount = stages.length;
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int current = history[i];
            double rate = userCount == 0 ? 0 : (double) current / userCount;
            map.put(i, rate);
            userCount -= current;
        }

        return map.keySet().stream()
            .sorted((o1, o2) -> {
                int cmp = Double.compare(map.get(o2), map.get(o1));
                return cmp != 0 ? cmp : Integer.compare(o1, o2);
            })
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
