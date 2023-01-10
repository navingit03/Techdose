//TC O(V^3)
package GraphAlgo;
public class FloydWarshallAlgorithm {
    public static void floydwarshall(int [][]graph){
        int v=graph.length;
        int dist[][]=new int[graph.length][graph[0].length]; //copying graph matrix
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                dist[i][j]=graph[i][j];
            }
        }
        for(int k=0;k<v;k++) //including every vertex and finding if less weight path is present via k th node
        {
            for(int i=0;i<v;i++) //including every start pos
            {
                for(int j=0;j<v;j++) //including every end point
                {
                    if(dist[i][k]==Integer.MAX_VALUE||dist[k][j]==Integer.MAX_VALUE) //skip if no path via k th node
                    {
                        continue;
                    }
                    else if(dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j]; //if there is a path via k from i to j is lesser than dist[i][j]
                    }
                }
            }
        }
        for(int i=0;i<v;i++){
            if(dist[i][i]<0) //checking self loop values if < 0
            {
                System.out.println("Negative Edge Weight cycle");
                return;
            }
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                System.out.println(i+" to "+j+" distance : "+dist[i][j]); //path matrix with weight
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int graph[][]={ {0, 1, 4, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, 0, 4, 2, 7, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 3, 4, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 4},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 0, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 0} }; //input edge matrix
        floydwarshall(graph);
    }
}
