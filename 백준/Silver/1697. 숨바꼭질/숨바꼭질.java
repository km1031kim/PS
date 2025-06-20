import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int K = Integer.parseInt(input.split(" ")[1]);
        
        // 방문 여부 체크
        int[] visited = new int[100001];
        visited[N] = 0;
        
        // queue
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        
        while (!queue.isEmpty()) {
          int now = queue.poll(); // 5
          int current = visited[now]; // 0
          int next = current + 1; // 1

          if (now == K) {
              bw.write(String.valueOf(current));
              bw.flush();
              bw.close();
              br.close();
              return;
          }
           
          // 앞으로 한칸
          int forward = now + 1;
        
          // 뒤로 한칸
          int backward = now - 1;
        
          // x2 순간이동
          int teleport = now * 2;
        
          // 맞는지 확인
          if (forward == K || backward == K || teleport == K) {
              bw.write(String.valueOf(next));
              bw.flush();
              bw.close();
              br.close();
              return;
          }
            
        // 조건 확인 0 100 000
        if (forward >= 0 && forward <= 100000 && visited[forward] == 0){
            if (forward + 1 == K || forward - 1 == K || forward * 2 == K) {
                bw.write(String.valueOf(next + 1));
                bw.flush();
                bw.close();
                br.close();
                return;
            }
            visited[forward] = next;
            queue.offer(forward);
        }
            
        if (backward >= 0 && backward <= 100000 && visited[backward] == 0){
            if (backward + 1 == K || backward - 1 == K || backward * 2 == K) {
                bw.write(String.valueOf(next + 1));
                bw.flush();
                bw.close();
                br.close();
                return;
            }
            visited[backward] = next;
            queue.offer(backward);
        }
            
        if (teleport >= 0 && teleport <= 100000 && visited[teleport] == 0){
            if (teleport + 1 == K || teleport - 1 == K || teleport * 2 == K) {
                bw.write(String.valueOf(next + 1));
                bw.flush();
                bw.close();
                br.close();
                return;
            }
              visited[teleport] = next;
              queue.offer(teleport);
            }
        }
    }
}