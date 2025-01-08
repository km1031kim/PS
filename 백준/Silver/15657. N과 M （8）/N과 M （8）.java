
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int limit  = Integer.parseInt(split[1]);

        Integer[] numberArray = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
        Arrays.sort(numberArray);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 출력의 수는 정해져 있음 -> 배열 사용, depth 사용
        // 오름차순이다 -> 이전 요소는 안돌아가도 된다. +1로 돌리면 될듯
        for (int i = 0; i < numberArray.length; i++) {
            // 9 8 7 1
            int[] answerArray = new int[limit];
            int start = numberArray[i]; // 1
            int depth = 0;
            answerArray[depth] = start; // {1, 0}
            recursive(i, depth+1, limit, answerArray, numberArray, bw);
        }

        bw.flush();
        bw.close();

    }

    private static void recursive(int start, int depth, int limit, int[] answerArray, Integer[] numberArray, BufferedWriter bw) throws IOException {

        // 종료조건
        if (depth == limit) {
            for (int i : answerArray) {
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = start; i < numberArray.length; i++) {
            // 1 1 limit answer number bw
            Integer temp = numberArray[i];
            answerArray[depth] = temp; // answer[1] = number[1]
            recursive(i, depth+1, limit, answerArray, numberArray, bw);
        }
    }
}


