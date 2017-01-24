public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] pre=preorder.split(",");
        if(getRest(pre,0)==pre.length){
            return true;
        }else{
            return false;
        }
    }
    //search for a whole tree, where curr is the root, return the last index of unused char
    private int getRest(String[] str, int curr){
        if(curr>=str.length){
            return -1;
        }
        if(str[curr].equals("#"))return curr+1;
        //find left tree
        int l=getRest(str,curr+1);
        if(l<0)return l;
        return getRest(str,l);
    }
}
