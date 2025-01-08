
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
         *  풀기 전 생각..
         *  원형 큐를 활용하면 좋을 것 같다.
         *  Node 만들고 끝과 끝을 이으면??
         *
         *
         */

        Scanner sc = new Scanner(System.in);
        String[] splitedInput = sc.nextLine().split(" ");
        int N = Integer.parseInt(splitedInput[0]);
        int K = Integer.parseInt(splitedInput[1]);

        // 제거된 순번은 여기로..
        ArrayDeque<Integer> answer = new ArrayDeque<>();

        // 1. 노드 세팅
        ArrayList<Node> nodes = initnodes(N);

        // 삭제 작업 시작
        // 2.. currentNode에 접근
        Node currentNode = nodes.get(K - 1);

        while(true) {
            // 3. 큐에 넣자,.
            answer.offer(currentNode.number);

            if (answer.size() == N) {
                break;
            }
           /* if (currentNode.next != null && currentNode.prev !=null && currentNode.prev == currentNode.next) {
                // 6. 이전 노드와 다음 노드가 같다?? -> 이제 하나만 남아있는거임.. 그냥 다음꺼 넣으면 됨.
                answer.offer(currentNode.next.number);
                break;
            }*/

            // 4. 삭제 전 이전, 이후 노드 세팅
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;

            // 5. 다음 노드 찾기
            for (int i = 0; i < K; i++) {
                currentNode = currentNode.next;
            }
        }

        // 7. 큐에서 빼고, 요구사항 출력
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        for (Integer i : answer) {
            if (answer.size() == 1) {
                sb.append(answer.poll() + ">");
            } else {
                sb.append(answer.poll() + ", ");
            }
        }
        System.out.println(sb.toString());


    }
    public static ArrayList<Node> initnodes(int N) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i + 1));
        }

        for (int i = 0; i < N; i++) {
            Node node = nodes.get(i);
            if (i < N - 1) { // next가 존재함
                if (i == 0) {
                    node.prev = nodes.get(N - 1);
                }
                node.next = nodes.get(i + 1);
            }
            if (i > 0) { // prev가 존재함
                if (i == N - 1) {
                    node.next = nodes.get(0);
                }
                node.prev = nodes.get(i - 1);
            }
        }
        return nodes;
    }



    static class Node {
        int number;
        Node next;
        Node prev;

        public Node(int number) {
            this.number = number;
        }
    }
}
