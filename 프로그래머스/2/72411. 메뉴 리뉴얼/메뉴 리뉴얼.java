import java.util.*;
import java.io.*;

class Solution {
    
    StringBuilder sb = new StringBuilder();
    int[] maxCount;

    HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
    
    public String[] solution(String[] orders, int[] course) {
        
        maxCount = new int[course[course.length - 1] + 1];
        for (int i = 0; i < orders.length; i++) {
            String order = orders[i]; // ABCFG
            
            char[] charArray = order.toCharArray();
            Arrays.sort(charArray);
            order = new String(charArray);
            
            for (int j = 0; j < course.length; j++) {
                int courseCount = course[j];
                recursive(0, order, new ArrayList<Character>(), courseCount);
            }
        }
        
        for (String key : resultMap.keySet()){
            System.out.println(key + " : "  + resultMap.get(key));
        }
                
        // 정답 추출
        // 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합.. 2 이상이여야 하고
        
        
        ArrayList<String> resultArray = new ArrayList<>();
        
        for (String key : resultMap.keySet()) {
            // ab     2
            
            int length = key.length();
            int value = resultMap.get(key);
                
            if (value >= 2 && maxCount[length] == value) {
                resultArray.add(key);
            }
        }

         resultArray.sort(null);

         for (String answer : resultArray){
            System.out.println(answer);
        }
        
       String[] answer = resultArray.toArray(String[]::new);
        
        return answer;
    }
    
    public void recursive(int index, String orderString, ArrayList<Character> courseArray, int courseCount) {
        
        // 탈출
        if (courseArray.size() == courseCount) {
            
            courseArray.sort(null);
            
            for (Character str : courseArray) {
                sb.append(String.valueOf(str));
            }
            
            String result = sb.toString();
            // 있으면 꺼내서+ 1, 없으면 1
            int value = resultMap.getOrDefault(result, 0) + 1;
            resultMap.put(result, value);
            sb.setLength(0);
        
            maxCount[courseCount] = Math.max(maxCount[courseCount], value);
            

            return;
        }
        
        // 재귀
        for (int i = index; i < orderString.length(); i++ ) {
            // 한 글자씩 추출
            char tmp = orderString.charAt(i);
            
            // 결과 스트링에 넣고
            courseArray.add(tmp);
            
            // 재귀 호출
            recursive(i+1, orderString, courseArray, courseCount);
            
            // 탈출 후 마지막 인덱스 값 삭제
            courseArray.remove(courseArray.size() - 1);
        }
    }
}