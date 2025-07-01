class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int cards1Index = 0;
        int cards2Index = 0;
        String answer = "Yes";
        
        for (int i = 0; i < goal.length; i++) {
            String word = goal[i];
            
            if (cards1Index < cards1.length && cards1[cards1Index].equals(word)) {
                cards1Index++;
                continue;
            }
            
            if (cards2Index < cards2.length && cards2[cards2Index].equals(word)) {
                cards2Index++;
                continue;
            }
            
            answer = "No";
            
        }
        
        return answer;
    }
}