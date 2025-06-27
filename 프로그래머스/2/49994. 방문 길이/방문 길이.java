import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        
        char[] commands = dirs.toCharArray();
        int answer = 0;
        int[] start = new int[]{0,0};
        HashSet<String> set = new HashSet<>();
        
        
        for (int i = 0; i < commands.length; i++) {
            char command = commands[i];
            int nextX;
            int nextY;
            
            if (command == 'L') {
                // 0 -1
                nextY = start[0];
                nextX = start[1] - 1;
                
                if (nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5) {
                    continue;
                }
                
                // 0 0 0 -1
                String right = start[0] + "" + start[1] + "" + nextY + "" + nextX;
                String reverse = nextY + "" + nextX + "" + start[0] + "" + start[1];
                
                start[0] = nextY;
                start[1] = nextX;
                
                if (set.contains(right) || set.contains(reverse)) {
                    continue;
                }
                
                set.add(right);
                set.add(reverse);
                answer++;
                continue;    
            }
            
                    
            if (command == 'R') {
                // 0 +1
                nextY = start[0];
                nextX = start[1] + 1;
                
                if (nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5) {
                    continue;
                }
                
                // 0 0 0 -1
                String right = start[0] + "" + start[1] + "" + nextY + "" + nextX;
                String reverse = nextY + "" + nextX + "" + start[0] + "" + start[1];
                
                start[0] = nextY;
                start[1] = nextX;
                
                if (set.contains(right) || set.contains(reverse)) {
                    continue;
                }
                
                set.add(right);
                set.add(reverse);
                answer++;
                continue; 
            }
            
                    
            if (command == 'U') {
                // +1 0
                
                nextY = start[0] + 1;
                nextX = start[1];
                
                if (nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5) {
                    continue;
                }
                
                String right = start[0] + "" + start[1] + "" + nextY + "" + nextX;
                String reverse = nextY + "" + nextX + "" + start[0] + "" + start[1];
                
                start[0] = nextY;
                start[1] = nextX;
                
                if (set.contains(right) || set.contains(reverse)) {
                    continue;
                }
                
                set.add(right);
                set.add(reverse);
                answer++;
                continue; 
            }
            
                    
            if (command == 'D') {
                // -1 0
                nextY = start[0] -1;
                nextX = start[1];
                
                if (nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5) {
                    continue;
                }
                
                String right = start[0] + "" + start[1] + "" + nextY + "" + nextX;
                String reverse = nextY + "" + nextX + "" + start[0] + "" + start[1];
                
                start[0] = nextY;
                start[1] = nextX;
                
                if (set.contains(right) || set.contains(reverse)) {
                    continue;
                }
                
                set.add(right);
                set.add(reverse);
                answer++;
                continue; 
            }
            
        }
        
        for(String key : set) {
            System.out.println(key);
        }
        
    
        return answer;
    }
}