import java.util.*;
class Solution {

        public int solution(String[] babbling) throws InterruptedException {

            String[] babyTalking = {"aya", "ye", "woo", "ma"};
            int cnt = 0;

            // 일단 배열 돌면서 하나씩 하는 건 맞음.
            for (int i = 0; i < babbling.length; i++) {
                boolean result = isPossible(babbling[i], new ArrayList<>(List.of(babyTalking)));
                if (result) {
                    cnt++;
                }
            }


            return cnt;
        }

    public boolean isPossible(String target, ArrayList<String> remains) {
            // 즉, 각 문자열의 가능한 모든 부분 문자열 중에서 "aya", "ye", "woo", "ma"가 한 번씩만 등장합니다.

            if (target.isEmpty()) {
                return true;
            }

            String[] candidates = remains.toArray(String[]::new); // 가능한 후보들

            for (int i = 0; i < candidates.length; i++) {
                String bab = candidates[i];
                if (target.startsWith(bab)) {
                    // 시작한다면?
                    String next = target.substring(bab.length());
                    remains.remove(bab);
                    return isPossible(next, remains);
                }
            }
            return false;
        }
    }