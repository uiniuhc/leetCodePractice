/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
public class Solution {
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //now intervals are all disjoint.
        List<Interval> res=new ArrayList<Interval> ();
        int start=newInterval.start;
        int end=newInterval.end;
        res.add(newInterval);
        for(Interval curr:intervals){
            if(curr.end<newInterval.start || curr.start>newInterval.end){
                //not overlap, add into res
                res.add(curr);
            }else{
                //overlap, get the final interval
                if(curr.end>end){
                    end=curr.end;
                }
                if(curr.start<start){
                    start=curr.start;
                }
            }
        }
        //make changes of start & end into res's first element
        res.set(0,new Interval(start,end));
        //shift it into the right place
        int i=1;
        while(i<res.size() && start>res.get(i).start){
            //swap them(i-1 and i)
            Interval t=res.get(i-1);
            res.set(i-1,res.get(i));
            res.set(i,t);
            i++;
        }
        return res;
    }
}
