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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null)return res;
        HashMap<TreeNode,Integer> layer=new HashMap<TreeNode,Integer>();
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        int now=0;
        layer.put(root,0);
        que.add(root);
        ArrayList<Integer> curr=new ArrayList<Integer>();
        curr.add(root.val);
        while(!que.isEmpty()){
            TreeNode p=que.poll();
            int l=layer.get(p)+1;
            if(l!=now){
                res.add(curr);
                curr=new ArrayList<Integer>();
                now=l;
            }
            if(p.left!=null){
                curr.add(p.left.val);
                layer.put(p.left,l);
                que.add(p.left);
            }
            if(p.right!=null){
                curr.add(p.right.val);
                layer.put(p.right,l);
                que.add(p.right);
            }
        }
        return res;
        
    }
}
