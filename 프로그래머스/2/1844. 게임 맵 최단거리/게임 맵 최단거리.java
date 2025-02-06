
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;



    class Solution {
        
        
    static class Node {
        private int x;
        private int y;
        private int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }


        public int solution(int[][] maps) {

            ArrayDeque<Node> queue = new ArrayDeque<>();
            int answer = -1;
            int[] moveX = {1, -1, 0, 0};
            int[] moveY = {0, 0, 1, -1};

            Node startNode = new Node(0, 0, 1);
            queue.offer(startNode);

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (node.getX() == maps.length - 1 && node.getY() == maps[0].length - 1) {
                    answer = node.getCnt();
                    break;
                }

                // 이 부분도 생각치 못했음.
                for (int i = 0; i < moveX.length; i++) {
                    int nextX = node.getX() + moveX[i];
                    int nextY = node.getY() + moveY[i];
             
                    // 범위 안에 들어있다면?
                    if (nextX < maps.length && nextX >= 0 && nextY < maps[0].length && nextY >= 0 && maps[nextX][nextY] != 0) {
                        queue.offer(new Node(nextX, nextY, node.getCnt() + 1));
                        maps[nextX][nextY] = 0;
                    }

                }
            }

            return answer;
        }
    }
