import java.util.*;

class Solution {
    boolean solution(String s) {
        
        char[] chars = s.toCharArray();
        
        if (chars[0] == ')') {
            return false;
        }
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            
            char input = chars[i];
            
            if (stack.isEmpty()) {
                stack.push(input);
                continue;
            }
            
            // 비어있지 않다. 맨 위꺼 확인
            char top = stack.peek();
            if (top == '(' && input == ')') {
                stack.pop();
                continue;
            }
            
            stack.push(top);
        }
        
        if (stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
}