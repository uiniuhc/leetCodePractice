public class LRUCache {
       Map<Integer,Integer> values;
    Map<Integer,Long> usages;//relating key to timestamp
    TreeSet<TimeNode> history;//use timestamp as a search tree
    long time;//timestamp
    int count;//now elements
    int cap;
    public LRUCache(int capacity) {
        time=0;count=0;
        cap=capacity;
        values=new HashMap<Integer,Integer>();
        usages=new HashMap<Integer,Long>();
        history=new TreeSet<TimeNode>(new Comparator<TimeNode>(){
            public int compare(TimeNode a,TimeNode b){
                if(a.timeStamp-b.timeStamp>0)return 1;
                else if(a.timeStamp-b.timeStamp<0)return -1;
                return 0;
            }
        });
    }
    
    public int get(int key) {
        time++;
        if(values.containsKey(key)){
            //update timestamp
            history.remove(new TimeNode(key,usages.get(key)));
            history.add(new TimeNode(key,time));
            usages.put(key, time);
            return values.get(key);
        }
        return -1;
    }
    public void print(){
        System.out.println("current time is: "+time+". and current data is: ");
        for(Map.Entry<Integer, Integer> curr:values.entrySet()){
            System.out.println(curr.getKey()+": "+curr.getValue());
        }
    }
    //O(log(N))
    public void set(int key, int value) {
        time++;
        if(usages.containsKey(key)){
            //old one! set new timestamp!
            history.remove(new TimeNode(key,usages.get(key)));
            history.add(new TimeNode(key,time));
            usages.put(key,time);
            values.put(key,value);
            return;
        }
            //new one
            //no need of creating new
        if(count<cap){
            values.put(key,value);
            usages.put(key,time);
            history.add(new TimeNode(key,time));
            count++;
        }
        //need create new
        else{
            //delete oldest one
            TimeNode oldest=history.pollFirst();
            values.remove(oldest.key);
            usages.remove(oldest.key);
            //add the new one
            values.put(key,value);
            usages.put(key,time);
            history.add(new TimeNode(key,time));
        }
    }
    private class TimeNode {
        public int key;
        public long timeStamp;
        public TimeNode(int k,long t){
            key=k;timeStamp=t;
        }
    }
}
