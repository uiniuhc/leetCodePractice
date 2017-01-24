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
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        //first check the max depth
        TreeNode p=root;
        int d=0;
        while(p!=null){
            d++;p=p.left;
        }
        //now the range is in 2^(d-1)to 2^d-1
        int l=1<<(d-1);
        int r=(1<<d)-1;
        int mid;
        int max=l;
        while(l<=r){
            mid=(l+r)/2;
            if(check(root,mid,d)){
                l=mid+1;
                max=mid;
            }else{
                r=mid-1;
            }
        }
        return max;
    }
    private boolean check(TreeNode root,int mid,int d){
        TreeNode p=root;
        d-=2;
        while(d>=0){
            if((mid & (1<<d))>0){
                p=p.right;
            }else{
                p=p.left;
            }
            if(p==null){return false;}
            d--;
        }
        return true;
        
    }
}
