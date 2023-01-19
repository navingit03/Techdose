class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(char ch:map.keySet())
        {
            maxHeap.add(ch);
        }
        StringBuilder res=new StringBuilder();
        while(maxHeap.size()>1)
        {
            char curr=maxHeap.remove();
            char next=maxHeap.remove();
            res.append(curr); //high freq char
            res.append(next); //next high freq char
            map.put(curr,map.get(curr)-1); //decreasing freq of curr
            map.put(next,map.get(next)-1); //decreasing freq of next
            if(map.get(curr)>0) //after decreasing if freq>0 
            {
                maxHeap.add(curr);
            }
            if(map.get(next)>0) //after decreasing if freq>0 
            {
                maxHeap.add(next);
            }
        }

        if(!maxHeap.isEmpty())
        {
            char last=maxHeap.remove();
            if(map.get(last)>1)
            {
                return "";
            }
            res.append(last);
        }
        return res.toString();
    }
}
