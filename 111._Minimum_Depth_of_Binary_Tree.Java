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
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        Queue<MyDataType> que=new LinkedList<MyDataType>();
        que.add(new MyDataType(1,root));
        while(que.size()>0){
            int height=que.peek().height;
            TreeNode n=que.poll().treeNode;
            if(n.left==null && n.right==null){
                return height;
            }
            if(n.left!=null){
                que.add(new MyDataType(height+1,n.left));
            }
            if(n.right!=null){
                que.add(new MyDataType(height+1,n.right));
            }
        }
        return 0;
    }
    private class MyDataType{
        public int height;
        public TreeNode treeNode;
        public MyDataType(int h, TreeNode n){
            height=h;treeNode=n;
        }
    }
}
