public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return helper(candidates,0,target);
    }
    private List<List<Integer>> helper(int[] nums,int from, int target){
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        for(int i=from;i<nums.length;i++){
            if(nums[i]==target){
                List<Integer> temp=new LinkedList<Integer>();
                temp.add(target);
                res.add(temp);
            }else if(nums[i]<target){
                List<List<Integer>> tres= helper(nums,i, target-nums[i]);
                for(List<Integer> l:tres){
                    l.add(0,nums[i]);
                    res.add(l);
                }
            }
            
        }
        return res;
    }
}
