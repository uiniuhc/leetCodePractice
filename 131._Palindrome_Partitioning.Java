public class Solution {
    private boolean isPalindrome(String w){
        if(w.length()<2){
            return true;
        }
        int i=0;
        int j=w.length()-1;
        while(i<j){
            if(w.charAt(i)!=w.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    ArrayList<List<String>> res;
    public List<List<String>> partition(String s) {
        //construct a list of all different elements
        res=new ArrayList<List<String>>();
        ArrayList<String> l=new ArrayList<String>();
        partitionHelper(s,0,l);
        return res;
    }
    public void partitionHelper(String s,int start,ArrayList<String > l){
        //cut at start +i
        if(start==s.length()){
            res.add(l);
        }
        for(int i=1;i<s.length()-start+1;i++){
            String str=s.substring(start, start+i);
            if(isPalindrome(str)){
                //keep going with this
                ArrayList<String> tl=new ArrayList<String>(l);
                tl.add(str);
                partitionHelper(s,start+i,tl);
            }
        }
    }
}
