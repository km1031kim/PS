
import java.util.ArrayDeque;

class Solution{
        public String solution(String[] cards1, String[] cards2, String[] goal) {

            /**
             *  gaal을 만들 수 있는지 확인하는 문제다..
             *
             *   단순하게 생각해보기
             *   goal에서 peek한 것이 cards1, cards2의 peek에 존재하는 지 확인..
             *   둘다 같은 단어인 경우는 나중에 생각해보자.
             *
             *   존재한다면 pop(), 존재하지 않다면 No return
             */

            // 1, 큐에 넣기
            ArrayDeque<String> queue1 = new ArrayDeque<>();
            ArrayDeque<String> queue2 = new ArrayDeque<>();

            for (int i = 0; i < cards1.length; i++) {
                queue1.offer(cards1[i]);
            }
            for (int i = 0; i < cards2.length; i++) {
                queue2.offer(cards2[i]);
            }

            // 2. 하나씩 빼면서 체크
            // ["i", "want", "to", "drink", "water"]
            for (int i = 0; i < goal.length; i++) {
                String word = goal[i]; // 현재 목표 단어

                if (!queue1.isEmpty() && queue1.peek().equals(word)) {
                    queue1.poll();
                    continue;
                } else if (!queue2.isEmpty() && queue2.peek().equals(word)) {
                    queue2.poll();
                    continue;
                } else {
                    return "No";
                }
            }
            return "Yes";
        }

    }
