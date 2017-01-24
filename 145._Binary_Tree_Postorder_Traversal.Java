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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root==null)return res;
        Stack<TreeNode> sequence=new Stack<TreeNode>();
        Stack<Integer> store=new Stack<Integer>();
        //search as m r l, which is the reverse sequence
        TreeNode p=root;
        sequence.push(p);
        while(!sequence.isEmpty()){
            p=sequence.pop();
            store.push(p.val);
            if(p.left!=null)sequence.push(p.left);
            if(p.right!=null)sequence.push(p.right);
            
        }
        //now all values in store
        while(!store.isEmpty()){
            res.add(store.pop());
        }
        return res;
    }
}
