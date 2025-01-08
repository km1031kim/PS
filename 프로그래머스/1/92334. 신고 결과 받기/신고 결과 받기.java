
import java.util.*;


 class Solution{

        static class User{
            // User에는 해당 유저 아이디와, 해당 유저가 신고한 대상 유저id, 날 신고한 유저id Set이 있습니다.
            private String id;
            private Set<String> reportTarget = new HashSet<>();
            private Set<String> userReportMe = new HashSet<>();

            public User(String id) {
                this.id = id;
            }

            public void reportUser(String user) {
                // 내가 신고한 유저 목록..
                reportTarget.add(user);
            }

            public void getReported(String user) {
                // 유저로부터 신고당함.. 이미
                if (userReportMe.contains(user)) {
                    return;
                }
                userReportMe.add(user);
            }

            public int getReportedCnt() {
                return userReportMe.size();
            }

        }

        public int[] solution(String[] id_list, String[] report, int k) {

            // User는 id로 구분. <유저id, User객체>
            HashMap<String, User> map = new HashMap<>();

            // 1. 유저 넣기
            for (String id : id_list) {
                User user = new User(id);
                map.put(id, user);
            }


            // 2. report배열 반복 돌면서 정보 넣기
            for (String r : report) {
                String[] split = r.split(" ");
                String user = split[0];
                String target = split[1];
                User currentUser = map.get(user);  // 현재유저
                User targetUser = map.get(target); // 신고대상

                // 3. 내가 신고한 대상 등록
                currentUser.reportUser(target);

                // 4. 신고 당한쪽도 등록
                targetUser.getReported(user);
            }

            // 5. k번 이상 신고당한놈들은 arrayList에 추가
            ArrayList<String> userTobeBanned = new ArrayList<>();

            for (Map.Entry<String, User> userEntry : map.entrySet()) {
                String username = userEntry.getKey();
                User userObj = userEntry.getValue();
                if (userObj.getReportedCnt() >= k) {
                    userTobeBanned.add(username);
                }
            }

            // 6. 내가 신고한 놈들 중 몇명이 정지당했는지
            ArrayList<Integer> answerArray = new ArrayList<Integer>();
            
            for (int i = 0; i < id_list.length; i++) {
                int cnt = 0; // 몇명 정지시켰나 확인 cnt
                User currentUser = map.get(id_list[i]);

                for (String bannedUser : userTobeBanned) {
                    if (currentUser.reportTarget.contains(bannedUser)) {
                        cnt++;
                    }
                }
                answerArray.add(cnt);
            }
            return answerArray.stream().mapToInt(Integer::intValue).toArray();
        }
    }

