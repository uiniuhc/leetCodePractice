import java.math.BigInteger;
public class Solution {
    
    public boolean isAdditiveNumber(String num) {
        
        //n^3 algorithm
        //bruteforce!
        int n=num.length();
        if(n<3)return false;
        for(int i=1;i<=n/2;i++){
            for(int j=1;j+i+i<=n && j+j+i<=n;j++){
                if((i>1 && num.charAt(0)=='0') || (j>1 && num.charAt(i)=='0'))continue;
                BigInteger left=new BigInteger(num.substring(0,i));
                BigInteger right=new BigInteger(num.substring(i,i+j));
                BigInteger sum=left.add(right);
                String ssum=sum.toString();
                if(i+j+ssum.length()>num.length())continue;
                if(ssum.equals(num.substring(i+j,i+j+ssum.length()))){
                    //keep checking
                    int len=i+j+ssum.length();
                    boolean flag=true;
                    while(len<num.length() &&flag){
                        left=right;right=sum;sum=left.add(right);
                        ssum=sum.toString();
                        if(len+ssum.length()>num.length() || !ssum.equals(num.substring(len,len+ssum.length()))){
                            flag=false;
                        }
                        len=len+ssum.length();
                    }
                    if(flag){
                        //success
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
