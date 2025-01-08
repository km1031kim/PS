
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;


import static java.lang.Character.getNumericValue;
import static java.lang.Character.isDefined;


 class Solution {
        public String solution(int n, int k, String[] cmd) {

            // ArrayList 세팅.
            Node[] nodeArray = initNodeArray(n);

            // C 커맨드를 통해 제거된 노드는 스택에 들어갑니다.
            ArrayDeque<Node> deleteStack = new ArrayDeque<>();

            Node nowNode = nodeArray[k];


            for (int i = 0; i < cmd.length; i++) {
                String command = cmd[i];
                // 업다운의 경우 그냥 해당 수만큼 prev, next로 이동하면 됨..
                // 제거하거나 추가할 때는 그 위치를 정해줄거기 때문에 별도로 카운팅을 하지 않아도 된다.
                if (command.startsWith("D")) {
                  //  int distance = getNumericValue(command.charAt(command.length() - 1));
                    Integer distance = Integer.valueOf(command.substring(2));
                    for (int j = 0; j < distance; j++) {
                        nowNode = nowNode.next;
                    }
                    continue;
                } else if (command.startsWith("U")) {
                  //  int distance = getNumericValue(command.charAt(command.length() - 1));
                    Integer distance = Integer.valueOf(command.substring(2));
                    for (int j = 0; j < distance; j++) {
                        nowNode = nowNode.prev;
                    }
                    continue;
                } else  if (command.equals("C")) {
                    // 배열에서 빼는 경우 스택에 추가.
                    deleteStack.push(nowNode);
                    if (nowNode.prev == null) {
                        // 첫번째 노드인 경우
                        nowNode.next.prev = null;
                        nowNode = nowNode.next;
                    } else if (nowNode.next == null) {
                        // 마지막 노드인 경우
                        nowNode.prev.next = null;
                        nowNode = nowNode.prev;
                    } else {
                        // 중간 노드들, 앞뒤로 주소 바꾸기
                        nowNode.prev.next = nowNode.next;
                        nowNode.next.prev = nowNode.prev;
                        nowNode = nowNode.next;
                    }
                } else if (command.equals("Z")) {
                    Node retrivedNode = deleteStack.pop();

                    if (retrivedNode.next == null) {
                        // 마지막 노드였던 경우
                        retrivedNode.prev.next = retrivedNode;
                    } else if (retrivedNode.prev == null) {
                        // 첫번째 노드였던 경우
                        retrivedNode.next.prev = retrivedNode;
                    } else {
                        retrivedNode.next.prev = retrivedNode;
                        retrivedNode.prev.next = retrivedNode;
                    }
                }
            }

            String[] answer = new String[n];
            Arrays.fill(answer, "O");
            for (Node node : deleteStack) {
                answer[node.number] = "X";
            }

            return String.join("",answer);
        }

        private static Node[] initNodeArray(int n) {
            // 노드 생성 후 ArrayList에 넣기.
            // 인덱스에 넣다뺏다 해야하니까 ArrayList로..
            Node[] nodeArray = new Node[n];
            for (int i = 0; i < n; i++) {
                nodeArray[i] = new Node(i);
            }

            // 주소 세팅
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    nodeArray[i].prev = nodeArray[i - 1];
                }
                if (i < n - 1) {
                    nodeArray[i].next = nodeArray[i + 1];
                }
            }
            return nodeArray;
        }
        static class Node {
            Node prev;
            int number; // 디버깅을 위한 수
            Node next;

            public Node(int number) {
                this.number = number;
            }
        }
    }



