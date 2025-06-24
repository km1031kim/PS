import java.util.*;
import java.io.*;

class Solution {
    
    HashSet<Integer> set = new HashSet<>();
    
    public int[] solution(int[] numbers) {
        
        // 재귀네
        // set 필요
        // set -> array -> sort
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
           recursive(i, numbers, arrayList);
        }
        
        int[] answer = set.stream()
            .mapToInt(Integer::intValue).toArray();
        
        Arrays.sort(answer);
        
      
        return answer;
    }
    
    public void recursive(int startIndex, int[] numbers, ArrayList<Integer> arrayList) {
        // 탈출 조건
        if (arrayList.size() == 2) {
            
            int sum = 0;
            for (int component : arrayList) {
                sum += component;
            }
            
            set.add(sum);
            return;
        }
        
        for (int i = startIndex; i < numbers.length; i++) {
            int tmp = numbers[i];
            arrayList.add(tmp);
            recursive(i+1, numbers, arrayList);
            
            // 탈출 후 제거
            int last = arrayList.size() - 1;
            arrayList.remove(last);
            
        }
    }
}