import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
                
        // 10만명.. 속도가 중요하다..
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            // 있으면 1 추가
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        

        
        for (int i = 0; i < completion.length; i++) {
                        
            String completeRunner = completion[i];
            
            // get -> decrease ->
            int count = map.get(completeRunner);
            
            count--;
        
            if (count == 0) {
                map.remove(completeRunner);
                continue;
            }
            
            map.put(completeRunner, count);
            
            
        }
        
       return  map.keySet().stream().findFirst().orElse(null);
        
    }
}