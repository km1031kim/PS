import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 6
		 6
		 10
		 13
		 9
		 8
		 1
		 **/

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());

		int[] wine = new int[count];
		int[] dp = new int[count];

		for (int i = 0; i < wine.length; i++) {
			int weight = Integer.parseInt(br.readLine());
			wine[i] = weight;
		}

		// count == 1
		dp[0] = wine[0];

		if (count == 1) {
			bw.write(String.valueOf(dp[count-1]));
			bw.flush();
			return;
		}

		// count == 2

		dp[1] = wine[0] + wine[1];
		if (count == 2) {
			bw.write(String.valueOf(dp[count-1]));
			bw.flush();
			return;
		}
		dp[2] = Math.max(Math.max(wine[0] + wine[1], wine[0] + wine[2]), wine[1] + wine[2]);
		if (count == 3) {
			bw.write(String.valueOf(dp[count-1]));
			bw.flush();
			return;
		}
		// count > 3
		if (count > 3) {
			for(int i = 3; i < count; i++) {
				dp[i] = Math.max(
					// 세번째라 못먹음
					Math.max(dp[i-1],
						dp[i-3] + wine[i-1] + wine[i]),
					dp[i-2] + wine[i]
				);
			}
		}

		bw.write(String.valueOf(dp[count-1]));
		bw.flush();

		bw.close();
		br.close();

	}
}
