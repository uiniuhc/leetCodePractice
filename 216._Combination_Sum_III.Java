public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(n==0 ||k==0)return res;
        helper(k,n,1,res,new LinkedList<Integer>());
        return res;
    }
    private void helper(int k,int n,int from, List<List<Integer>> res,LinkedList<Integer> pre){
        if(k==0 && n==0){
            res.add(new ArrayList<Integer>(pre));
        }
        for(int i=from;i<=9;i++){
            pre.add(i);
            helper(k-1,n-i,i+1,res,pre);
            pre.removeLast();
        }
    }
}
