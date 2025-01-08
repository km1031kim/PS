import java.util.ArrayDeque;

class Solution {
        public int solution(String input) {

            String[] inputArray = input.split("");
            int answer = 0;
            for (int i = 0; i < input.length(); i++) {
                if (i == 0) {
                    // 처음에는 회전 없음.
                    if (isRightParenthesis(input)) {
                        answer++;
                    }
                } else {
                    // 회전 시작
                    String first = inputArray[0]; // 처음 값 저장
                    for (int j = 0; j < input.length()-1; j++) {
                        // 문자열을 회전시켜서 새로운 문자열 만들기
                        inputArray[j] = inputArray[j + 1];
                    }
                    inputArray[inputArray.length - 1] = first;

                    // String.join()으로 String 배열을 하나의 문자열로
                    String join = String.join("", inputArray);

                    if (isRightParenthesis(join)) {
                        answer++;
                    }
                }
            }
            return answer;
        }

        public boolean isRightParenthesis(String input) {
            // 올바른 괄호인지 판단

            // 괄호의 종류는 총 3개 () {} []
            ArrayDeque<Character> stack = new ArrayDeque<>();

            char[] charArray = input.toCharArray();

            for (char c : charArray) {
                // 왼쪽 짜리만 들어올 수 있음.
                if (c == '[' || c == '{' || c == '(') {
                    stack.push(c);
                } else {
                    // 오른쪽 괄호가 들어왔는데 스택이 비어있으면 잘못된 괄호.
                    if (stack.isEmpty()) {
                        return false;
                    }

                    // peek찍어서 짝이 맞으면 pop()
                    if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
            return stack.isEmpty();
        }


    }
