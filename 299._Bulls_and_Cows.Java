public class Solution {
    public String getHint(String secret, String guess) {
        if(secret.length()!=guess.length())return "";
        int a=0;
        int b=0;
        int[] stata=new int[10];//0-9
        int[] statb=new int[10];
        //first check a, and get statistics of secret
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                a++;
            }else{
                stata[secret.charAt(i)-'0']++;
                statb[guess.charAt(i)-'0']++;
            }
        }
        for(int i=0;i<10;i++){
            b+= stata[i]<statb[i]?stata[i]:statb[i];
        }
        return a+"A"+b+"B";
    }
}
