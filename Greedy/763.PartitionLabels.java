class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max=0;
        int prev=-1;
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),i);
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            max=Math.max(max,map.get(s.charAt(i)));
            if(max==i)
            {
                list.add(i-prev);
                prev=i;
            }
        }
        return list;
    }
}
