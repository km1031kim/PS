import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean[] isChecked;
    static int[] answerArray;
    static int[] inputArray;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        inputArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        isChecked = new boolean[N];
        answerArray = new int[M];
        recursive(0,0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    static void recursive(int start,int depth) {
        if (depth == M) {
            for (int i : answerArray) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = start; i < N; i++) {
            if (inputArray[i] != prev) {
                answerArray[depth] = inputArray[i];
                prev = inputArray[i];
                recursive( i,depth+1);
            }
        }
    }
}
