import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);


        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(i);
            recursive(i, N, M, arrayList);    // 시작점, N, M, 어레이리스트
            arrayList.remove(arrayList.size() - 1);
        }

    }

    public static void recursive(int start, int N, int M, ArrayList<Integer> arrayList) {

        if (arrayList.size() == M) {
            for (Integer i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N ; i++) {
            arrayList.add(i);
            recursive(i, N, M, arrayList);
            arrayList.remove(arrayList.size() - 1);
        }

    }
}
