import java.util.ArrayDeque;

 class Solution {
		public int solution(String input) {
			int result = 0;

			String[] split = input.split(""); // [ ] ( ) { }

			for (int i = 0; i < input.length(); i++) {
				if (i == 0) {
					if (isRight(input)) {
						result++;
					}
					continue;
				}

				String first = split[0];
				for (int j = 0; j < split.length - 1; j++) {
					split[j] = split[j + 1];
				}
				split[split.length - 1] = first;
				String join = String.join("", split);
				if (isRight(join)) {
					result++;
				}

			}

			return result;
		}

		private static boolean isRight(String input) {

			//
			ArrayDeque<String> stack = new ArrayDeque<>();

			String[] split = input.split("");

			for (int i = 0; i < split.length; i++) {

				String s = split[i];

				if (stack.isEmpty()) {
					stack.push(s);
					continue;
				}

				String top = stack.peek();

				if (s.equals(")")) {
					if (top.equals("(")) {
						stack.pop();
					}
					continue;
				}

				if (s.equals("]")) {
					if (top.equals("[")) {
						stack.pop();
					}
					continue;
				}

				if (s.equals("}")) {
					if (top.equals("{")) {
						stack.pop();
					}
					continue;
				}
				stack.push(s);
			}

			return stack.isEmpty();
		}
	}


