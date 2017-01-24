/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
     List<List<TreeNode>> lists;
    public List<TreeNode> generateTrees(int n) {
        if(lists==null){
            lists=new ArrayList<List<TreeNode>>();
            lists.add(new ArrayList<TreeNode>());
        }
        if(n==0)return new ArrayList<TreeNode>();
        //if we have the result
        if(lists.size()>n){
            List<TreeNode> res=lists.get(n);
            return copyForRes(res);
        }
        
        for(int i=lists.size();i<=n;i++){
            lists.add(genTrees(i));
        }
        
        return copyForRes(lists.get(n));
        
    }
    private List<TreeNode> copyForRes(List<TreeNode> ll){
        List<TreeNode> res=new ArrayList<TreeNode>();
        for(TreeNode root:ll){
            TreeNode ct=copyTree(root);
            giveNumber(ct,1);
            res.add(ct);
        }
        return res;
    }
    //copy 
    private TreeNode copyTree(TreeNode root){
        if(root==null)return null;
        TreeNode res=new TreeNode(0);
        res.left=copyTree(root.left);
        res.right=copyTree(root.right);
        return res;
    }
    //preD: all less than n we already has solutions
    private List<TreeNode> genTrees(int n){
        if(lists.size()>n)return lists.get(n);
        List<TreeNode> res=new ArrayList<TreeNode>();
        if(n==0){
            return res;
        }
        if(n==1){
            res.add(new TreeNode(0));
            return res;
        }
        //left and right all has children
        for(int i=1;i<n-1;i++){
            List<TreeNode> left=genTrees(i);
            List<TreeNode> right=genTrees(n-i-1);
            for(TreeNode rleft:left){
                for(TreeNode rright:right){
                    TreeNode root=new TreeNode(0);
                    root.left=rleft;root.right=rright;
                    res.add(root);
                }
            }
        }
        //left or right is empty
        List<TreeNode> rn1=genTrees(n-1);
        for(TreeNode rr:rn1){
            TreeNode root1=new TreeNode(0);
            TreeNode root2=new TreeNode(0);
            root1.left=rr;root2.right=rr;
            res.add(root1);res.add(root2);
        }
        return res;
        
    }
    
    
    private int giveNumber(TreeNode root,int start){
        //left mid right
        if(root==null)return start;
        if(root.left==null && root.right==null){
            root.val=start;
            return start+1;
        }
        int res=giveNumber(root.left,start);
        root.val=res;
        return giveNumber(root.right,res+1);
    }
}
