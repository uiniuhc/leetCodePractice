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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res=new LinkedList<List<Integer>>();
        if(root==null)return res;
        
        LinkedList<TreeNode> lastList=new LinkedList<TreeNode>();
        LinkedList<Integer> first=new LinkedList<Integer>();
        first.add(root.val);
        lastList.add(root);
        res.addFirst(first);
        while(true){
            LinkedList<TreeNode> currList=new LinkedList<TreeNode>();
            LinkedList<Integer> valList=new LinkedList<Integer>();
            for(TreeNode tn:lastList){
                if(tn.left!=null){
                    currList.add(tn.left);
                    valList.add(tn.left.val);
                }
                if(tn.right!=null){
                    currList.add(tn.right);
                    valList.add(tn.right.val);
                }
            }
            lastList=currList;
            if(lastList.size()==0)break;
            res.addFirst(valList);
        }
        return res;
    }
}
