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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 0;
        return helper(root.left,true)+helper(root.right,false);
    }
    private int helper(TreeNode root, boolean isLeft){
        if(root==null)return 0;
        if(root.left==null && root.right==null){
            if(isLeft)return root.val;else return 0;
        }
        return helper(root.left,true)+helper(root.right,false);
    }

}
