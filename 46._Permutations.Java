public class Solution {
    private List<List<Integer>> res;
    private int count;
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used=new boolean[nums.length];
        count=0;
        res=new ArrayList<List<Integer>>();
        Stack<Integer> curr=new Stack<Integer>();
        for(int i=0;i<nums.length;i++){
            permuteHelper(nums,used,i,curr);
        }
        return res;
    }
    
    private void permuteHelper(int[] nums,boolean[] used,int v,Stack<Integer> curr){
        curr.push(nums[v]);
        used[v]=true;
        count++;
        if(count==nums.length){
            res.add(new ArrayList<Integer>(curr));
        }else{
            for(int i=0;i<nums.length;i++){
                if(!used[i]){
                    permuteHelper(nums,used,i,curr);
                }
            }
        }
        curr.pop();
        used[v]=false;
        count--;
    }
}
