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
    private class MyNode{
        public TreeNode node;
        public boolean isChild;
        public MyNode(TreeNode n,boolean ch){
            node=n;isChild=ch;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<Integer>();
        if(root==null)return res;
        Stack<MyNode> stack=new Stack<MyNode>();
        stack.push(new MyNode(root,true));
        //push all
        while(!stack.isEmpty()){
            //get first
            MyNode n=stack.pop();
            if(!n.isChild && n.node!=null){
                res.add(n.node.val);
            }
            else if(n.isChild && n.node!=null){
                stack.push(new MyNode(n.node.right,true));
                stack.push(new MyNode(n.node,false));
                stack.push(new MyNode(n.node.left,true));
            }
        }
        return res;
    }
    
}
