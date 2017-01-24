public class Solution {
    
    public boolean canCross(int[] stones) {
        final int MIN=0;
        final int MAX=1;
        if(stones.length<2)return true;
        if(stones[1]-stones[0]!=1)return false;
        HashMap<Integer,Integer> stoneIndex=new HashMap<Integer,Integer>();
        List<Set<Integer>> lastStep=new ArrayList<Set<Integer>>(stones.length+1);
        lastStep.add(new HashSet<Integer>());
        for(int i=1;i<stones.length;i++){
            lastStep.add(new HashSet<Integer>());
            stoneIndex.put(stones[i],i);
        }
        lastStep.get(1).add(1);//first stone
        for(int i=1;i<stones.length-1;i++){
            for(int s:lastStep.get(i)){
                //s-1 s s+1
                for(int k=s-1;k<=s+1;k++){
                    if(k==0)continue;
                    if(stoneIndex.containsKey(k+stones[i])){
                        //can reach it
                        int stone=stoneIndex.get(k+stones[i]);
                        lastStep.get(stone).add(k);
                    }
                }
            }
            
        }
        if(lastStep.get(lastStep.size()-1).size()>0)return true;
        return false;
    }
}
