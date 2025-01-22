
import java.util.*;

 class Solution {
        public int[] solution(int n, String[] words) {

            // 단어를 담아야 한다. 일단 Set
            // words만큼 반복한다. 반복하면서 확인한다.
            // 몇번째 사람인지는 인덱스를 길이로 나눠서 구한다.
            Set<String> history = new HashSet<>();
            String previousWord = "";

            int personOrder = 0;
            int personTurn = 0;

            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                // 1. 자신이 몇번째 차례인지 확인
                int order = (i + 1) % n;

                if (order == 0) {
                    order = n;
                }

                // 2. 자신의 턴이 몇번째 턴인지 확인.
                int turn = (i / n) + 1;

             //   System.out.println("나는 " + order + "번이고, 지금은 " + turn + "턴이야");
             //   System.out.println("word = " + word);


                // 종료 조건
                // 이미 말한 단어거나, 앞 단어의 끝이 현재 단어의 처음이 아닌 경우

                if (i != 0) {
                    boolean isContained = history.contains(word);
                    boolean isWrong = (previousWord.charAt(previousWord.length()-1) != word.charAt(0));
                    if (isContained || isWrong) {
                        personOrder = order;
                        personTurn = turn;
                        break;
                    }
                }
                previousWord = word;
                history.add(word);
            }
            return new int[]{personOrder, personTurn};
        }
    }
