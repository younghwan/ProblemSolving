package DP.CoinChange;

import java.util.Arrays;

/*You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1
 */
public class Solution {
//    public int coinChange(int[] coins, int amount) {
//        int cnt = 0;
//        Arrays.sort(coins);
//        for(int i = coins.length-1; i>=0;i--)
//        {
//            int val = coins[i];
//            System.out.println(val);
//            while (val<=amount)
//            {
//                amount = amount-val;
//                cnt++;
//            }
//            if(amount == 0) break;
//        }
//        return (amount == 0) ? cnt : -1;
//    }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        dp[0] =1;
        for(int i = 1 ;i<=amount;i++)
        {
            for(int j = 0; j<=coins.length;j++){
                dp[j] += dp[j-coins[j]];
            }
        }
        return dp[amount];
    }
//    public static int coinChange(int[] coins, int amount) {
//        if (coins == null || coins.length == 0 || amount <= 0)
//            return 0;
//        int[] minNumber = new int[amount + 1];
//        for (int i = 1; i <= amount; i++) {
//            minNumber[i] = Integer.MAX_VALUE;
//            for (int j = 0; j < coins.length; j++) {
//                if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE)
//                    minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
//            }
//        }
//        if (minNumber[amount] == Integer.MAX_VALUE)
//            return -1;
//        else
//            return minNumber[amount];
//    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, 6249));
    }
}

/*
    1 2 3 4 5 6 7 8 9 10 11 amount
  1 1 1 1 1 1 1 1 1 1  1  1
  2 0 1 1 2 2 3 3 5 5  5
  5 0 0 0 0 1 1 2 2 3  4
 dp   2 2 3 3 4 5 7 8 10


 coin : 2 ,7
 amount : 10

candi 갯수(c)
 8 + 1 = 10
 3 + 1 = 10

 min(candi) = 3
  cand 갯수
    5   1 = 3
    4   1 = 3

 */