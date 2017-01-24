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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums,0,nums.length-1);
    }
    private TreeNode buildBST(int[] nums, int from,int to){
        if(from==to) return new TreeNode(nums[from]);
        if(from>to) return null;
        
        int mid=(from+to)/2;
        TreeNode res=new TreeNode(nums[mid]);
        //construct left tree and right tree
        res.left=buildBST(nums,from,mid-1);
        res.right=buildBST(nums,mid+1,to);
        return res;
    }
}
