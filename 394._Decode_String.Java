public class Solution {
    public String decodeString(String s) {
        s="1["+s+"]";
        return decodeHelper(s.toCharArray(),0).res;
    }
    private myStringPair decodeHelper(char [] s,int l){
        StringBuilder strb=new StringBuilder();
        int rep=0;
        int i=0;
        for(i=l; i<s.length && s[i]!=']';i++){
            if(Character.isLetter(s[i])){
                strb.append(s[i]);
            }
            else if(Character.isDigit(s[i])){
                if(rep<0)rep=0;
                rep*=10;
                rep+=(s[i]-'0');
            }else if(s[i]=='['){
               myStringPair pair= decodeHelper(s,i+1);
               i=pair.lastIndex;
               while(rep-->0){
                   strb.append(pair.res);
               }
            }
        }
        return new myStringPair(i,strb.toString());
        
    }
    private class myStringPair{
        public int lastIndex;
        public String res;
        public myStringPair(int i,String s){
            lastIndex=i;res=s;
        }
    }
}
