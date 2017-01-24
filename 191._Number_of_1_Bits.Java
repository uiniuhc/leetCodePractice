public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int i=n;
        int count=0;
        while(i!=0) {
            count++;
            i=i&(i-1);
        }
        return count;
    }
}
