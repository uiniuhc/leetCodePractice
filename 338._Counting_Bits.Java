public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0]=0;
        int size=1;
        int i=1;
        while(i<=num){
            res[i]=res[i-size]+1;
            i++;
            if(i==2*size){
                size*=2;
            }
        }
        return res;
    }
}
