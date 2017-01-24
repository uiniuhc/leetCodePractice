public class Solution {
    public String addBinary(String a, String b) {
        if(a.length()==0)return b;
        if(b.length()==0)return a;
        if(a.length()>b.length()){String t=a;a=b;b=t;}
        int c=0;
        String res="";
        int ax=a.length()-1;
        int bx=b.length()-1;
        while(ax>=0 && bx>=0){
            int r=a.charAt(ax)-'0'+b.charAt(bx)-'0'+c;
            if(r>=2){
                c=1;
            }else{
                c=0;
            }
            if(r%2==1){
                res="1"+res;
            }else{
                res="0"+res;
            }
            ax--;bx--;
        }
        //a is used up b still have
        while(bx>=0){
            int r=b.charAt(bx)-'0'+c;
            if(r>=2){
                c=1;
            }else{
                c=0;
            }
            if(r%2==1){
                res="1"+res;
            }else{
                res="0"+res;
            }
            bx--;
        }
        if(c==1){
            res="1"+res;
        }
        return res;
    }
}
