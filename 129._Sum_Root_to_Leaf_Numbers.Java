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
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        return sumHelper(root, 0);
    }
    private int sumHelper(TreeNode root,int val){
        if(root==null)return 0;
        if(root.left==null && root.right==null){
            return val*10+root.val;
        }
        return sumHelper(root.left,val*10+root.val)+sumHelper(root.right,val*10+root.val);
    }
}
