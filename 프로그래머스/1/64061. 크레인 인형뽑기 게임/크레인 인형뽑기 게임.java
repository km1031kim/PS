import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        // 세팅부터 해야한다.
        int boardSize = board.length;
        
        
        HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();
        
        // 스택 세팅
        for (int i = 0; i < boardSize; i++) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            map.put(i, new ArrayDeque<Integer>());
        }
        
        
        // 스택에 값 넣기
        for (int i = boardSize - 1; i >= 0; i--) {
            // 4 3 2 1 0
            for (int j = 0; j < board[i].length; j++) {
                ArrayDeque<Integer> stack = map.get(j);
                
                int value = board[i][j];
                if (value != 0) {
                    stack.push(value);
                }
                
            }
        }
        
//         // 출력
//         for (ArrayDeque<Integer> test : map.values()) {
//             while (!test.isEmpty()){
//                 System.out.print(test.pop());
//             }
//             System.out.println();
//         }
        
        ArrayDeque<Integer> basket = new ArrayDeque<>();
        int answer = 0;
        
        for (int i = 0; i < moves.length; i++) {
            int stackIndex = moves[i] - 1;
            
            ArrayDeque<Integer> stack = map.get(stackIndex);
            
            if (!stack.isEmpty()) {
                
                int top = stack.pop();
                System.out.println("현재 인형 : " + top);
                
                if (basket.isEmpty()) {
                    basket.push(top);
                    continue;
                }
                
                int basketTop = basket.peek();
                System.out.println("바구니 맨 위 : " + basketTop);

                if (top == basketTop) {
                    basket.pop();
                    answer = answer + 2;
                    continue;
                }
                
                basket.push(top);
            }
            
        }
        
        return answer;
    }
}