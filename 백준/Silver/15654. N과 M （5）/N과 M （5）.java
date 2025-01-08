import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int numberCnt = Integer.parseInt(split[0]);
        int limit  = Integer.parseInt(split[1]);

        Integer[] numberArray = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
        Arrays.sort(numberArray);

        // 이제 시작
        // 출력 조건은 같다 -> 한번에 출력할거니까 버퍼 사용, 그리고 배열 사용
        // 깊이만 주면 됨.
        // 깊이가 limit과 같다면 출력
        // [1, 7, 8, 9]
        // 불린 배열 사용, 트루는 제외.

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] answerArray = new int[limit];
        boolean[] isChecked = new boolean[numberCnt];
        recursive(0, limit, isChecked, answerArray, numberArray, bw);
        bw.flush();
        bw.close();

    }

    public static void recursive(int depth, int limit, boolean[] isChecked, int[] answerArray, Integer[] numberArray, BufferedWriter bw) throws IOException {

        // 종료조건
        if (depth == (limit)) {

            for (int i : answerArray) {
                bw.write(i + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < numberArray.length; i++) {
            //  recursive(0, limit, isChecked, answerArray, numberArray, bw);

            if (isChecked[i]) {
                continue;
            }

            answerArray[depth] = numberArray[i]; // [1, 0, 0, 0]
            isChecked[i] = true; // [t f f f]
            recursive(depth+1, limit, isChecked, answerArray, numberArray, bw);
            isChecked[i] = false;

        }
    }
}


