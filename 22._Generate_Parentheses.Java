public class Solution {
    ArrayList<String> res;
    public List<String> generateParenthesis(int n) {
        if(n==0)return null;
        res=new ArrayList<String>();
        ParenthesisHelper("",n,n);
        return res;
    }
    private void ParenthesisHelper(String str,int l,int r){
        if(l==0 && r==0){
            res.add(str);
        }
        if(l==r || l>0) {
            ParenthesisHelper(str+'(',l-1,r);
        }
        if(l<r && r>0){
            ParenthesisHelper(str+')',l,r-1);
        }
    }
}
