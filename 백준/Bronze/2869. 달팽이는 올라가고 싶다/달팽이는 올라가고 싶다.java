import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		br.close();
		int move = Integer.parseInt(arr[0]);
		int slip = Integer.parseInt(arr[1]);;
		int destination = Integer.parseInt(arr[2]);
		
		
		int days = (destination - slip) / (move - slip);
		if((destination - slip) % (move - slip)  != 0) {
			days++;
			
		}
		
		System.out.println(days);
		
		
		// 달팽이는 올라가고 싶다요..
		
		// 공식을 세워서 풀어야 시간 제한에 걸리지 않는다.
		
		// 올라가면 떨어지니까.. 애초에 떨어질 높이를 목표로 삼자.
		
		// 하루에 2m 올라가고 1m 내려오고 5m가 목표일 때
		
		// 결국 (5-1) / (2-1) 만 올라가면 되는거.
		
	}

}