
import java.util.*;


class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

            HashMap<String, Agent> agentMap = new HashMap<>();

            // 세팅
            for (int i = 0; i < enroll.length; i++) {
                String name = enroll[i];
                String referralName = referral[i];
                if (referralName.equals("-")) {
                    referralName = null;
                }
                agentMap.put(name, new Agent(name, referralName, 0));
            }

            // 계산
            for (int i = 0; i < seller.length; i++) {
                String sellerName = seller[i];
                int totalPrice = amount[i] * 100;
                Agent agent = agentMap.get(sellerName);
                agent.calcProfit(agentMap, totalPrice);
            }

            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < enroll.length; i++) {
                arrayList.add(agentMap.get(enroll[i]).income);
            }
            return arrayList.stream().mapToInt(Integer::intValue).toArray();
        }
    
      static class Agent {
            String name;
            String referral;
            int income;

            public Agent(String name, String referral, int income) {
                this.name = name;
                this.referral = referral;
                this.income = income;
            }

            public void calcProfit(Map<String, Agent> map, int totalPrice) {
                /**
                 * 1. 계산.
                 * 2. income 넘기기
                 */
                int toReferral = (int) (totalPrice * 0.1);

                if (toReferral < 1) {
                    // 내가 다머금
                    this.income += totalPrice;
                    return;
                }

                if (referral == null) {
                    // 계산하고 종료
                    this.income += totalPrice - toReferral;
                    return;
                }

                // 다음 호출
                this.income += totalPrice - toReferral;
                Agent agent = map.get(this.referral);
                agent.calcProfit(map, toReferral);
            }

      
        }
    }
