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
    public List<Integer> rightSideView(TreeNode root) {
        TreeNode p=root;
        ArrayList<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        Stack<Integer> layers=new Stack<Integer>();
        boolean flag=true;
        int layer=0;
        int index=0;
        if(root==null){
            return res;
        }
        while(flag){
            
            if(layer==index){
                res.add(p.val);
                index++;
            }
            layer++;
            if(p.left!=null){
                stack.push(p.left);
                layers.push(layer);
            }
            if(p.right!=null){
                stack.push(p.right);
                layers.push(layer);
            }
            if(!stack.empty()){
                p=stack.pop();
                layer=layers.pop();
            }else{
                flag=false;
            }
            
        }
        return res;
    }
}
