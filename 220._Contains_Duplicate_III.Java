public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k==0 || nums.length==0 || t<0)return false;
        TreeSet<Integer> set=new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++){
            Integer low=set.ceiling(nums[i]-t);
            Integer high=set.floor(nums[i]+t);
            if((low!=null && low<=nums[i])||(high!=null && high>=nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(i>=k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
