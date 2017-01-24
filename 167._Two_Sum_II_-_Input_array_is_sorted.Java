public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res=new int[2];
        for(int i=0;i<numbers.length && numbers[i]<=(target/2);i++){
            int r=binarySearch(numbers,target-numbers[i]);
            if(r==i)return res;
            if(r>=0){
                res[0]=i+1;
                res[1]=r+1;
                return res;
            }
        }
        return res;
    }
    //if same, always return right most one
    private int binarySearch(int[] nums, int target){
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                if(mid+1<nums.length && nums[mid+1]==target) l=mid+1;
                else return mid;}
            else if(nums[mid]<target) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}
