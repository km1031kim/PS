import java.util.ArrayDeque;

    public  class Solution{
        public  boolean solution(String s) {

            // stack은 ArrayDeque가 성능이 좋다.
            ArrayDeque<String> stack = new ArrayDeque<>();


            String[] splitedString = s.split("");

            for (int i = 0; i < splitedString.length; i++) {
                //  ( ( ) )
                String tmpStr = splitedString[i];

                // 첫번째부터 닫는 괄호가 오면 바로 false
                if (i==0 && !tmpStr.equals("(")) {
                    return false;
                }

                // 여는 괄호는 스택에 추가
                if (tmpStr.equals("(")) {
                    stack.push(tmpStr);
                } else {
                    // 닫는 괄호는 스택에서 pop
                    if (stack.size()==0){
                        return false;
                    }
                    stack.pop();
                }
            }

            return stack.size() == 0;
        }
    }

