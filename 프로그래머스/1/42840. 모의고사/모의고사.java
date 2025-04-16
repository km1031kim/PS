import java.util.Arrays;
import java.util.HashMap;
	 class Solution {
		public int[] solution(int[] answers) {

			// 1번 수포자 : 1,2,3,4,5, 1,2,3,4,5
			// 2번 수포자 : 2,1,2,3,2,4,2,5   2,1,2,3,2,4,2,5
			// 3번 수포자 : 3,3,1,1,2,2,4,4,5,5  3,3,1,1,2,2,4,4,5,5
			int[] one = {1, 2, 3, 4, 5};
			int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
			int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

			HashMap<Integer, Integer> map = new HashMap<>();

			map.put(1, 0);
			map.put(2, 0);
			map.put(3, 0);

			for (int i = 0; i < answers.length; i++) {
				int answer = answers[i];

				// 정답과 수포자들의 답을 비교해야 함.

				int aAnswer = one[i % one.length];
				int bAnswer = two[i % two.length];
				int cAnswer = three[i % three.length];

				if (answer == aAnswer) {
					map.put(1, map.getOrDefault(1, 0) + 1);
				}

				if (answer == bAnswer) {
					map.put(2, map.getOrDefault(2, 0) + 1);
				}

				if (answer == cAnswer) {
					map.put(3, map.getOrDefault(3, 0) + 1);

				}

			}

			Integer maxValue = map.values().stream().max(Integer::compareTo).get();
			int[] answerArray = map.keySet()
				.stream()
				.filter(key -> map.get(key).equals(maxValue))
				.mapToInt(Integer::valueOf)
				.toArray();

			Arrays.sort(answerArray);
			return answerArray;
		}
	}