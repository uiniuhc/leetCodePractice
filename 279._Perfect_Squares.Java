public class Solution {
    public int numSquares(int n) {
        //init n nums
        int[] res=new int[n+1];
        for(int i=1;i*i<=n;i++){
            res[i*i]=1;
        }
        for(int i=1;i<=n;i++){
            //fill the form
            if(res[i]==0){
                int min=Integer.MAX_VALUE;
                //split it into two numbers
                for(int j=1;j*j<i && j*j<=i-j*j;j++){
                    if(res[j*j]+res[i-j*j]<min){
                        min=res[j*j]+res[i-j*j];
                    }
                }
                res[i]=min;
            }
        }
        return res[n];
        
    }
}
