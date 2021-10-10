class Solution {
    public int coinChange(int[] coins, int amount) {
        //think of smaller subproblems
        //what is the smallest number of problem to make cents?
        
        //dp array stores fewest array for 
        // dp[0] -> 0
        //dp[n] = min 
        int[] dp= new int[amount+1]; // 0 based - +1
        
        Arrays.fill(dp,amount+1);
        
        //bottome up processing
        //fewest coins to make 0 cents
        dp[0] = 0;
        for(int i = 0;i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
