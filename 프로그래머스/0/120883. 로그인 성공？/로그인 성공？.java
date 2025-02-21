import java.util.HashMap;
class Solution {
        String solution(String[] id_pwd, String[][] db) {


            String id = id_pwd[0];
            String pwd = id_pwd[1];

            HashMap<String, String> map = new HashMap<>();

            for (int i = 0; i < db.length; i++) {
                map.put(db[i][0], db[i][1]);
            }

            if (map.containsKey(id)) {
                if (map.get(id).equals(pwd)) {
                    return "login";
                } else {
                    return "wrong pw";
                }
            } else {
                return "fail";
            }
        }
    }