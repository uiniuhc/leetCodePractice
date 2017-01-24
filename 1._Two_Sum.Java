public class Solution {
    private int binarySearch(int[] nums, int val){
        int l=0;int r=nums.length-1;
        int mid;
        while(l<=r){
            mid=(l+r)/2;
            if(nums[mid]==val)return mid;
            if(nums[mid]>val)r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
    private int listSearch(int[] nums,int val){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val)return i;
        }
        return -1;
    }
    public int[] twoSum(int[] nums, int target) {
        int [] res=new int[2];
        //count for twice
        if(target%2==0){
            int count=0;
            int val=target/2;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==val){
                    res[count++]=i;
                    if(count>=2)return res;
                }
            }
        }
        //no repeat will happen
        int[] nums2=nums.clone();
        Arrays.sort(nums2);
        //now let's do it with binary search
        for(int i=0;i<nums.length;i++){
            int t=binarySearch(nums2,target-nums[i]);
            if(t>0 && nums[i]!=nums2[t]){
                res[0]=i;
                res[1]=listSearch(nums,nums2[t]);
                return res;
            }
        }
        return res;
        
    }
}
