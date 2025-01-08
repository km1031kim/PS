
import java.util.ArrayDeque;


   class Solution{
        public int[] solution(int[] prices) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            int[] answer = new int[prices.length];

            for (int i = 0; i < prices.length; i++) {

                // i가 push 된다.
                if (i == 0) {
                    stack.push(i);
                }

                if (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                    // 주식이 내려간 경우.
                    while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                        int time = i - stack.peek(); //
                        answer[stack.peek()] = time;
                        stack.pop();
                    }
                    stack.push(i);
                } else {
                    stack.push(i);
                }
            }
            for (Integer i : stack) {
                answer[i] = prices.length - i - 1;
            }
            return answer;
        }
    }

