
import java.util.Arrays;
import java.util.Comparator;

class Solution {

     int[][] answer;
     int index;

    public int[][] solution(int[][] nodeinfo) {


            // 1. Node 배열 생성
            Node[] nodes = new Node[nodeinfo.length];

            for (int i = 0; i < nodeinfo.length; i++) {
                nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
            }

            // 2. Node 배열 정렬. y 내림차순, y가 같은 경우 x 오름차순.
            Arrays.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.y == o2.y) {
                        // y가 같은 경우 x 오름차순.
                        return o1.x - o2.x;
                    }

                    return o2.y - o1.y;
                }
            });

            // 3. 노드 연결
            Node root = nodes[0];

            for (int i = 1; i < nodes.length; i++) {
                insertNode(root, nodes[i]);
            }

            // 4. 순회
            answer = new int[2][nodeinfo.length];

            // 전위 순회
            index = 0;
            preOrder(root);

            index = 0;
            postOrder(root);
            return answer;
        }

        public void preOrder(Node root) {
            if (root != null) {
                answer[0][index++] = root.value;
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        public void postOrder(Node root) {
            if (root != null) {
                postOrder(root.left);
                postOrder(root.right);
                answer[1][index++] = root.value;
            }
        }

        public void insertNode(Node root, Node candidate) {
            // root 의 왼쪽
            if (candidate.x < root.x) {
                if (root.left == null) {
                    root.left = candidate;
                    return;
                }
                insertNode(root.left, candidate);
                return;
            }

            if (root.right == null) {
                root.right = candidate;
                return;
            }
            insertNode(root.right, candidate);
        }
        
     static class Node {
        // x, y, value, left, right
        int x;
        int y;
        int value;
        Node left;
        Node right;

        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}