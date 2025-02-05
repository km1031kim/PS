
import java.util.Arrays;


    class Solution {
        public int[] parent;

        public int find(int a) {
            if (parent[a] == a) {
                return a;
            } else {
                return parent[a] = find(parent[a]);
            }
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                System.out.println("find(a) = " + a);
                System.out.println("find(b) = " + b);
                parent[b] = a;
                System.out.println("parent[" + b + "] = " + a);
                System.out.println("========");

            }
        }

        public int solution(int n, int[][] costs) {

            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
            int result = 0;

            for (int i = 0; i < costs.length; i++) {
                int a = costs[i][0];
                int b = costs[i][1];
                int weight = costs[i][2];
                System.out.println("a = " + a);
                System.out.println("b = " + b);
                if (find(a) != find(b)) {
                    union(a, b);
                    result += weight;
                } else {
                    System.out.println("find(a) = " + find(a));
                    System.out.println("find(b) = " + find(b));
                    System.out.println(Arrays.toString(costs[i]));
                }
            }
            return result;
        }
    }
