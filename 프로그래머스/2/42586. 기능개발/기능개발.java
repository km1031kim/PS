

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

 class Solution{
        public int[] solution(int[] progresses, int[] speedes) {

/*
            풀기 전.. 생각..
            1. 각각이 100이 언제 되는지 확인... ex) {7, 3, 11} -> 큐에 넣음
            2. 큐에서 뺌
            3. 큐에서 빼면서 해당 수 이하인거까지 같이 뺌. cnt올리면서... ex) 7 뺄때, 7 이하까지 뺌.
            4. cnt ->  ArrayList에 넣기. -> array 변환
*/
            // 1. 개발이 언제 되는지 확인.
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < progresses.length; i++) {
                int sub = 100 - progresses[i]; // 100 - 93
                int quotient = (sub / speedes[i]);
                int remain = (sub % speedes[i]);
                if (remain != 0) {
                    // 나머지가 있으면 하루 추가
                    quotient++;
                }
                queue.offer(quotient);
            }

            // 2. 큐에서 빼면서 로직 수행.
            ArrayList<Integer> answerArrayList = new ArrayList<>(); // 정답 arrayList

            // 하나씩 빼면서 배열 확인..
            while (!queue.isEmpty()) {
                int cnt = 0; // 7, 3, 9
                int current = queue.peek();

                while (!queue.isEmpty() && queue.peek() <= current) {
                    queue.poll();
                    cnt++;
                }
                answerArrayList.add(cnt);
            }
           return answerArrayList.stream().mapToInt(Integer::intValue).toArray();
        }
    }


