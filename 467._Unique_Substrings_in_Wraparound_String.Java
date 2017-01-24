public class Solution {
    public int findSubstringInWraproundString(String p) {
        if(p.length()==0) return 0;
        int i=0;
        /*
        while(!Character.isLetter(p.charAt(i))){
            i++;
        }*/
        int[] max=new int[26];
        int curr=1;
        int total=1;
        
        max[p.charAt(0)-'a']=1;
        for(i=1;i<p.length();i++){
            //if(!Character.isLetter(p.charAt(i)))continue;
            if(((p.charAt(i)-1)==p.charAt(i-1)) || 
            (p.charAt(i)=='a' && p.charAt(i-1)=='z')){
                curr++;
            }else{
                curr=1;
            }
            if(curr>max[p.charAt(i)-'a']){
                total+=(curr-max[p.charAt(i)-'a']);
                max[p.charAt(i)-'a']=curr;
            }
        }
        return total;
    }
}
