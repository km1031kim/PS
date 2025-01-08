
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);


        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean[] check = new boolean[n];
            check[i] = true;

            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(i + 1);

            recursive(i, n, m, check, arrayList, answer); // 시작점, 길이, 조건, 현재문자열, 전체문자열
            arrayList.clear();
        }

        for (String s : answer) {
            System.out.println(s);
        }

    }

    private static void recursive(int i, int n, int m, boolean[] check, ArrayList<Integer> arrayList, ArrayList<String> answer) {

        if (arrayList.size() == m) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < arrayList.size(); j++) {
                sb.append(arrayList.get(j));

                if (j == arrayList.size() - 1) {
                    continue;
                }
                sb.append(" ");
            }
            answer.add(sb.toString());
            return;
        }

        for (int j = 0; j < n ; j++) {

            if (j == i || check[j]) {
                continue;
            }

            arrayList.add(j + 1);
            check[j] = true; // t t f f
            recursive(i, n, m, check, arrayList,answer);
            check[j] = false;
            arrayList.remove(arrayList.size()-1);
        }
    }
}