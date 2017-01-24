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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0)return null;
        return buildHelper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode buildHelper(int[] pre,int[] ino,int pl,int pr,int il,int ir){
        if(pl>pr || il>ir)return null;
        TreeNode root=new TreeNode(pre[pl]);
        if(pl==pr && il==ir)return root;
        //find left
        
        for(int i=il;i<=ir;i++){
            if(root.val==ino[i]){
                //from il to i-1 belongs to left child
                //length is the same in two arrays
                root.left=buildHelper(pre,ino,pl+1,pl+(i-il),il,i-1);
                root.right=buildHelper(pre,ino,pl+1+(i-il),pr,i+1,ir);
            }
        }
        return root;
        
    }
}
