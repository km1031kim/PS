
     class Solution {
        public int solution(int start, int end, int number) {

            char targetChar = String.valueOf(number).charAt(0);
            int answer = 0;


            for (int i = start; i <= end; i++) {
                // i = 1, 10, 120
                String numberStr = String.valueOf(i);

                char[] charArray = numberStr.toCharArray();
                for (char c : charArray) {
                    if (c == targetChar) {
                        answer++;
                    }
                }
            }
            return answer;
        }
    }
