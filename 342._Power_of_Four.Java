public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num==0)return false;
        int h=Integer.highestOneBit(num);
        int l=Integer.lowestOneBit(num);
        if(h==l && Integer.numberOfTrailingZeros(num)%2==0)return true;
        return false;
    }
}
