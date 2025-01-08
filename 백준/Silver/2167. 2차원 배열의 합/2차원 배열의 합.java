import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static void main(String[] args)  {
	

		// 다시 해보자.

		// 배열을 받아올 수를 설정
		// 하지만 문제에서는 실질적인 (0,0)을 (1,1)로 1 크게 생각하고 있기에, 애초에 배열을 1 크게 만들고,
		// 배열값을 넣어줄 때 1부터 넣어주면 비록 0은 남아있지만 합계를 구하는덴 지장이 없다. 이렇게 해야 이해하기 편하다.

		Scanner s = new Scanner(System.in);
		int mapX = s.nextInt();
		int mapY = s.nextInt();

		// 1 크게 생성하자
		int[][] arr = new int[mapX + 1][mapY + 1];

		// 1부터 각각의 값을 넣어주자. 0,0 1,0 은 비게 된다.

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				arr[i][j] = s.nextInt();
			}
		}

		int sumcount = s.nextInt();

		for (int i = 0; i < sumcount; i++) {

			// 각각의 좌표를 받아주자.

			int startX = s.nextInt();
			int startY = s.nextInt();
			int endX = s.nextInt();
			int endY = s.nextInt();
			int sum = 0;
			for (int j = startX; j <= endX; j++) {
				for (int k = startY; k <= endY; k++) {
					sum += arr[j][k];
				}
			}
			System.out.println(sum + " "); 
		}

	}
}