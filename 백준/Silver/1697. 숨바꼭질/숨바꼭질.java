import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);

		int[] visited = new int[100001];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = -1; // 방문하지 않았음을 명확하게 표시
		}

		ArrayDeque<Integer> queue = new ArrayDeque<>();

		visited[N] = 0;
		queue.offer(N);

		while (!queue.isEmpty()) {
			int location = queue.poll();
			int currentTime = visited[location];

			if (location == K) {
				bw.write(String.valueOf(currentTime));
				bw.flush();
				bw.close();
				return;
			}

			int[] nextPositions = {location - 1, location + 1, location * 2};

			for (int next : nextPositions) {
				if (next >= 0 && next < visited.length && visited[next] == -1) {
					visited[next] = currentTime + 1;
					queue.offer(next);
				}
			}
		}
	}
}
