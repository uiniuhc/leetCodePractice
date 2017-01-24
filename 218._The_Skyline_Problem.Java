public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        
        List<int[]> res=new ArrayList<int[]>();
         if(buildings.length==0)return res;
        Arrays.sort(buildings,new Comparator<int[]>(){public int compare(int[] a,int []b)
        {if(a[0]!=b[0])return a[0]-b[0];else return b[2]-a[2];}});
        buildings=Arrays.copyOf(buildings,buildings.length+1);
        int[] last=new int[3];
        last[0]=-1;
        buildings[buildings.length-1]=last;
        PriorityQueue<int[]> heights=new PriorityQueue<int[]>(buildings.length,
        new Comparator<int[]>(){
            public int compare(int [] a, int [] b){
                return b[2]-a[2];
            }
        });
        int currX=0;
        int[] coord=new int[2];
        boolean first=true;
        for(int[] build:buildings){
            currX=build[0];
            //normal situation
            //check last ones, is it finished?
            int lastX=0;
            while(!heights.isEmpty() && (heights.peek()[1]<currX || currX==-1)){
                int[] line=heights.poll();
                lastX=line[1];
                int baseHeight=0;
                while(!heights.isEmpty() ){
                    if(lastX>heights.peek()[1]){heights.poll();continue;}
                    baseHeight=heights.peek()[2];
                    break;
                }
                coord[0]=line[1];coord[1]=baseHeight;
                if(res.size()>0 && coord[0]==res.get(res.size()-1)[0]){
                    //need merge
                    if(coord[1]<res.get(res.size()-1)[1]) res.get(res.size()-1)[1]=coord[1];
                }
                else if(res.size()==0 || (coord[1]!=res.get(res.size()-1)[1])){
                    res.add(Arrays.copyOf(coord,2));
                }
                //closing merge with min
            }
            //add current node
            if(build[0]==-1)break;
            if(heights.isEmpty() ||(build[2]>heights.peek()[2])){
                coord[0]=build[0];coord[1]=build[2];
                
                if(res.size()==0 || (coord[1]!=res.get(res.size()-1)[1])){
                    res.add(Arrays.copyOf(coord,2));
                }
               
            }
            heights.add(build);
        }
        return res;
    }
}
