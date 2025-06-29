import java.util.*;

class Solution {
    public int solution(String s) {
        
        String[] array = s.split("");
        int answer = 0;
        
        for (int i = 0; i < array.length; i++){
            if (i == 0) {
                if (isRight(s)) {
                    answer++;
                    continue;
                }
            }
            
            String first = array[0];
            
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            
            array[array.length-1] = first;
            String join = String.join("", array);
            
            if (isRight(join)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isRight(String joinedString) {
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        char[] charArray = joinedString.toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
            
            char current = charArray[i];
            
        
            // 스택이 비어있다면 바로 넣기
            if (stack.isEmpty()) {
                if (current == '}' || current == ']' || current ==')') {
                    return false;
                }
                stack.push(current);
                continue;
            }
            
            // 괄호 확인할 필요 없는 경우 그냥 넣기
            char top = stack.peek();
            if (top == '{' && current == '}') {
                stack.pop();
                continue;

            }
            
            if (top == '[' && current == ']') {
               stack.pop();
               continue;


            }
            
            if (top == '(' && current == ')') {
                stack.pop();
                continue;

            }
            
            stack.push(current);
        }
        
        return stack.isEmpty();
        
    }
}