import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] inputArray;
    static int[] answerArray;
    static boolean[] isChecked;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] sInput1 = scanner.nextLine().split(" ");
        N = Integer.parseInt(sInput1[0]);
        M = Integer.parseInt(sInput1[1]);

        inputArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        answerArray = new int[M];
        isChecked = new boolean[N];

        recursive(0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    public static void recursive(int depth) {
        if (depth == M) {
            for (int i : answerArray) {
                result.append(i).append(" ");
            }
            result.append("\n");
            return;
        }

        int prev = -1; // 이전에 사용한 값을 저장
        for (int i = 0; i < N; i++) {
            if (!isChecked[i] && inputArray[i] != prev) { // 이전 값과 같지 않아야 중복 방지
                isChecked[i] = true;
                answerArray[depth] = inputArray[i];
                prev = inputArray[i]; // 현재 값을 이전 값으로 설정
                recursive(depth + 1);
                isChecked[i] = false;
            }
        }
    }
}
