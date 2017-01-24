public class Solution {
    final int BIG_PRIME=2147483647;
    final int STRING_LEN=10;
    final int USE_PRIME=37;
public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new ArrayList<String>();
        if(s.length()<=STRING_LEN)return res;
        HashMap<Integer,LinkedList<int[]>> map=new HashMap<Integer,LinkedList<int[]> >();
        //init and first ten
        long ll=1;
        int largest=0;
        int hash=updateHash(0,s.charAt(0),' ',0);
        for(int i=1;i<STRING_LEN;i++){
            ll*=USE_PRIME;
            ll%=BIG_PRIME;
            hash=updateHash(hash,s.charAt(i),' ',0);
        }
        largest=(int)ll;
        //put first hash
        int[] first=new int[2];
        first[0]=0;first[1]=1;
        LinkedList<int[]> temp=new LinkedList<int[]>();
        temp.add(first);
        map.put(hash,temp);
        for(int i=STRING_LEN;i<s.length();i++){
            //System.out.println("hash "+ i+": "+hash);
            hash=updateHash(hash,s.charAt(i),s.charAt(i-STRING_LEN),largest);
            int[] t=new int[2];
            t[0]=i-STRING_LEN+1;t[1]=1;
            if(map.containsKey(hash)){
                LinkedList<int[]> l=map.get(hash);
                boolean hasSame=false;
                //check
                for(int[] arr:l){
                    if(isSame(s,arr[0],t[0],STRING_LEN)){
                        hasSame=true;
                        if(arr[1]==1){
                            res.add(s.substring(arr[0],arr[0]+STRING_LEN));
                        }
                        arr[1]++;
                    }
                }
                if(!hasSame) l.add(t);
            }else{
                LinkedList<int[]> l=new LinkedList<int[]>();
                l.add(t);
                map.put(hash,l);
            }
            
        }
        return res;
    }
    private int updateHash(int hash,char ch,char dif,int base){
        long l=hash;
        if(dif!=' '){
            l=l-(long)(base)*(dif-'A');
            l=(l%BIG_PRIME+BIG_PRIME)%BIG_PRIME;
        }
        l*=USE_PRIME;
        l%=BIG_PRIME;
        l+=(ch-'A');
        l%=BIG_PRIME;
        return (int)l;
    }
    private boolean isSame(String s,int i1,int i2,int len){
        for(int i=0;i<len;i++){
            if(s.charAt(i1)!=s.charAt(i2))return false;
            i1++;i2++;
        }
        return true;
    }
    
}
