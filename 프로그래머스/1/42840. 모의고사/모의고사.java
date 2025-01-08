import java.util.*;
class Solution {
        public int[] solution(int[] answers) {


            // 카운트 담을 배열
            int[] scoreArray = new int[3];

            // 정답
            ArrayList<Integer> answerArrayList = new ArrayList<>();


            // 나머지 연산
            int[] firstSupo = {1, 2, 3, 4, 5}; // 나머지 연산이넹
            int[] secondSupo = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] thridSupo = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


            int[] scores = new int[]{0,0,0};
            int firstSupoCnt = 0;
            int secondSupoCnt = 0;
            int thirdSupoCnt = 0;

            for (int i = 0; i < answers.length; i++) {
                int firstSupoIndex = i % firstSupo.length; // 0 % 5
                int secondSupoIndex = i % secondSupo.length; // 0 % 5
                int thirdSupoIndex = i % thridSupo.length; // 0 % 5


                if (firstSupo[firstSupoIndex] == answers[i]) {
                    firstSupoCnt++;
                }
                if (secondSupo[secondSupoIndex] == answers[i]) {
                    secondSupoCnt++;
                }
                if (thridSupo[thirdSupoIndex] == answers[i]) {
                    thirdSupoCnt++;
                }
            }

            // 배열에 넣기
            scoreArray[0] = firstSupoCnt;
            scoreArray[1] = secondSupoCnt;
            scoreArray[2] = thirdSupoCnt;


            // 최대값
            int maxScore = 0;
            for (int i = 0; i < scoreArray.length; i++) {
                if (scoreArray[i] > maxScore) {
                    maxScore = scoreArray[i];
                }
            }
          //  System.out.println("maxScore = " + maxScore);

            // 제일 많이 맞춘 수포자를 ArrayList로
            for (int i = 0; i < scoreArray.length; i++) {
                if (scoreArray[i] == maxScore) {
                    answerArrayList.add(i + 1);
                }
            }

            // 정렬
            Collections.sort(answerArrayList);

            // int[] 로 변환
            int[] answer = new int[answerArrayList.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerArrayList.get(i);
            }
            return answer;
        }
    }