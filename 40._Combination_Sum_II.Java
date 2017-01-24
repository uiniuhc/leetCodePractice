public class Solution {
    List<List<Integer>> res;
    HashSet<String> sol;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        sol=new HashSet<String>();
        combinationHelper(candidates,0,new ArrayList<Integer>(),target);
        return res;
    }
    //pred: sorted nums
    private void combinationHelper(int[] nums,int from, List<Integer> pre,int target){
        if(target==0){
            if(pre.size()!=0)
                res.add(pre);
            return;
        }
        if(from>=nums.length)return;
        if(nums[from]>target)return;//no possible answers
        //choose the 'from' digit
        if(nums[from]<=target){
            ArrayList<Integer> tt=new ArrayList<Integer>(pre);
            //check dups
            tt.add(nums[from]);
            StringBuilder sb=new StringBuilder();
            for(int ii:tt){
                sb.append(ii);
                sb.append(' ');
            }
            String s=sb.toString();
            if(!sol.contains(s)){
                combinationHelper(nums,from+1,tt,target-nums[from]);
                sol.add(s);
            }
        }
        //not choose that digit
        ArrayList<Integer> t=new ArrayList<Integer>(pre);
        combinationHelper(nums,from+1,t,target);
        
        
        
    }
}
