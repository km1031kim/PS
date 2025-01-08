
import java.util.HashMap;

 class Solution{
        public int solution(String[] want, int[] number, String[] discount) {

            int answer = 0; // 정답
            boolean isOK = true; // 회원가입 가능한지 여부 체크

            // 원하는 대상 Map에 저장
            HashMap<String, Integer> wantMap = new HashMap<>();
            for (int i = 0; i < want.length; i++) {
                wantMap.put(want[i], number[i]);
            }

            // 가능한 개수 체크를 위한 Map
            // 10개까지는 배열이 있어야 하니까 -9해서 반복
            for (int i = 0; i < discount.length - 9; i++) {
                
                // 회원가입 해도 될지 체크하기 전 개수 체크를 위한 map
                HashMap<String, Integer> discountMap = new HashMap<>();

                for (int j = i; j < i+10; j++) { // 현재 인덱스부터 10개 세야함.
                    String item = discount[j];
                    if (!discountMap.containsKey(item)) {
                        discountMap.put(item, 1);
                    } else {
                        discountMap.put(item, discountMap.get(item) + 1);
                    }
                }

                // 현재 구매 가능한 10개 목록 확인. 원하는 대상과 수가 일치하는 지 확인.
                for (String item : discountMap.keySet()) {
                    if (wantMap.get(item) != discountMap.get(item)) {
                        isOK = false;
                        break;
                    }
                }
                if (isOK) { answer++; } // 일치한다면 +1
                isOK=true; // isOK 초기값 세팅.
            }
            return answer;
        }
    }