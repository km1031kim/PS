import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        // 기능별로 얼마나 걸리는지 확인하고 큐에 넣기
        for (int i = 0; i < progresses.length; i++) {
            // 100 - 30 / (double) speed
            int day = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            queue.offer(day);
        }
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        int count = 0;
        
        while (!queue.isEmpty()) {
            
            // 7 3 9
            int top = queue.poll(); // 7
            count++;
            
            while (!queue.isEmpty() && queue.peek() <= top) {
                queue.poll();
                count++;
            }
            
            System.out.println(count);
            arrayList.add(count);
            count = 0;
        }
        
        int[] answer = arrayList.stream().mapToInt(Integer::intValue).toArray();
        
        
        

        return answer;
        
        
    }
}