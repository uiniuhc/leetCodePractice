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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res=new ArrayList<Interval>();
        if(intervals.size()==0)return res;
        Collections.sort(intervals,new Comparator<Interval>(){public int compare(Interval a,Interval b){return a.start-b.start
            ;}});
        Interval curr=intervals.get(0);
        res.add(curr);
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start<=curr.end){
                if(intervals.get(i).end>curr.end){
                    curr.end=intervals.get(i).end;
                }
            }else{
                curr=intervals.get(i);
                res.add(curr);
            }
        }
        return res;
    }
}
