//Dijkstra Algorithm
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] prob=new double[n]; //initially 0
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>((a,b)->Double.compare(prob[b],prob[a]));
        List<int[]> adjList[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            adjList[edges[i][0]].add(new int[]{edges[i][1],i});
            adjList[edges[i][1]].add(new int[]{edges[i][0],i});
        }
        prob[start]=1; //probability[start]=1
        maxHeap.offer(start);
        while(!maxHeap.isEmpty()){
            int curr=maxHeap.poll(); //curr
            for(int []neigh:adjList[curr]) //neigh in adjList
            {
                if(prob[curr]*succProb[neigh[1]]>prob[neigh[0]]) //prob[curr]*succProb[i] 
                {
                    prob[neigh[0]]=prob[curr]*succProb[neigh[1]];
                    maxHeap.offer(neigh[0]);
                }
            }
        }
        return prob[end];
    }
}
