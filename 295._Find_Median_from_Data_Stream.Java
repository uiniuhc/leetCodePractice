public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    MedianFinder(){
        minHeap=new PriorityQueue<Integer>(2);
        maxHeap=new PriorityQueue<Integer>(2,new Comparator<Integer>(){public int compare(Integer a, Integer b){return b-a;}}
            );
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(minHeap.size()==0 && maxHeap.size()==0){
            minHeap.add(num);
            return;
        }
        if(num>minHeap.peek()){
            //goto min heap
            minHeap.add(num);
            while(minHeap.size()>maxHeap.size()+1){
                maxHeap.add(minHeap.poll());
            }
    
        }else{
            //goto maxheap
            maxHeap.add(num);
            while(maxHeap.size()>minHeap.size()){
                minHeap.add(maxHeap.poll());
            }
        }
        
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }else{
            return minHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
