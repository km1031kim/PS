
import java.util.HashSet;

 class Solution {
        public int solution(int[] nums) {
            HashSet<Integer> resultSet = new HashSet<>();
            HashSet<Integer> monsterSet = new HashSet<>();

            for (int num : nums) {
                monsterSet.add(num);
            }

            int answer = 0;
            int cnt = 0;

            int maxCnt = nums.length / 2;
            int maxKind = 0;

            if (monsterSet.size() > maxCnt) {
                maxKind = maxCnt;
            } else {
                maxKind = monsterSet.size();
            }

            for (int i = 0; i < nums.length; i++) {

                int monster = nums[i];
                resultSet.add(monster);
                cnt++;

                if (cnt == maxCnt) {
                    if (resultSet.size() == maxKind) {
                        answer = resultSet.size();
                        break;
                    }
                    cnt--;
                }
            }
            return answer;
        }
    }
