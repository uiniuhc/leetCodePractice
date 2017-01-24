public class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        for(int i=0;i<prices.length-1;i++){
            //if it goes up, we add the number    
            if(prices[i+1]-prices[i]>0)res+=prices[i+1]-prices[i];
        }
        return res;
    }
}
