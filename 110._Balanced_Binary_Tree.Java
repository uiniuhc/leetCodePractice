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
    public boolean isBalanced(TreeNode root) {
        
        return helper(root,new int[1]);
    }
    private boolean helper(TreeNode root,int[] heights){
        if(root==null){heights[0]=0;  return true;}
        int[] leftHeight=new int[1];
        int[] rightHeight=new int[1];
        if(!helper(root.left,leftHeight)){
            return false;
        }
        if(!helper(root.right,rightHeight)){
            return false;
        }
        heights[0]=leftHeight[0]>rightHeight[0]?leftHeight[0]+1:rightHeight[0]+1;
        int dif=leftHeight[0]-rightHeight[0];
        if(dif>=2 ||dif<=-2){
            return false;
        }
        return true;
    }
}
