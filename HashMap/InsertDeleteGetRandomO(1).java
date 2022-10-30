//Leetcode 380. Insert Delete GetRandom O(1)
class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)) //if map does not have the val 
        {
            list.add(val); //adding val in list at end
            map.put(val,list.size()-1); //putting key(val) and its index(size of list -1);
            return true; //val is added
        }
        return false; //val not added as it is already present
    }
    
    public boolean remove(int val) 
    {
        if(map.containsKey(val)) //if value is present then we can remove
        {
            int index=map.get(val); //getting index of val using map
            list.set(index,list.get(list.size()-1)); //setting list[index](val)=list[last] , to remove val
            map.put(list.get(list.size()-1),index); //updating index of map by last value of list(updating key of index)
            map.remove(val); //remove val from map;
            list.remove(list.size()-1); //remove last element in list as it is copied to index(where the val is present)
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random random=new Random(); //random class
        int rad=random.nextInt(list.size()); //rad int value
        return list.get(rad); //returning value using list.get(rad)
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
