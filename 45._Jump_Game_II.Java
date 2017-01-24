public class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1)return 0;
        int [] canGo=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            canGo[i]=nums[i]+i;
            if(canGo[i]>nums.length-1)canGo[i]=nums.length-1;
        }
        int res=0;
        int curr=0;
        //every time find largest nex one 
        while(curr<nums.length-1){
            //need jump
            int max=0;
            int index=0;
            for(int i=curr+1;i<=canGo[curr] && i<=nums.length-1;i++){
                if(canGo[i]>=max){
                    max=canGo[i];
                    index=i;
                }
            }
            curr=index;
            res++;
            
        }
        return res;
    }
}
