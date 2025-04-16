
import java.util.ArrayDeque;
 
class Solution {

		public boolean solution(String s) {

			ArrayDeque<Character> stack = new ArrayDeque<>();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (stack.isEmpty()) {
					stack.push(c);
					continue;
				}

				// 스택에 요소가 존재하는 경우 -> 비교해야함

				if (c == ')') {
					Character top = stack.peek();
					if (top != c) {
						stack.pop();
					}
					continue;
				}

				stack.push(c);
			}

			return stack.isEmpty();
		}
	}