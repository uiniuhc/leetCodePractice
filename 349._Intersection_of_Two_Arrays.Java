public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums2.length==0)return new int[0];
        if(nums1.length>nums2.length)return intersection(nums2,nums1);
        HashSet<Integer> res=new HashSet<Integer>();
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i:nums1){
            if(!set.contains(i))set.add(i);
        }
        for(int i:nums2){
            if(set.contains(i))res.add(i);
        }
        int[] ans=new int[res.size()];
        int index=0;
        Iterator<Integer> iter=res.iterator();
        while(iter.hasNext()){
            int curr=iter.next();
            ans[index++]=curr;
        }
        return ans;
        
    }
}
