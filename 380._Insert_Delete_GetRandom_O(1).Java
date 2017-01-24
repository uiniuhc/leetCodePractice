public class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> data;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map=new HashMap<Integer,Integer>();
        data=new ArrayList<Integer>();
        random=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        //assert data.size()>=len
        data.add(val);
        map.put(val,data.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int pos=map.get(val);
        map.remove(val);
        if(pos<data.size()-1){
            //change it with len-1
            int lastone=data.get(data.size()-1);
            data.set(pos,lastone);
            map.put(lastone,pos);
        }
        data.remove(data.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
