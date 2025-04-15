import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


class Solution {
		static HashMap<String, Integer> map = new HashMap<>();

	public String[] solution(String[] orders, int[] course) {


			// orders 하나만 제대로 하면 나머지는 거기서 거기다.
			// orders

			for (int i = 0; i < orders.length; i++) {
					String temp = orders[i];
				char[] charArray = temp.toCharArray();
				Arrays.sort(charArray);
				String order = new String(charArray);

				// course 배열 돌아야함.
				for (int j = 0; j < course.length; j++) {
					int cnt = course[j];
					if (order.length() < cnt) {
						continue;
					}

					// 재귀 시작..
					// 뭐가 필요할까? 일단 course 필요함, order도 필요함, 빈 ArrayList도 필요함. 다음 시작 인덱스 필요함.
					recursive(0, new ArrayList<>(), order, cnt);

				}

			}
			// 2 : 4
			HashMap<Integer, Integer> resultMap = new HashMap<>();

			// 메뉴 수 별로 맥스값 추출
			map.keySet().stream()
				.filter(key -> map.get(key) >= 2)
				.forEach(key -> {
					int value = resultMap.getOrDefault(key.length(), 0);
					int maxValue = Math.max(value, map.get(key));
					resultMap.put(key.length(), maxValue);
				});

			ArrayList<String> resultArrayList = new ArrayList<>();

			for (String key : map.keySet()) {
				// 키의 길이를 가져오고
				int keyLength = key.length();

				if (resultMap.containsKey(keyLength)) {
					// 키의 길이에 해당하는 maxValue를 가져와서
					int maxValue = resultMap.get(keyLength);

					// 같으면 어레이리스트에 추가
					if (map.get(key) == maxValue) {
						resultArrayList.add(key);
					}
				}

			}
			resultArrayList.sort(null);

			return resultArrayList.toArray(String[]::new);

		}
	

	private static void recursive(int startIndex, ArrayList<String> pickedMenu, String order, int course) {

		// 여기서 재귀 시작임
		// ABCFG 왔고, 시작 인덱스는 0이고, 코스는 2개임.

		// 탈출조건
		if (pickedMenu.size() == course) {
			// 맵에 넣고  A, B 가 들어왔음
			StringBuilder sb = new StringBuilder();
			pickedMenu.sort(null);

			for (String menu : pickedMenu) {
				sb.append(menu);
			}
			String comb = sb.toString();

			Integer value = Solution.map.getOrDefault(comb, 0);
			Solution.map.put(comb, value + 1);
			return;
		}

		// 재귀 로직
		for (int i = startIndex; i < order.length(); i++) {

			// 현재 메뉴
			String menu = String.valueOf(order.charAt(i)); // A

			// 메뉴를 리스트에 넣고
			pickedMenu.add(menu);

			// 재귀 호출
			recursive(i + 1, pickedMenu, order, course);

			// 탈출 시 리스트의 마지막 인덱스 요소 제거
			pickedMenu.remove(pickedMenu.size() - 1);

		}

	}
}

