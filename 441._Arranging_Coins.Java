public class Solution {
    public int arrangeCoins(int n) {
        long s=n;
        return (int)((Math.sqrt(8*s+1)-1)/2);
        
    }
}
