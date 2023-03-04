//Leetcode 994. Rotting Oranges
//using queue
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}}; //adjacent grid[][] difference
        int r=grid.length; //row size
        int c=grid[0].length; //col size
        int fresh=0; //initially fresh count=0
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j}); //if rotten add its pos in queue
                if(grid[i][j]==1){
                    fresh++; //if fresh increase fresh count by 1
                }
            }
        }
        if(fresh==0) return 0; //if no fresh found return 0
        int min=0,qsize=0;
        while(!q.isEmpty()) //if queue is not empty
        {
            qsize=q.size(); //finding current queue size so that newly added will not be removed at curr min
            for(int i=0;i<qsize;i++)
            {
                int pos[]=q.poll(); //finding pos of rotten orange at queue's front
                for(int j=0;j<4;j++) //checking in all four direction
                {
                    int x=pos[0]+dir[j][0]; //finding x=rotten's x pos + adjacent x pos 
                    int y=pos[1]+dir[j][1]; //finding y=rotten's y pos + adjacent y pos 
                    if((x>=0&&x<r)&&(y>=0&&y<c)&&grid[x][y]==1) if x and y is valid pos and grid[x][y] is fresh
                    {
                        fresh--; //making it rotten so fresh--
                        grid[x][y]=2; //making it rotten
                        q.add(new int[]{x,y}); //adding curr rotten pos in queue
                    }
                }
            }
            min++; //minutes++
        }
        return fresh==0?min-1:-1; //if all orange became rotten then res=min-1
    }
}
