import java.util.Scanner;

public class doubling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int numOfTrades = scan.nextInt();
        int[] trades = new int[numOfTrades];

        for(int i = 0; i < numOfTrades; i++){
            trades[i] = scan.nextInt();
        }

        for (int tradeNum = 1; tradeNum <= trades.length; tradeNum++) {
            int i = trades[tradeNum - 1];
            int expectedAmount = i * 2;
            int actualAmount = (int) expectedAmount / 10;
            int loss = i - actualAmount;

            System.out.println("Trade #" + tradeNum + ": " + loss);
        }
        
        scan.close();
    }
}