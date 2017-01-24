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
    HashMap<TreeNode,Integer> maxVal;
    public int rob(TreeNode root) {
        maxVal=new HashMap<TreeNode,Integer>();
        return robHelper(root,maxVal);
    }
    private int robHelper(TreeNode root, HashMap<TreeNode,Integer> maxVal){
        if(maxVal.containsKey(root))return maxVal.get(root);
        if(root==null)return 0;
        int without=robHelper(root.left,maxVal)+robHelper(root.right,maxVal);
        int with=root.val;
        if(root.left!=null){
            with+=robHelper(root.left.left,maxVal)+robHelper(root.left.right,maxVal);
        }
        if(root.right!=null){
            with+=robHelper(root.right.left,maxVal)+robHelper(root.right.right,maxVal);
        }
        if(with>without){
            maxVal.put(root,with);
        }else{
            maxVal.put(root,without);
        }
        return maxVal.get(root);
    }
}
