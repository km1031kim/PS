import java.io.*;
import java.util.Arrays;


public class Main {

    private static int[] roots;
    private static int weight = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstLine = br.readLine();
        int N = Integer.parseInt(firstLine.split(" ")[0]); // 집의 갯수
        int M = Integer.parseInt(firstLine.split(" ")[1]); // 길의 갯수
        roots = new int[N + 1];
        int line = 0;


        int[][] ways = new int[M][3];

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            ways[i][0] = Integer.parseInt(input[0]);
            ways[i][1] = Integer.parseInt(input[1]);
            ways[i][2] = Integer.parseInt(input[2]);
        }

        for (int i = 1; i <= N; i++) {
            // 각자의 부모 초기화
            roots[i] = i;
        }


        Arrays.sort(ways, ((o1, o2) -> o1[2] - o2[2]));
        int delete = 0;

        // 2. 부모 설정
        for (int i = 0; i < M; i++) {
            if (line == N - 1) {
                break;
            }
            int start = ways[i][0];
            int dest = ways[i][1];
            int tmp = ways[i][2];

            int startNodeRoot = findRoot(start);
            int destNodeRoot = findRoot(dest);

            if (startNodeRoot != destNodeRoot) {
                roots[destNodeRoot] = startNodeRoot;
                weight += tmp;
                delete = tmp;
                line++;
            }
        }
        int answer = weight - delete;
        bw.write("" + answer);
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findRoot(int node) {
        // 나 자신이라면? 날 반환
        if (roots[node] == node) {
            return node;
        }
        return roots[node] = findRoot(roots[node]);
    }
}
