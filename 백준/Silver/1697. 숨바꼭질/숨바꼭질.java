import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int destination = Integer.parseInt(split[1]);
        int i = hideAndSeek(start, destination);
        System.out.println(i);

    }

    private static int hideAndSeek(int start, int destination) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[100001];
        visited[start] = 0;
        queue.offer(start);
        int result = 0;

        if (start == destination) {
            return result;
        }

        while (!queue.isEmpty()) {

            // 큐에서 꺼내고
            int currentLocation = queue.poll();   // visited[5] = 0
            int currentTime = visited[currentLocation];

            // 목적지인지 확인
            if (currentLocation == destination) {
                return visited[currentLocation];
            }

            currentTime++;

            // 목적지가 아닌 경우 +1, -1, * 2 큐에 넣고 배열에 체크
            int plus = currentLocation + 1;
            int minus = currentLocation - 1;
            int multiply = currentLocation * 2;

            if (plus < visited.length && visited[plus] == 0) {
                visited[plus] = currentTime;
                if (plus == destination) {
                    result =  visited[plus];
                    break;
                }
                queue.offer(plus);
            }

            if (minus >= 0 && visited[minus] == 0) {
                visited[minus] = currentTime;
                if (minus == destination) {
                    result =  visited[minus];
                    break;
                }
                queue.offer(minus);
            }

            if (multiply < visited.length && visited[multiply] == 0) {
                visited[multiply] = currentTime;
                if (multiply == destination) {
                    result =  visited[multiply];
                    break;
                }
                queue.offer(multiply);
            }
        }
        return result;
    }
}
