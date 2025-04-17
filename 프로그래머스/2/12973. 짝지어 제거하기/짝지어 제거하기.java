
import java.util.ArrayDeque;
 

class Solution {

	public int solution(String s) {

			ArrayDeque<String> stack = new ArrayDeque<>();

			String[] split = s.split("");


			for (int i = 0; i < s.length(); i++) {
				String word = split[i];

				if (stack.isEmpty()) {
					stack.push(word);
					continue;
				}

				// 비어있지 않다면?
				String top = stack.peek();

				if (word.equals(top)) {
					stack.pop();
					continue;
				}

				stack.push(word);
			}

			return stack.isEmpty() ? 1 : 0;
		}

	}