
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

 class Solution {
        public String solution(String[] participant, String[] completion) {


            HashMap<String, Integer> map = new HashMap<>();

            for (String s : participant) {
                if (map.containsKey(s)) {
                    // 이미 있으면? 1 추가
                    Integer i = map.get(s);
                    map.put(s, ++i);
                } else {
                    map.put(s, 1);
                }
            }

           // System.out.println(map);


            for (String s : completion) {
                if (map.containsKey(s)) {
                    Integer i = map.get(s);
                    map.put(s, --i);
                }
                if (map.get(s) == 0) {
                    map.remove(s);
                }
            }

            String answer = "";
            for (String s : map.keySet()) {
               answer = s;
            }
            return answer;
        }
    }
