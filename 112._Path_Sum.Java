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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)return false;
        Stack<TreeNode> sTree=new Stack<TreeNode>();
        Stack<Integer> sNum=new Stack<Integer>();
        sTree.push(root);
        sNum.push(root.val);
        TreeNode tmp=null;
        while(!sTree.isEmpty()){
            int v=sNum.pop();
            tmp=sTree.pop();
            if(tmp.right!=null){
                sTree.push(tmp.right);
                sNum.push(v+tmp.right.val);
            }
            if(tmp.left!=null){
                sTree.push(tmp.left);
                sNum.push(v+tmp.left.val);
            }
            if(tmp.left==null && tmp.right==null) if(v==sum)return true;
            
        
        }
        return false;
    }
}
