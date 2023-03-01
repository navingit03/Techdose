package BuildDS;
import java.util.ArrayList;
import java.util.LinkedList;
//Array of LinkedList
public class HashMapDS {
    static class HashMap<K,V> //generics data type
    {
        private class Node{
            K key;
            V value;
            public Node(K key, V value) //Node constructor
            {
                this.key=key;
                this.value=value;
            }
        }
        private int n; //total nodes
        private int B; //no of buckets
        private LinkedList<Node> buckets[]; //LinkedList array

        @SuppressWarnings("unchecked")
        public HashMap() //hashmap constructor
        {
            this.B=4;
            this.buckets=new LinkedList[4]; //creating linkedList array of size N which has null as default
            for(int i=0;i<4;i++)
            {
                this.buckets[i]=new LinkedList<>(); //initializing the buckets 
            }
        }
        private int hashFunction(K key)
        {
            //hash value should be from 0 to B(max Bucket index)
            return Math.abs(key.hashCode())%B; // hashcode is generated for key whose range[0,B]
        }
        private int searchInLL(K key,int bucketIndex)
        {
            LinkedList<Node> list=buckets[bucketIndex];
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).key==key)
                {
                    return i; //if key node is present at i th index
                }
            }
            return -1; //if key does not exist
        }
        
        @SuppressWarnings("unchecked")
        public void rehash()
        {
            LinkedList<Node> oldbucket[]=buckets; //storing bucket in oldbucket
            buckets=new LinkedList[2*B];
            B=B*2; //increasing bucket size by *2
            n=0; //as we are going to put all n nodes again in new bucket
            for(int i=0;i<B;i++)
            {
                buckets[i]=new LinkedList<>();
            }
            for(int i=0;i<oldbucket.length;i++)
            {
                LinkedList<Node> list=oldbucket[i]; //getting i th LL in oldbucket
                for(int j=0;j<list.size();j++)
                {
                    Node node=list.get(j);
                    put(node.key, node.value);
                }
            }
        }  
        public void put(K key,V value)
        {
            int bucketIndex=hashFunction(key); //to find bucket index using hash of key
            int dataIndex=searchInLL(key,bucketIndex); //to check if key is already present
            if(dataIndex==-1) //key not present
            {
                buckets[bucketIndex].add(new Node(key,value)); //if key does not exist add new node(key,value)
                n++; //as node is increased by 1
            }
            else //key is already present
            {
                Node node=buckets[bucketIndex].get(dataIndex); //getting key node
                node.value=value; //updating the value of key
            }
            double lambda=(double)n/B;
            if(lambda>2.0)
            {
                //rehashing - increasing bucket size
                rehash(); //if lambda>2 (threshold - n/B) total node/bucket size
            }
        }
        public V get(K key)
        {
            int bucketIndex=hashFunction(key); //to find bucket index using hash of key
            int dataIndex=searchInLL(key,bucketIndex); //to check if key is already present
            if(dataIndex==-1) //key not present
            {
                return null;
            }

            Node node=buckets[bucketIndex].get(dataIndex); //getting key node
            return node.value; //return key-value if present
        }
        public boolean containsKey(K key)
        {
            int bucketIndex=hashFunction(key); //to find bucket index using hash of key
            int dataIndex=searchInLL(key,bucketIndex); //to check if key is already present
            if(dataIndex==-1) //key not present
            {
                return false;
            }
            return true; //if present
        }
        public V remove(K key)
        {
            int bucketIndex=hashFunction(key); //to find bucket index using hash of key
            int dataIndex=searchInLL(key,bucketIndex); //to check if key is already present
            if(dataIndex==-1) //key not present
            {
                return null;
            }
            else{
                n--; 
            }
            Node node=buckets[bucketIndex].remove(dataIndex); //remove key node
            return node.value; //return key-value if present after removing
        }
        public ArrayList<K> keySet()
        {
            //getting all the keys of nodes
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0;i<buckets.length;i++)
            {
                LinkedList<Node> list=buckets[i];
                for(int j=0;j<list.size();j++)
                {
                    Node node=buckets[i].get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty()
        {
            return n==0; //if no pair available
        }
    }
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("UK", 50);
        System.out.println(map.keySet());
        System.out.println(map.isEmpty());
        ArrayList<String> keys=map.keySet();
        for(int i=0;i<keys.size();i++)
        {
            String key=keys.get(i);
            System.out.print(key+" "+map.get(key)+" ");
        }
        map.remove("UK");
        System.out.println(map.keySet());
    }
}
