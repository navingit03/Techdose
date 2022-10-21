//Leetcode 146. LRU Cache
class LRUCache {
    HashMap<Integer,Integer> map=new HashMap<>();
    Queue<Integer> q=new LinkedList<>(); //creating an Deque
    int max_size=0;
    public LRUCache(int capacity) {
        max_size=capacity; //size 
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1; //if key value not exists;
        q.remove(key); //removing key from queue
        q.add(key); //adding key at back in the queue
        return map.get(key); //getting the value from the map
    }
    
    public void put(int key, int value)
    {
        if(!map.containsKey(key)&&max_size==map.size())
        map.remove(q.remove()); //removing the first queue key
      
        if(map.containsKey(key))
        q.remove(key);
      
        map.put(key, value); //adding in map key value
        q.add(key); //adding back of the queue
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
