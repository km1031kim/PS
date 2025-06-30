class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];

        
        for (int i = 0; i < prices.length; i++) {
            int now = prices[i];
            
            for (int j = i + 1; j < prices.length; j++) {
                int next = prices[j]; // 2
                
                answer[i] = answer[i] + 1;  

                if (next < now) {
                    break;
                }
                
            }
            
            // System.out.println(i + " : " + answer[i]);
        }
        
        return answer;
    }
}