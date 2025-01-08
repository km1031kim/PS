import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] arr = new int[101][101];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					arr[j][k] = 1;
				}
			}
		}

		int cnt = 0;

		int x[] = { -1, 1, 0, 0 }; // 좌우로만 움직이는 경우
		int y[] = { 0, 0, -1, 1 }; // 상하로만 움직이는 경우

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					// 1 인 경우 상하좌우에 0이 있는지 확인한다.
					for (int k = 0; k < x.length; k++) {
						if (arr[i + x[k]][j] == 0) {
							cnt++;
						}
						if (arr[i][j + y[k]] == 0) {
							cnt++;
						}
					}
				}
			}
		} System.out.println(cnt);

	}

}
