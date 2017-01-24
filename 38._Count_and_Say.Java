public class Solution {
    public String countAndSay(int n) {
        if(n==1 || n==0){
            return "1";
        }
        return countStr(countAndSay(n-1));
    }
    //pre: str length is larger than 0
    private String countStr(String str){
        int count=1;
        char last=str.charAt(0);
        StringBuilder res=new StringBuilder();
        for(int i=1;i<str.length();i++){
            char curr=str.charAt(i);
            if(curr==last){
                count++;
            }else{
                res.append(count);
                res.append(last);
                count=1;last=curr;
            }
        }
        res.append(count);
        res.append(last);
        return res.toString();
    }
    
}
