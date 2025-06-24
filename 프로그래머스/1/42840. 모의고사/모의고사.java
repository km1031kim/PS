import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        
        int[] first = new int[]{1,2,3,4,5};
        int[] second = new int[]{2,1,2,3,2,4,2,5};
        int[] thrid = new int[]{3,3,1,1,2,2,4,4,5,5};

        int max = 0;
        int[] history = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            
            int firstAnswer = first[i % first.length];
            int secondAnswer = second[i % second.length];
            int thirdAnswer = thrid[i % thrid.length];

            
            if (firstAnswer == answer) {
                history[0] = history[0] + 1;
                max = Math.max(max, history[0]);
            }
            
             if (secondAnswer == answer) {
                history[1] = history[1] + 1;
                max = Math.max(max, history[1]);
            }
            
             if (thirdAnswer == answer) {
               history[2] = history[2] + 1;
               max = Math.max(max, history[2]);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        
        for (int i = 0; i < history.length; i++) {
            if (max == history[i]) {
                arrayList.add(i+1);
            }
        }
        
        arrayList.sort(null);
        
        
       int[] answer = arrayList.stream().mapToInt(Integer::intValue).toArray();
 
        return answer;
    }
}