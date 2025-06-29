import java.util.*;

class Solution
{
    public int solution(String s)
    {
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);    
            
            if (stack.isEmpty()) {
                stack.push(current);
                continue;
            }
            
            // 비어있지 않은 경우
            char top = stack.peek();
            if (current == top) {
                stack.pop();
                continue;
            }
            
            stack.push(current);
            
        }

        return stack.isEmpty() ? 1 : 0;
    }
}