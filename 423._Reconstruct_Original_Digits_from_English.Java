public class Solution {
    public String originalDigits(String s) {
        int[] res=new int[10];//results
        int[] stat=new int[256];
        for(int i=0;i<s.length();i++){
            stat[s.charAt(i)]++;
        }
        res[0]=stat['z'];
        res[2]=stat['w'];
        res[4]=stat['u'];
        res[6]=stat['x'];
        res[8]=stat['g'];
        res[3]=stat['t'];
        res[1]=stat['o'];
        res[5]=stat['f'];
        res[7]=stat['s'];
        res[9]=stat['i'];
        
        res[3]=res[3]-res[2]-res[8];
        res[1]=res[1]-res[2]-res[4]-res[0];
        res[5]-=res[4];
        res[7]-=res[6];
        res[9]=res[9]-res[5]-res[6]-res[8];
        StringBuilder strb=new StringBuilder();
        for(int i=0;i<10;i++){
            while(res[i]-->0){
                strb.append((char)('0'+i));
            }
        }
        return strb.toString();
        //z for 0
        //w for 2
        //u for 4
        //x for 6
        //g for 8
        //t for 3//share with 8 and 2
        //o for 1//share with 2 4 0
        //f for 5//share with 4
        //s for 7//share with 6
        //i for 9//share with 5 6 and 8
        
        
    }
}
