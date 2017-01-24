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
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<String>();
        if(root==null)return res;
        btpHelper(root, ""+root.val,res);
        return res;
    }
    private void btpHelper(TreeNode root, String path,List<String> res){
        if(root==null)return;
        if(root.left==null &&root.right==null)res.add(path);
        if(root.left!=null){
            btpHelper(root.left, path+"->"+root.left.val,res);
        }
        if(root.right!=null){
            btpHelper(root.right, path+"->"+root.right.val,res);
        }
    }
}
