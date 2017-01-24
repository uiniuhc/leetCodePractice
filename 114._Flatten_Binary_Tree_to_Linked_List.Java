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
    public void flatten(TreeNode root) {
        //mid left right
        flattenHelper(root);
    }
    //return the last one and the first one
    private TreeNode flattenHelper(TreeNode root){
        if(root==null)return null;
        //every time, first is the middle, then, left then right
        TreeNode left=root.left;
        TreeNode right=root.right;
        TreeNode last=root;
        root.left=null;
        if(left!=null){
            root.right=left;
            TreeNode lend=flattenHelper(left);
            lend.right=right;
            last=lend;
        }else{
            root.right=right;
        }
        if(right!=null){
            last=flattenHelper(right);
        }
        return last;
    }
}
