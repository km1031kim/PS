import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);


        for (int i = 0; i < N; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int element = i + 1;
            arrayList.add(element);
            recursive(element, N, M, arrayList);
        }
    }

    static void recursive(int element, int N, int M, ArrayList<Integer> arrayList) {
        if (arrayList.size() == M) {
            for (Integer i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = element; i < N; i++) {
            // 무의미한 반복 줄이기
            if (N - i + arrayList.size() < M) {
                return;
            }
            int temp = i +1;
            arrayList.add(temp);
            recursive(temp, N, M, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
