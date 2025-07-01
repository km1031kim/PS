import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

       
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());


		if (N == 1) {
			System.out.println("<1>");
			return;
		}

		ArrayList<Node> nodeList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			nodeList.add(new Node(i+1));
		}

		for (int i = 0; i < nodeList.size(); i++) {
			Node node = nodeList.get(i);
			if (i==0) {
				node.next = nodeList.get(i+1);
				node.prev = nodeList.get(nodeList.size()-1);
				continue;
			}

			if (i== nodeList.size() -1) {
				node.prev = nodeList.get(i-1);
				node.next = nodeList.get(0);
				continue;
			}

			node.next = nodeList.get(i+1);
			node.prev = nodeList.get(i-1);
		}


		Node startNode = nodeList.get(0);

		ArrayList<Integer> answerArray = new ArrayList<>();

		while(true) {

			if (answerArray.size() == N) {
				break;
			}
			for (int i = 1; i < K; i++) {
				startNode = startNode.next;
			}

			// 3 선택 완료
			answerArray.add(startNode.index);
			startNode.prev.next = startNode.next;
			startNode.next.prev = startNode.prev;
			startNode = startNode.next;
		}


		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < answerArray.size(); i++) {
			if (i == answerArray.size() - 1) {
				sb.append(answerArray.get(i) + ">");
				break;
			}

			sb.append(answerArray.get(i) + ", ");
		}

		String answer = sb.toString();

		bw.write(answer);
		bw.flush();

		bw.close();
		br.close();




	}
	static class Node {
		Node next;
		Node prev;
		int index;

		public Node(int index) {
			this.index = index;
		}
	}
}
