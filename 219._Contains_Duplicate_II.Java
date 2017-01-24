public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<2 || k<1)return false;
        HashSet<Integer> set=new HashSet<Integer>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))return true;
            if(i>=k){
                set.remove(nums[i-k]);
            }
            set.add(nums[i]);
        }
        return false;
    }
}
