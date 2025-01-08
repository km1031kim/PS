import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException, ArrayIndexOutOfBoundsException  {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {   
			arr[i] = Integer.parseInt(bf.readLine());
			
		}
//		System.out.println(Arrays.toString(arr));
		
		dp[0] = 0;
		dp[1] = arr[1];
		if(n >=2) {
			dp[2] = Math.max(arr[2], dp[1]+arr[2]);
		}
		
		for(int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-2]+ arr[i], dp[i-3] + arr[i-1] + arr[i]);
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}
	
}