public class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len=s.length();
        List<String> res=new ArrayList<String>();
        if(len==0||len>12)return res;
        helper(s,"",4,res);
        return res;
    }
    private void helper(String sub,String parents, int left,List<String> res){
        if(left==0){
            res.add(parents); return;
        }
        for(int i=1;i<=3 && i<=sub.length();i++){
            String using=sub.substring(0,i);
            if(using.charAt(0)=='0' && using.length()>1)return;
            String next=sub.substring(i);
            if(smallerString(using,256) && next.length()<=3*(left-1) && next.length()>=left-1){
                if(parents.length()==0) helper(next,using,left-1,res);
                else helper(next,parents+"."+using,left-1,res);
            }
        }
    }
    private boolean smallerString(String str,int val){
        return Integer.parseInt(str)<val;
    }
}
