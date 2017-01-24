public class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> res=new LinkedList<Integer>();
        if(rowIndex==1){res.add(1);return res;}
        int[] last=new int[rowIndex+2];
        int[] curr=new int[rowIndex+2];
        last[0]=1;
        for(int i=2;i<=rowIndex;i++){
            int j=0;
            curr[j++]=1;
            if(i==rowIndex) res.add(1);
            //update
            for(int p=0,q=1;last[q]!=0;p++,q++){
                curr[j++]=last[p]+last[q];
                if(rowIndex==i)res.add(last[p]+last[q]);
            }
            curr[j++]=1;
            if(i==rowIndex) res.add(1);
            int[] t=last;
            last=curr;
            curr=t;
        }
        return res;
    }
}
