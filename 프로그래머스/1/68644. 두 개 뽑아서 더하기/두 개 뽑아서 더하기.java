import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet; 
class Solution {
     
     	static HashSet<Integer> set = new HashSet<>();


		public int[] solution(int[] numbers) {

			// 시작점 있어야 함
			// 2 1 3 4 1
			Arrays.sort(numbers);

			// numbers 넘겨야 하고, 시작점 넘겨야 하고, 빈 리스트 넘겨야 하고
			recursive(0, new ArrayList<>(), numbers);
			
int[] array = set.stream().mapToInt(Integer::intValue).toArray();
			Arrays.sort(array);
			return array;		}

		private static void recursive(int startIndex, ArrayList<Integer> arrayList, int[] numbers) {

			// 탈출 조건
			// 리스트 길이가 2면 탈출
			if (arrayList.size() == 2) {
				int sum = arrayList.stream().reduce((a, b) -> a + b).get();
				set.add(sum);
				return;
			}

			for (int i = startIndex; i < numbers.length; i++) {

				int number = numbers[i];
				arrayList.add(number);
				recursive(i + 1, arrayList, numbers);
				arrayList.remove(arrayList.size() - 1);
			}

		}

	}
