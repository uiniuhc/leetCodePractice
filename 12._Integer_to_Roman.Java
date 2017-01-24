public class Solution {
    private String[] DigitPattern={"","A","AA","AAA","AB","B","BA","BAA","BAAA","AJ","J"};
    private String[] ShiftRules={"ABJ","IVX","XLC","CDM","MKK"};
    public String intToRoman(int num) {
        String res="";
        //start from lowest digit
        int which=0;
        while(num>0){
            int d=num%10;
            num/=10;which++;
            if(d==0)continue;
            String currD=DigitPattern[d];
            for(int i=0;i<3;i++){
                currD=currD.replace(ShiftRules[0].charAt(i),ShiftRules[which].charAt(i));
            }
            res=currD+res;
        }
        return res;
    }
}
