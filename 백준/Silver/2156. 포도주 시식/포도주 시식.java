import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());

		int[] wineArray = new int[count];
		for (int i = 0; i < wineArray.length; i++) {
			wineArray[i] = Integer.parseInt(br.readLine());
		}

		// DP 배열을 만든다.
		int[] dp = new int[count];

		dp[0] = wineArray[0];

		if (count > 1) {
			dp[1] = wineArray[0] + wineArray[1];
		}

		if (count > 2) {
			dp[2] = Math.max(dp[1],
				Math.max(dp[0] + wineArray[2], wineArray[1] + wineArray[2]));
		}

		if (count > 3) {
			for (int i = 3; i < wineArray.length; i++) {
				dp[i] = Math.max(dp[i - 1],
					Math.max(
						dp[i - 2] + wineArray[i],
						dp[i - 3] + wineArray[i] + wineArray[i - 1]
					));

			}
		}

		bw.write(String.valueOf(dp[count - 1]));
		bw.flush();

		bw.close();
		br.close();

	}
}
