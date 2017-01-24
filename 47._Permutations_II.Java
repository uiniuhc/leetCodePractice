public class Solution {
    private void reverseArr(int[] nums, int l, int r){
        while(l<r){
            int t=nums[r];
            nums[r]=nums[l];
            nums[l]=t;
            l++;r--;
        }
    }
    public boolean nextPermutation(int[] nums) {
        if(nums.length<=1)return true;
        int last=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=last){
                //ok,nothing need to change
                last=nums[i];
            }else{
                //need change
                //find first one larger than it
                for(int j=nums.length-1;j>i;j--){
                    if(nums[j]>nums[i]){
                        //swap them 
                        int t=nums[i];
                        nums[i]=nums[j];
                        nums[j]=t;
                        break;
                    }
                }
                //reverse the part after i
                reverseArr(nums,i+1,nums.length-1);
                return false;
            }
        }
        reverseArr(nums,0,nums.length-1);
        return true;
    }
    private List<Integer> getList(int[] nums){
        List<Integer> res=new ArrayList<Integer>();
        for(int i:nums){
            res.add(i);
        }
        return res;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res= new ArrayList<List<Integer>>();
        if(nums.length<1)return res;
        Arrays.sort(nums);
        res.add(getList(nums));
        while(!nextPermutation(nums)){
            res.add(getList(nums));
        }
        return res;
    }
}
