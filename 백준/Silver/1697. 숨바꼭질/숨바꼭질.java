import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] split = input.split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);

		// N - 수빈이의 위치
		// K - 동생의 위치

		// 걷거나 순간이동, -1, 1, *2
		// 중복되면 안됨.

		int[] visited = new int[100001];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = -1;
		}

		int sec = 0;
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		// 수빈이의 위치는 0초일때
		visited[N] = sec;

		// 수빈이의 위치를 큐에 넣음
		queue.offer(N);

		while (!queue.isEmpty()) {
			Integer location = queue.poll();
			int now = visited[location];

			// 동생의 위치인 경우
			if (location == K) {
				System.out.println(now);
				return;
			}

			// 동생의 위치가 아닌 경우
			// 배열로 빼서, 배열의 요소들이 범위 내에 드는지 화인해보기
			int[] next = new int[] {location - 1, location + 1, location * 2};

			for (int n : next) {
				// -1이여야하고, 범위 내에 들어아 함
				if ( n >= 0 && n < visited.length && visited[n] == -1) {
					int nextTime = now + 1;
					visited[n] = nextTime;
					if (n == K) {
						System.out.println(nextTime);
						return;
					}
					queue.offer(n);
				}
			}

		}

	}
}
