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
    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return true;
        Stack<TreeNode> lStack=new Stack<TreeNode>();
        Stack<TreeNode> rStack=new Stack<TreeNode>();
        lStack.push(root);
        rStack.push(root);
        TreeNode lcurr;
        TreeNode rcurr;
        while(!lStack.isEmpty() && !rStack.isEmpty()){
            lcurr=lStack.pop();
            rcurr=rStack.pop();
            if(lcurr==null && rcurr== null)continue;
            if((lcurr==null && rcurr!=null)||(rcurr==null && lcurr!=null))return false;
            if(lcurr.val!=rcurr.val)return false;
            //l first left then right
            lStack.push(lcurr.left);
            lStack.push(lcurr.right);
            //r first right then left
            rStack.push(rcurr.right);
            rStack.push(rcurr.left);
        } 
        return true;
        
    }
}
