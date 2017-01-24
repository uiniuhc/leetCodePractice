import java.util.PriorityQueue;
public class Solution {
        //find largest sub sum start with start
    //return the first element of the sequence
    //return -1 if the largest is less than 0
    private int firstEOfLargestSubSum(int[] nums,int start){
        int j=start+1;
        int currMax=nums[start];
        int lastMax=nums[start];
        int currFirst=start;
        int lastFirst=start;
        for(int i=1;i<nums.length;i++,j++,j%=nums.length){
            if(currMax<0){
                currMax=nums[j];
                currFirst=j;
            }else{
                currMax+=nums[j];
            }
            if(currMax>lastMax){
                lastMax=currMax;
                lastFirst=currFirst;
            }
        }
        if(lastMax<0){
            return -1;
        }
        return currFirst;
    }
    private int findFirstNeg(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                return i;
            }
        }
        return -1;
    }
    private boolean checkSeq(int[] nums,int start){
        int j=start;
        int sum=0;
        for(int i=0;i<nums.length;i++,j++,j%=nums.length){
            sum+=nums[j];
            if(sum<0){
                return false;
            }
        }
        return true;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0){
            return -1;
        }
        //construct difference array
        int[] diff=new int[gas.length];
        for(int i=0;i<gas.length;i++){
            diff[i]=gas[i]-cost[i];
        }
        if(diff[0]>=0 && checkSeq(diff,0)){
            return 0;
        }
        int start=findFirstNeg(diff);
        int res=firstEOfLargestSubSum(diff,start);
        if(res<0){
            return -1;
        }
        if(checkSeq(diff,res)){
            return res;
        }
        return -1;
    }
}
