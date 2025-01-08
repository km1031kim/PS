import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int T = sc.nextInt();
		int count = 0;
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();

		}

		for (int i = N - 1; i >= 0; i--) {
			if (T >= arr[i]) {
				count += T / arr[i];
				T = T % arr[i];
			}
		}

		System.out.println(count);

	}

}