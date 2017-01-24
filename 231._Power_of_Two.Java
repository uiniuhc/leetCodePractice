public class Solution {
    public boolean isPowerOfTwo(int n) {
        int rightMost=n&(-n);
        if(n-rightMost==0 && rightMost>0){
            return true;
        }
        return false;
    }
}
