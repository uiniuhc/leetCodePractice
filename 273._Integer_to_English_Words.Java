public class Solution {
    static final String[] NUMS9={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve"
        ,"Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static final String[] NUMS10={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if(num==0)return "Zero";
        return aboveMillion(num);
    }
    private String aboveMillion(int num){
        int above=num/1000000;
        int under=num%1000000;
        String res="";
        if(above==0) {
            res=underMillion(under);
        }else if(above>=1000){
            res= underThousand(above/1000)+" Billion "+underThousand(above%1000);
            if(above%1000>0)res+=" Million ";
            res+=underMillion(under);
        }else{
            res= underThousand(above)+" Million "+underMillion(under);
        }
        return res.trim();
        
    }
    //string from 0-999,999
    private String underMillion(int num){
        int above=num/1000;
        int under=num%1000;
        String res="";
        if(above>0) res= underThousand(above)+" Thousand "+underThousand(under);
        else res=underThousand(under);
        return res.trim();
    }
    //0-999
    private String underThousand(int num){
        int above=num/100;
        int under=num%100;
        String res="";
        if(above>0) res=NUMS9[above]+" Hundred "+underOneHundred(under);
        else res=underOneHundred(under);
        return res.trim();
    }
    //0-99
    private String underOneHundred(int num){
        String res="";
        if(num==0)return res;
        if(num<=19)return NUMS9[num];
        if(num%10==0)return NUMS10[num/10];
        return NUMS10[num/10]+" "+NUMS9[num%10];
    }
}
