public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3)return 0;
        int res=0;
        for(int i=2,diff=A[1]-A[0],cont=1;i<A.length;i++){
            int curr=A[i]-A[i-1];
            if(diff==curr){
                cont++;
            }else{
                diff=curr;cont=1;
            }
            if(cont>=2){
                res+=cont-1;
            }
        }
        return res;
    }
}
