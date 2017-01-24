public class Solution {
    String base="IVXLCDM";
    public int romanToInt(String s) {
        if(s.length()==0)return 0;
        int res=0;
        int[] values={1,5,10,50,100,500,1000,0};
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        map.put('I',0);map.put('V',1);map.put('X',2);map.put('L',3);map.put('C',4);map.put('D',5);map.put('M',6);
        map.put(' ',7);
        char last=' ';
        int count=0;
        boolean valuedLast=false;
        for(char ch:s.toCharArray()){
            valuedLast=false;
            if(last==' '){last=ch;count=1;continue;}
            if(last==ch){count++;if(count>3)return -1;}
            else if(map.get(last)<map.get(ch) && count==1){
                res+=values[map.get(ch)]-values[map.get(last)];
                last=' ';
                valuedLast=true;
            }
            else if(map.get(ch)<map.get(last)){
                res+=values[map.get(last)]*count;
                last=ch;count=1;
            }else{
                return -1;
            }
        }
        if(!valuedLast)res+=values[map.get(last)]*count;
        return res;
        
        
    }
}
