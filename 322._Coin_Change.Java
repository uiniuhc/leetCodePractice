public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] strategy=new int[amount];
        return helper(coins,amount,strategy);
    }
    private int helper(int[] coins,int amount,int[]ans){
        if(amount<=0)return 0;
        if(ans[amount-1]!=0)return ans[amount-1];
        int min=Integer.MAX_VALUE;
        for(int i:coins){
            if(i<=amount){
                int tres=helper(coins,amount-i,ans);
                if(tres==-1)continue;
                if(tres+1<min)min=tres+1;
            }
        }
        if(min==Integer.MAX_VALUE) min=-1;
        ans[amount-1]=min;
        return min;
    }
}
