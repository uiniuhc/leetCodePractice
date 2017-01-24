public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeSet<Integer> window=new TreeSet<Integer>();
        HashMap<Integer,Integer> counts=new HashMap<Integer,Integer>();
        if(nums.length==0 || k==0)return new int[0];
        int[] ans=new int[nums.length-k+1];
        int i=0;
        for(;i<k;i++){
            if(!counts.containsKey(nums[i]))counts.put(nums[i],0);
            counts.put(nums[i],counts.get(nums[i])+1);
            window.add(nums[i]);
        }
        ans[0]=window.last();
        for(;i<nums.length;i++){
            //drop the one out of window
            if(counts.get(nums[i-k])==1){
                counts.remove(nums[i-k]);
                window.remove(nums[i-k]);
            }else{
                counts.put(nums[i-k],counts.get(nums[i-k])-1);
            }
            //add the new one
            window.add(nums[i]);
            if(!counts.containsKey(nums[i]))counts.put(nums[i],0);
            counts.put(nums[i],counts.get(nums[i])+1);
            //get the ans
            ans[i-k+1]=window.last();
        }
        return ans;
    }
}
