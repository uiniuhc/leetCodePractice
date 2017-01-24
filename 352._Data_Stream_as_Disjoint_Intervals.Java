/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    private ArrayList<Integer> startList;
    private ArrayList<Integer> endList;
    private Map<Integer,Boolean> instance;
    
    public SummaryRanges() {
        startList=new ArrayList<Integer>();
        endList=new ArrayList<Integer>();
    }
    private boolean isInside(int val){
        for(int i=0;i<startList.size();i++){
            if(val>=startList.get(i)&&val<=endList.get(i)){
                return true;
            }
        }
        return false;
    }
    private void addInterval(Interval r){

        if(startList.size()==0 || r.start>startList.get(startList.size()-1)){
            startList.add(r.start);
            endList.add(r.end);
            return;
        }
        for(int i=0;i<startList.size();i++){
            if(r.start<startList.get(i)){
                startList.add(i,r.start);
                endList.add(i,r.end);
                return;
            }
        }
    }
    public void addNum(int val) {
        boolean flag=false;
        Interval r=new Interval(val,val);
        if(isInside(val)){
            return;
        }
        int i=Collections.binarySearch(endList,val-1);
        if(i>=0){
            r.start=startList.get(i);
            startList.remove(i);
            endList.remove(i);
            flag=true;
        }
        i=Collections.binarySearch(startList,val+1);
        if(i>=0){
            r.end=endList.get(i);
            startList.remove(i);
            endList.remove(i);
            flag=true;
        }
        if(flag){
            addInterval(r);
        }
        //check is a new node
        else{
            addInterval(new Interval(val,val));
        }
    }
    
    public List<Interval> getIntervals() {
        ArrayList<Interval> res=new ArrayList<Interval>();
        for(int i=0;i<startList.size();i++){
            res.add(new Interval(startList.get(i),endList.get(i)));
        }
        //res.sort(new  Comparator<Interval>(){public int compare(Interval a,Interval b){return b.end-a.end;}});
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
