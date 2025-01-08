import java.util.ArrayDeque;
  
 class Solution{
        public int solution(String s) {

            // stack은 ArrayDeque()
            ArrayDeque<Character> queue = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);

                if (queue.isEmpty()) {
                    queue.push(c);
                } else {
                    if (queue.peek().equals(c)) {
                        queue.pop();
                    } else {
                        queue.push(c);
                    } 
                }
            }
            return queue.isEmpty() ? 1 : 0;
        }
    }