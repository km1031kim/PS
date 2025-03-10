
import java.util.HashMap;
import java.util.Set;


    class Solution {
        public int solution(String before, String after) {

            // map이네
            HashMap<Character, Integer> beforeMap = new HashMap<>();
            HashMap<Character, Integer> afterMap = new HashMap<>();

            char[] beforeCharArray = before.toCharArray();
            char[] afterCharArray = after.toCharArray();

            for (char c : beforeCharArray) {
                if (beforeMap.containsKey(c)) {
                    beforeMap.put(c, beforeMap.get(c) + 1);
                    continue;
                }
                beforeMap.put(c, 1);
            }

            for (char c : afterCharArray) {
                if (afterMap.containsKey(c)) {
                    afterMap.put(c, afterMap.get(c) + 1);
                    continue;
                }
                afterMap.put(c, 1);
            }

            Set<Character> characters = beforeMap.keySet();
            for (Character c : characters) {
                
                Integer beforeCount = beforeMap.get(c);
                Integer afterCount = afterMap.get(c);

                if (beforeCount == null || afterCount == null) {
                    return 0;
                }

                if (!beforeCount.equals(afterCount)) {
                    return 0;
                }
            }
            return 1;
        }
    }
