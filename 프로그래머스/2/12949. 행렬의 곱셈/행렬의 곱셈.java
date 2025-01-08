import java.util.Arrays;
 
class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {

            // 기준 배열과 같은 크기를 가짐.
            int[][] answer = new int[arr1.length][arr2[0].length];

            for (int i = 0; i < arr1.length; i++) {
                // 행 반복
              //  System.out.println("i = " + i);
                for (int j = 0; j < arr2[0].length; j++) {
                 //  System.out.println("j = " + j);
                    int sum = 0;
                    for (int k = 0; k < arr1[0].length; k++) {
                      //  System.out.println("i = " + i + ", j = " + j + ", k = " + k);

                        sum += arr1[i][k] * arr2[k][j];
                        // 00 00
                        // 01 10
                        // 02 20

                        // j ==1

                    }
                 //   System.out.println("sum = " + sum);
                    answer[i][j] = sum;
                }
            }
            return answer;
        }
    }