import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	

		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
	

		// 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 수를 더한다..
		// 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있따.
		// 26 -> 2 + 6 = 8. 68 -> 6 + 8 = 14.

		int leftnum = 0; // 왼쪽 수
		int rightnum = 0; // 오른쪽 수
		String defalut = userInput;
		if (userInput.split("").length == 1) {
			defalut = ("" + 0 + userInput);
			userInput = defalut;

		} 

		int cnt = 0;

		while (true) {

			String[] arr = defalut.split("");
			leftnum = Integer.parseInt(arr[0]);
			rightnum = Integer.parseInt(arr[1]);
			if (leftnum + rightnum < 10) {
				defalut = ("" + rightnum + (leftnum + rightnum));
				cnt++;

			} else {
				defalut = ("" + rightnum + (leftnum + rightnum - 10));
				cnt++;
			}

			if (defalut.equals(userInput)) {
				break;
			}

		}

		System.out.println(cnt);
	}

}