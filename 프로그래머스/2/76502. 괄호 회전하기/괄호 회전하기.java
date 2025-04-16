import java.util.ArrayDeque;
 

class Solution {
		public int solution(String s) {
			int result = 0;
			String[] split = s.split("");

			for (int i = 0; i < s.length(); i++) {
				if (i == 0) {
					if (isRight(s)) {
						result++;
					}
					continue;
				}

				String first = split[0]; // 처음 값 저장

				for (int j = 0; j < s.length() - 1; j++) {
					split[j] = split[j + 1];
				}

				split[s.length() - 1] = first;

				String join = String.join("", split);

				if (isRight(join)) {
					result++;
				}

			}

			return result;
		}



	static boolean isRight(String str) {

		ArrayDeque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (stack.isEmpty()) {
				stack.push(c);
				continue;
			}

			Character top = stack.peek();

			if (c == ']') {
				if (top == '[') {
					stack.pop();
				}
				continue;
			}

			if (c == '}') {
				if (top == '{') {
					stack.pop();
				}
				continue;
			}

			if (c == ')') {
				if (top == '(') {
					stack.pop();
				}
				continue;
			}

			stack.push(c);
		}

		return stack.isEmpty();
	}
}