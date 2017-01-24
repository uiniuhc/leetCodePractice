public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses==0)return new int[0];
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        Queue<Integer> candi=new LinkedList<Integer>();
        int[] res=new int[numCourses];
        //get information
        for(int i=0;i<prerequisites.length;i++){
            if(hash.containsKey(prerequisites[i][0])){
                hash.put(prerequisites[i][0],hash.get(prerequisites[i][0])+1);
            }else{
                hash.put(prerequisites[i][0],1);
            }
        }
        for(int i=0;i<numCourses;i++){
            if(!hash.containsKey(i)){
                candi.add(i);
            }
        }
        int index=0;
        while(index<numCourses){
            if(candi.isEmpty()){
                //no more to find!!
                return new int[0];
            }
            int curr=0;
            //put all zero into res
            while(!candi.isEmpty()){
                curr=candi.poll();
                res[index]=curr;
                index++;
                for(int[] a:prerequisites){
                if(a[1]==curr){
                    int now=hash.get(a[0]);
                    if(now==1){
                        hash.remove(a[0]);
                        candi.add(a[0]);
                    }
                    else{
                        hash.put(a[0],now-1);
                    }
                }
                }
            }
            //set all to zero
            
            
        }
        return res;
    }
}
