public class Solution {
    public String getPermutation(int n, int k) {
        if(n==0) return "";
        if(n==1) return "1";
        k--;
        int[] perm=new int[n+1];
        boolean[] using=new boolean[n+1];
        perm[0]=1;
        
        for(int i=1;i<=n;i++){
            perm[i]=i*perm[i-1];
        }
        if(k<0) k=(k%perm[n]+perm[n])%perm[n];
        while(k>perm[n]) k=k%perm[n];
        StringBuilder res=new StringBuilder();
        int base=n-1;
        while(k>0){
            int r=k/perm[base]+1;
            //find the digit, and use it
            for(int i=1,count=0;i<=n && count!=r;i++){
                if(using[i])continue;
                count++;
                if(count==r){
                    using[i]=true;
                    res.append(i);
                    break;
                }
            }
            //update k
            k=k%perm[base];
            base--;
        }
        //last digit
        for(int i=1;i<=n;i++) if(!using[i])res.append(i);
        return res.toString();
    }
}
