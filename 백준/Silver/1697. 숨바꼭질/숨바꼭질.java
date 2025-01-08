import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // 방문했는지 여부를 확인하기 위한 array
    static int[] arr = new int[200000];
    static int cnt = 0;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
       // System.out.println("N : " + N + ", K : " + K);
    
        int result = start(N, K);
        System.out.println(result);
    }

    private static int start(int N, int K) {
        
        
        
        if (N == K) {
            return 0;
        }
        //System.out.println("함수 시작.. N : " + N + ", K : " + K);
        queue.offer(N);
        arr[N] = 0;
        int result = 0;

        while (!queue.isEmpty()) {
            //System.out.println(queue);
            //System.out.println("큐에 들어있어용");
            int tmp = queue.poll();

            cnt = arr[tmp];
        //    System.out.println("tmp = " + tmp + ", tmp의 cnt = " + cnt);

            int minus = tmp - 1; // 4
            int plus = tmp + 1; // 6
            int multiply = tmp  * 2; // 10
            cnt++;


            if (minus >= 0 && arr[minus] == 0) {
                arr[minus] = cnt;
            //    System.out.println("빼기1 값 등록 :" + minus + ", 카운트 값 : " + cnt);
                if (minus == K) {
                    result = arr[minus];
                    break;
                }
                queue.offer(minus);
            }
            if (plus < arr.length && arr[plus] == 0) {
                arr[plus] = cnt;
             //   System.out.println("더하기1 값 등록 :" + plus + ", 카운트 값 : " + cnt);
                if (plus == K) {
                    result = arr[plus];
                    break;
                }
                queue.offer(plus);
            }
            if (multiply < arr.length && arr[multiply] == 0) {
                arr[multiply] = cnt;
             //   System.out.println("곱하기2 값 등록 :" + multiply + ", 카운트 값 : " + cnt);
                if (multiply == K) {
                    result = arr[multiply];
                    break;
                }
                queue.offer(multiply);
            }

        }
        return result;
    }
}
