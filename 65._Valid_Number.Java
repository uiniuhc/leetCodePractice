import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private boolean isDec(String s){
         if(s.length()==0||s.equals(".")){
            return false;
        }
        Pattern p=Pattern.compile("[^0-9]+");
        Matcher m=p.matcher(s);
        boolean mpre=m.matches();
        if(mpre){
            return false;
        }
        String pattern="^[+-]?[0-9,]*[.]?[0-9]*";
        p=Pattern.compile(pattern);
        m=p.matcher(s);
        boolean m1=m.matches();
        return m1;
    }
    public boolean isNumber(String s) {
        s=s.trim();
        String line=s;
        int count = line.length() - line.replace("e", "").length();
        if(count>1){
            return false;
        }
        if(s.indexOf('e')>=0 ){
           String[] ss=s.split("e");
           if(ss.length!=2){
               return false;
           }
           return isDec(ss[0]) && ss[1].matches("^[-+]?[0-9]+");
        }

        return isDec(s);
    }
}
