public class Solution {
    private class EdgeValue{
        int start;
        int end;
        double val;
        public EdgeValue(int s,int e, double v){
            start=s;end=e;val=v;
        }
    }
    private double query(int a, int b, List<List<EdgeValue>> edges){
        //find path with bfs
        HashSet<Integer> used=new HashSet<Integer>();
        HashMap<Integer,EdgeValue> pre=new HashMap<Integer,EdgeValue>();
        Queue<Integer> que=new LinkedList<Integer>();
        que.add(a);used.add(a);
        //find path
        while(!que.isEmpty()){
            int curr=que.poll();
            List<EdgeValue> l=edges.get(curr);
            for(EdgeValue e:l){
                if(used.contains(e.end))continue;
                used.add(e.end); pre.put(e.end,e);
                que.add(e.end);
                if(e.end==b){
                    //find path
                    int c=e.end;
                    double res=1;
                    while(c!=a){
                        int next=pre.get(c).start;
                        res*=pre.get(c).val;
                        c=next;
                    }
                    return res;
                }
            }
        }
        //didn't find it
        return -1;
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String,Integer> smap=new HashMap<String, Integer>();
        List<List<EdgeValue>> edges=new ArrayList<List<EdgeValue>>();
        int curr=0;
        //init with equations
        for(int i=0;i<equations.length;i++){
            //hashmap, get int
            int[] e=new int[2];
            for(int j=0;j<2;j++){
                if(smap.containsKey(equations[i][j])){
                    e[j]=smap.get(equations[i][j]);
                }else{
                    e[j]=curr++;
                    smap.put(equations[i][j],e[j]);
                    edges.add(new ArrayList<EdgeValue>());
                }
            }
            //use int to set edges
            List<EdgeValue> l=edges.get(e[0]);
            l.add(new EdgeValue(e[0],e[1],values[i]));
            if(values[i]!=0){
                l=edges.get(e[1]);
                l.add(new EdgeValue(e[1],e[0],1/values[i]));
            }
        }
        //start query
        double[] res=new double[queries.length];
        for(int i=0;i<queries.length;i++){
            int [] a=new int[2];
            for(int j=0;j<2;j++){
                if(smap.containsKey(queries[i][j])){
                    a[j]=smap.get(queries[i][j]);
                }else{
                    a[j]=-1;
                }
            }
            if(a[0]==-1 || a[1]==-1)res[i]=-1;
            else if(a[0]==a[1])res[i]=1;
            else{
                res[i]=query(a[0],a[1],edges);
            }
        }
        return res;
    }
}
