public class Solution {

    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        ArrayList<Integer> endList=new ArrayList<Integer>();
        endList.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            int pos=Collections.binarySearch(endList,nums[i]);
            if(pos>=0){
                continue;
            }
            pos=-(pos+1);
            if(pos==endList.size()){
                endList.add(nums[i]);
            }else{
                endList.set(pos,nums[i]);
            }
        }
        return endList.size();
    }
}
