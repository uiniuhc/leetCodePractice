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
    public int kthSmallest(TreeNode root, int k) {
        int[] count=new int[2];
        if(root==null)return 0;
        kthInorder(root,k, count);
        return count[1];
    }
    private void kthInorder(TreeNode root,int k, int[] count){
        if(count[0]>k)return;
        if(root.left!=null) kthInorder(root.left,k,count);
        count[0]++;
        if(count[0]==k){count[1]=root.val;return;}
        if(root.right!=null) kthInorder(root.right,k,count);
    }
}
