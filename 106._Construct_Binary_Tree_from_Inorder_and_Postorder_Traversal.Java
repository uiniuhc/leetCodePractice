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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildHelper(inorder, postorder, 0, inorder.length-1,0,postorder.length-1);
    }
    public TreeNode buildHelper(int[] inorder, int[] postorder, int inl, int inr, int postl, int postr){
        if(inl>inr || postl>postr)return null;
        if(inl==inr){
            return new TreeNode(inorder[inl]);
        }
        int val=postorder[postr];
        TreeNode root=new TreeNode(val);
        int left_len=0;
        int right_len=0;
        //find val in the inorder sequence
        for(int i=inl;i<=inr;i++){
            if(inorder[i]==val){
                left_len=i-inl;
                right_len=inr-i;
                break;
            }
        }
        //recursion!
        if(left_len>0){
            root.left=buildHelper(inorder, postorder, inl, inl+left_len-1, postl, postl+left_len-1);
        }
        if(right_len>0){
            root.right=buildHelper( inorder, postorder, inr-right_len+1,inr,postr-right_len,postr-1);
        }
        
        return root;
    }
}
