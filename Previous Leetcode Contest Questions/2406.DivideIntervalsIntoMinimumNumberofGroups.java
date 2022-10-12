class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        int res=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int[] arr : intervals){
            int s=arr[0];
            int e=arr[1];
            if(pq.isEmpty()||pq.peek()>s){
                res++;
            }else{
                pq.poll();
            }
            pq.add(e+1);
        }
        return res;
    }
}
