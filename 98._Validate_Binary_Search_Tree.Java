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
    boolean min_showed;
    boolean max_showed;
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        min_showed=false;max_showed=false;
        if(root.val==Integer.MIN_VALUE)min_showed=true;
        if(root.val==Integer.MAX_VALUE)max_showed=true;
        return validHelper(root.left,Integer.MIN_VALUE,root.val) && 
        validHelper(root.right,root.val,Integer.MAX_VALUE);
    }
    private boolean validHelper(TreeNode root, int min, int max){
        if(root==null)return true;
        if(root.val==Integer.MIN_VALUE && root.left==null && min==root.val && !min_showed){
            min_showed=true;
            return validHelper(root.right,root.val,max);
        }
        if(root.val==Integer.MAX_VALUE && root.right==null && max==root.val && !max_showed){
            max_showed=true;
            return validHelper(root.left,min,root.val);
        }
        if(root.val>=max || root.val<=min){
            return false;
        }
        
        return validHelper(root.left,min,root.val) && 
        validHelper(root.right,root.val,max);
    }
}
