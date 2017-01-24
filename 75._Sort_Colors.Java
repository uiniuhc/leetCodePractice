public class Solution {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length==0){
            return ;
        }
        int[] val=new int [3];
        for(int ll:val){
            ll=0;
        }
        for(int ii:nums){
            val[ii]+=1;
        }
        int index=0;
        int col=0;
        boolean flag=true;
        while(flag){
            if(val[col]>0){
                nums[index++]=col;
                val[col]--;
            }
            else {
                col++;
                if(col==3){
                    flag=false;
                }
            }
        }
    }
}
