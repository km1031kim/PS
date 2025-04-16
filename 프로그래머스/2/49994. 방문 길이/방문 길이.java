import java.util.HashSet;
 
class Solution {
	public int solution(String dirs) {

			// 방문을 확인해야함.

			int row = 0;
			int col = 0;

			// row, col

			HashSet<String> set = new HashSet<>();
			int cnt = 0;

			for (int i = 0; i < dirs.length(); i++) {

				String command = String.valueOf(dirs.charAt(i));

				if (command.equals("U") && row + 1 <= 5) {
					String history = row + "" + col + " " + (row + 1) + "" + col;

					row = row + 1;

					String[] split = history.split(" ");
					String reverse = split[1] + " " + split[0];

					if (!set.contains(history) && !set.contains(reverse)) {
						set.add(history);
						set.add(reverse);
						cnt++;
					}
					continue;
				}

				if (command.equals("D") && row - 1 >= -5) {
					String history = row + "" + col + " " + (row - 1) + "" + col;

					row = row -1;

					String[] split = history.split(" ");
					String reverse = split[1] + " " + split[0];

					if (!set.contains(history) && !set.contains(reverse)) {
						set.add(history);
						set.add(reverse);
						cnt++;
					}
					continue;
				}

				if (command.equals("L") && col - 1 >= -5) {
					String history = row + "" + col + " " + row + "" + (col - 1);
					System.out.println("history = " + history);

					col = col - 1;

					String[] split = history.split(" ");
					String reverse = split[1] + " " + split[0];

					if (!set.contains(history) && !set.contains(reverse)) {
						set.add(history);
						set.add(reverse);
						cnt++;
					}
					continue;
				}

				if (command.equals("R") && col + 1 <= 5) {
					String history = row + "" + col + " " + row + "" + (col + 1);

					col = col + 1;

					String[] split = history.split(" ");
					String reverse = split[1] + " " + split[0];

					if (!set.contains(history) && !set.contains(reverse)) {
						set.add(history);
						set.add(reverse);
						cnt++;
					}
				}
			}
			return cnt;
		}
	}