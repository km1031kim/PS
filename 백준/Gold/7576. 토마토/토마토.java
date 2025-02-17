
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int M = Integer.parseInt(s.split(" ")[0]);
        int N = Integer.parseInt(s.split(" ")[1]);
        int[][] box = new int[N][M]; // 상자
        ArrayDeque<String> queue = new ArrayDeque<>(); // 익은 토마토를 담을 큐.
        HashMap<String, Integer> map = new HashMap<>(); // 토마토위치, 익은날짜

        int yet = 0; // 안익은토마토

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < row.length; j++) {
                int each = Integer.parseInt(row[j]);

                if (each == 0) {
                    yet++;
                } else if (each == 1) {
                    queue.offer(i + " " + j);
                    map.put(i + " " + j, 0);
                }
                box[i][j] = each;
            }
        }

        if (yet == 0) {
            System.out.println(0);
            return;
        }


        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        int date = 0;

        while (!queue.isEmpty()) {
            String tomato = queue.poll();  // 현재 토마토 뽑기
            date = Math.max(date, map.get(tomato));

            int row = Integer.parseInt(tomato.split(" ")[0]);
            int column = Integer.parseInt(tomato.split(" ")[1]);

            for (int i = 0; i < x.length; i++) {
                // 상하좌우 구하기
                int nextX = column + y[i];
                int nextY = row + x[i];

                if (nextY < N && nextY >= 0 && nextX < M && nextX >= 0 && box[nextY][nextX] == 0) {

                    box[nextY][nextX] = 1; // 익은걸로 체크
                    map.put(nextY + " " + nextX, date + 1);
                    queue.offer(nextY + " " + nextX);
                    yet--;
                }
            }
        }

        if (yet != 0) {
            System.out.println(-1);
        } else {
            System.out.println(date);
        }
    }
}
