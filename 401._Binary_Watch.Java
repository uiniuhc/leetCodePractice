public class Solution {
    static HashMap<Integer,ArrayList<Integer>> digitsToNum=null;
    public List<String> readBinaryWatch(int num) {
        //pre processing
        if(digitsToNum==null){
            digitsToNum=new HashMap<Integer,ArrayList<Integer>>();
            for(int i=0;i<=10;i++){
                digitsToNum.put(i,new ArrayList<Integer>());
            }
            for(int i=0;i<=59;i++){
                int bits=countBit(i);
                digitsToNum.get(bits).add(i);
            }
        }
        //start the process
        List<String> res= new ArrayList<String>();
        for(int h=0;h<=num && h<=4;h++){
            int m=num-h;
            for(int hour:digitsToNum.get(h)){
                if(hour>11)continue;
                for(int min:digitsToNum.get(m)){
                    if(min>59) continue;
                    if(min<10) res.add(hour+":0"+min);
                    else res.add(hour+":"+min);
                }
            }
        }
        return res;
    }
    public int countBit(int num){
        int count=0;
        while(num>0){
            num=num&(num-1);
            count++;
        }
        return count;
    }
}
