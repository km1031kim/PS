import java.util.Scanner;

public class Main {
	public static void main(String[] args)  {
		

		Scanner sc = new Scanner(System.in);

		int InputMoney = sc.nextInt();
		
		int count = 0;
		int[] arr = {500, 100, 50, 10, 5, 1};

			// 일단 1000 - 660

		int remainMoney = 1000 - InputMoney;

		for (int i = 0; i < arr.length; i++) {
			if (remainMoney >= arr[i]) {
				count += remainMoney / arr[i]; // 몫을 카운트로!
				remainMoney = remainMoney % arr[i]; // 나머지를 남은 돈으로!

			}
		}

		System.out.println(count);

	}

}
