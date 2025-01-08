
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;


     class Solution{
        public String[] solution(String[] record) {

            /**
             *  풀기 전 생각
             *  1. map이 필요하다.
             *  2. 큐에 히스토리를 담는다. change는 큐에 담지 않는다.
             *  3. change 시 uuid에 해당되는 밸류를 바꾼다.
             *  4. 결과 출력 시 밸류를 기반으로 출력한다.
             */

            // key: uuid, value: 유저명
            HashMap<String, String> userMap = new HashMap<>();

            // 히스토리를 담는 큐
            ArrayDeque<String> historyQueue = new ArrayDeque<>();


            // 커맨드와, uuid, 유저명을 분리한다.
            for (String history : record) {
                String[] splitedHistory = history.split(" ");
                String cmd = splitedHistory[0];

                if (cmd.equals("Enter")) {
                    String uid = splitedHistory[1];
                    String username = splitedHistory[2];
                    userMap.put(uid, username);
                    historyQueue.offer(cmd+":"+uid);
                    continue;
                }

                if (cmd.equals("Leave")) {
                    String uid = splitedHistory[1];
                   // userMap.remove(uid);
                    historyQueue.offer(cmd+":"+uid);
                    continue;
                }

                if (cmd.equals("Change")) {
                    String uid = splitedHistory[1];
                    String newName = splitedHistory[2];
                    userMap.put(uid, newName);
                }
            }

            // 결과 출력.. 스트림 연습
            String[] result = historyQueue.stream()
                    .map(s -> {
                        String[] split = s.split(":");
                        String cmd = split[0];
                        String uid = split[1];
                        if (cmd.equals("Enter")) {
                            return userMap.get(uid) + "님이 들어왔습니다.";
                        } else if (cmd.equals("Leave")) {
                            return userMap.get(uid) + "님이 나갔습니다.";
                        }
                        return "";
                    })
                    .toArray(String[]::new);

            return result;
        }
    }

