public class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> list=new ArrayList<String>();
        for(int i:nums){
            list.add(""+i);
        }
        Collections.sort(list,new Comparator<String>(){public int compare(String a,String b){
            int lenLong=a.length()>=b.length()?a.length():b.length();
            int lenShort=a.length()<b.length()?a.length():b.length();
            int aIsLonger=a.length()>=b.length()?1:-1;
            String strL=a.length()>=b.length()?a:b;
            String strS=a.length()<b.length()?a:b;
            int i=0, j=0;
            for(;i<lenLong;i++,j++){
                if(j==lenShort)j=0;
                if(strL.charAt(i)==strS.charAt(j))continue;
                return aIsLonger*(strS.charAt(j)-strL.charAt(i));
            }
            if(j==lenShort)return 0;//part of repitation
            else return (strS.charAt(j)-strL.charAt((j+lenShort-1)%lenShort))*aIsLonger;//short before long
        }});
        StringBuilder strb=new StringBuilder();
        boolean first_digit=true;
        for(String str:list){
            if(first_digit ){if( str.equals("0"))continue;else first_digit=false;}
            strb.append(str);
        }
        String res=strb.toString();
        if(res.length()==0)return "0";
        return res;
    }
}
