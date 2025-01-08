import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] array = new int[M]; // 3 3 이면 길이는 3이니까
        recursive(N, M, 0, array, bw);
        bw.flush();
        bw.close();

    }

    static void recursive(int N, int M, int depth, int[] array, BufferedWriter bw) throws IOException {

        // 종료조건
        if (depth == M) {
            for (int i = 0; i < array.length; i++) {
                bw.write(array[i] + " ");
            }
            bw.newLine();
            return;
        }

        // 로직
        // 시작점만 고정, 처음부터 순회
        for (int i = 1; i <= N; i++) {
            // 1 ~ 3까지
            array[depth] = i; // [1,0,0]
            recursive(N, M, depth + 1, array, bw);
        }
    }
}
