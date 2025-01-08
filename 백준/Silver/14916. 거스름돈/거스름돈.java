import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt(); 
        int numberOfCoin = 0;
        
        if(input % 5 == 0) {
            System.out.println(input / 5);
        } else {
            while(true) {
                
                if(input < 0) {
                    System.out.println(-1);
                    break;
                }
                
                if(input == 0) {
                    System.out.println(numberOfCoin);
                    break;
                }
                
                input -= 2;
                numberOfCoin++;
                
                if(input % 5 == 0) {
                    numberOfCoin += input / 5;
                    System.out.println(numberOfCoin);
                    break;
                }
            }
        }
        
        sc.close();
    }
}
