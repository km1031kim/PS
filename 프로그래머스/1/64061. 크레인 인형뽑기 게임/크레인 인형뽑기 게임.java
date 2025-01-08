
import java.util.ArrayDeque;
import java.util.ArrayList;


     class Solution {
        public  int solution(int[][] board, int[] moves) {

            // 크레인 세팅
            ArrayList<ArrayDeque<Integer>> stackArray = new ArrayList<>();

            for (int i = 0; i < board[0].length; i++) {
                stackArray.add(new ArrayDeque<>());
                for (int j = board.length-1; j >= 0; j--) {
                    ArrayDeque<Integer> stack = stackArray.get(i);
                    int value = board[j][i];
                    if (value == 0) {
                        continue;
                    }
                    stack.push(value);
                }
            }
            System.out.println(stackArray);

            // 뽑기 시작
            ArrayDeque<Integer> answer = new ArrayDeque<>();
            int cnt = 0;

            for (int i = 0; i < moves.length; i++) {

                // 일단 뽑아야 한다.
               // System.out.println("moves[" + i + "] : " + moves[i]);
                int craneIndex = moves[i] - 1; // 0번인덱스가 1번이니까..
              //  System.out.println(craneIndex + "번째 크레인에서 뺍니다");

                if (stackArray.get(craneIndex).isEmpty()) {
                 //   System.out.println(craneIndex + "번째 크레인은 현재 비어있어요");
                    continue;
                }
                int pick = stackArray.get(craneIndex).pop();
               // System.out.println("pick = " + pick);
                // 뽑아서 answer 스택에 넣는다

                // 비어있지 않다면, 같은지 확인한다. 같으면 answer 스택에서 제거한다.
                if (!answer.isEmpty() && answer.peek().equals(pick)) {
                 //   System.out.println("정답 스택에 이미 있음. 제거 " + pick);
                    answer.pop();
                    cnt = cnt + 2;
                  //  System.out.println("카운트 ++ " +cnt);
                } else {
                   // System.out.println("중복되지 않으므로 그냥 넣는다 " + pick);
                    answer.push(pick);
                }
               // System.out.println(answer);

            }


            //System.out.println(cnt);
            return cnt;
        }
    }

