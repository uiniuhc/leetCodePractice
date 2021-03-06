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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null)return res;
        preorderHelper(root,res);
        return res;
    }
    private void preorderHelper(TreeNode root,List<Integer> res){
        if(root==null)return;
        res.add(root.val);
        preorderHelper(root.left,res);
        preorderHelper(root.right,res);
    }
}
