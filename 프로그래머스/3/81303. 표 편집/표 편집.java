import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        ArrayList<Node> nodeList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            nodeList.add(new Node(i));
        }
        
        // node 연결
        for (int i = 0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);
            
            if (i == 0) {
                // prev 없음
                node.next = nodeList.get(i+1);
                continue;
            }
            
            if (i == nodeList.size() - 1) {
                // next 없음
                node.prev = nodeList.get(i-1);
                continue;
            }
            
            node.next = nodeList.get(i+1);
            node.prev = nodeList.get(i-1);
        }
        
        ArrayDeque<Node> history = new ArrayDeque<>();
        Node currentNode = nodeList.get(k);
    
        
        for (int i = 0; i < cmd.length; i++) {
            String current = cmd[i];
            String command = current.split(" ")[0];
            
            if (command.equals("U")) {
                // null 이 아니고 prev가 활성화 된 놈들만 찾기
                int value = Integer.parseInt(current.split(" ")[1]);

                for (int j = 0; j < value; j++) {
                    currentNode = currentNode.getPrev();
                }
                continue;
            }
            
            if (command.equals("D")) {
                int value = Integer.parseInt(current.split(" ")[1]);

                for (int j = 0; j < value; j++) {
                    currentNode = currentNode.getNext();
                }
                continue;
            }
            
       
            if (command.equals("C")) {
                
                // 삭제 노드를 스택에 넣고
                history.push(currentNode);
                
                
                if (currentNode.getNext() == null) {
                    // 삭제 대상 행이 마지막 행인 경우
                    currentNode.getPrev().setNext(null);
                    currentNode.inactivate();
                    currentNode = currentNode.getPrev();
                    continue;
                }
                
                // 삭제 행이 마지막 행이 아닌 경우
                currentNode.getPrev().setNext(currentNode.getNext());
                currentNode.getNext().setPrev(currentNode.getPrev());
                currentNode.inactivate();
                currentNode = currentNode.getNext();
                continue;
            }
            
                   
            if (command.equals("Z")) {
                
                // 꺼낸다.
                if (!history.isEmpty()) {
                    Node restoredNode = history.pop();
                    restoredNode.activate();    

                    Node prevNode = restoredNode.getPrev();
                    Node nextNode = restoredNode.getNext();
                    
                    // 첫 노드인 경우
                    if (restoredNode.getIndex() == 0) {
                        // prev == null
                        nextNode.setPrev(restoredNode);
                        restoredNode.setNext(nextNode);
                        continue;
                    }
                    
                    // 마지막 노드인 경우
                    if (restoredNode.getIndex() == n - 1) {
                        // next == null
                        prevNode.setNext(restoredNode);
                        restoredNode.setPrev(prevNode);
                        continue;
                    }
                    
                    
                    // 중간에 낀 노드인 경우
                    prevNode.setNext(restoredNode);
                    nextNode.setPrev(restoredNode);
                    
                    
                } 
            }           
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (Node node : nodeList) {
            if (node.isActive()) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }
        
        String answer = sb.toString();;
        return answer;
    }
    
    public class Node {
        private int index;
        private Node prev;
        private Node next;
        private boolean isActive = true;
        
        public Node(int index) {
            this.index = index;
        }
        
        public void setNext(Node next){
            this.next = next;
        }
        
        public void setPrev(Node prev) {
            this.prev = prev;
        }
        
        public Node getNext(){
            
            // active 상태의 노드가 나올때까지 반복
            Node tmp = next;
            
            while (tmp != null && !tmp.isActive()) {
                tmp = tmp.next;
            }
            return tmp;
        }
        
        public Node getPrev() {
            
            // active 상태의 노드가 나올때까지 반복
            Node tmp = prev;
            
            while (tmp != null && !tmp.isActive()) {
                tmp = tmp.prev;
            }
           
            return tmp;
        }
        
        
        public int getIndex(){
            return index;
        }
        
        public boolean isActive(){
            return isActive;
        }
        
   
        public void inactivate() {
            this.isActive = false;
        }
        
        public void activate() {
            this.isActive = true;
        }
    }
}