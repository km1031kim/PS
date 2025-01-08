import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

//		System.out.println(N);

		int[][] arr = new int[101][101];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			// 각각 두번씩 세번 받아야 한다.

			int x = sc.nextInt();
			int y = sc.nextInt();
//			System.out.println(x);

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (arr[j][k] == 1) {
						continue;
					} else {
						arr[j][k] = 1;
						cnt++;

					}

				}
			}

		}
		System.out.println(cnt);

	}

}
