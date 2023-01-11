class Solution {
    //source to destination with min of diff (Dijkstra Algorithm) 
    public int minimumEffortPath(int[][] heights) {
        int r=heights.length;
        int c=heights[0].length;
        int efforts[][]=new int[r][c]; //creating new matrix
        for(int i=0;i<r;i++){
            Arrays.fill(efforts[i],Integer.MAX_VALUE); //fill it with infinite
        }
        efforts[0][0]=0; //initially 0
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]); //sorting based on min heap of cost
        pq.add(new int[]{0,0,0}); //source and its cost;
        int dir[][]={{-1,0},{0,1},{1,0},{0,-1}}; //four direction traversal
        while(!pq.isEmpty())
        {
            int row=pq.peek()[0]; 
            int col=pq.peek()[1];
            int cost=pq.peek()[2]; //peeking min heap of cost
            if(row==r-1&&col==c-1) //if destination is reached then return right away the cost
            {
                return cost;
            }
            pq.poll();
            for(int i=0;i<4;i++) //traversing 4 direction
            {
                int newRow=row+dir[i][0];
                int newCol=col+dir[i][1];
                if(newRow<0||newRow>=r||newCol<0||newCol>=c) //index invalid
                {
                    continue;
                }
                int newCost=Math.max(Math.abs(heights[newRow][newCol]-heights[row][col]),cost); //max of (cost and new diff)
                if(newCost<efforts[newRow][newCol])
                {
                    efforts[newRow][newCol]=newCost; //updating matrix with min of max diff
                    pq.add(new int[]{newRow,newCol,newCost}); //add it in pq
                }
            }
        }
        return efforts[r-1][c-1]; //destination
    }
}
