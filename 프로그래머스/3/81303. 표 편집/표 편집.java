import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Node[] nodeList = new Node[n];
        for (int i = 0; i < n; i++) {
            nodeList[i] = new Node(i);
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) nodeList[i].prev = nodeList[i - 1];
            if (i < n - 1) nodeList[i].next = nodeList[i + 1];
        }

        Node currentNode = nodeList[k];
        Deque<Node> deleteStack = new ArrayDeque<>();
        Set<Integer> deleted = new HashSet<>();

        for (String c : cmd) {
            String[] split = c.split(" ");
            String command = split[0];

            if (command.equals("U")) {
                int x = Integer.parseInt(split[1]);
                for (int i = 0; i < x; i++) currentNode = currentNode.prev;
            } else if (command.equals("D")) {
                int x = Integer.parseInt(split[1]);
                for (int i = 0; i < x; i++) currentNode = currentNode.next;
            } else if (command.equals("C")) {
                deleteStack.push(currentNode);
                deleted.add(currentNode.index);

                if (currentNode.prev != null) currentNode.prev.next = currentNode.next;
                if (currentNode.next != null) currentNode.next.prev = currentNode.prev;
                currentNode = (currentNode.next != null) ? currentNode.next : currentNode.prev;
            } else if (command.equals("Z")) {
                Node restored = deleteStack.pop();
                deleted.remove(restored.index);

                if (restored.prev != null) restored.prev.next = restored;
                if (restored.next != null) restored.next.prev = restored;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(deleted.contains(i) ? 'X' : 'O');
        }

        return sb.toString();
    }

    class Node {
        int index;
        Node prev, next;
        Node(int index) {
            this.index = index;
        }
    }
}
