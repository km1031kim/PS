import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.io.OutputStreamWriter;

public class Main {
   
	 static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     public static void main(String[] args) throws NumberFormatException, IOException {
//      Scanner s = new Scanner(System.in);
    	 
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 
    	 int N =Integer.parseInt(br.readLine());
//	  int N = s.nextInt(); 
//	  System.out.println(Math.round(Math.pow(2,N)-1));
//	  System.out.println( (1<<N) - 1);
	  bw.write(Integer.toString((1<<N) - 1) );
	  bw.write("\n");
	  hanoi(N, "1", "3", "2");
      bw.flush();
      bw.close();
   }

   public static void hanoi(int n, String start, String end, String through) throws IOException {
      if (n == 1) { // 1일때 이동했다는 메세지 출력
//         System.out.println(start + " " + end + " ");
        bw.write(start + " " + end+"\n");
         // 한개일때 return
         
      } else {
         hanoi(n - 1, start, through, end); // 4개인 경우에 3개를 중간으로 이동
      
         // 제일 큰 한개를 목적지로 이동.
         // System.out.println(start + " " + end + "");
         bw.write(start + " " + end+"\n");
         // 나머지 3개를 목적지로 이동.
         hanoi(n - 1, through, end, start);
         
         
      }
   }
}