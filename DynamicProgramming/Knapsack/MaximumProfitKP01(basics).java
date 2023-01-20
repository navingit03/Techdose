public class MaximumProfitKP01 {
    public static int KnapsackRecursion(int []weight,int profit[],int capacity,int index){
        if(capacity==0||index==weight.length) //base case
        {
            return 0;
        }
        /* memoization
        if(mat[index][capacity]!=-1){
            return mat[index][capacity];
        }
        */
        if(capacity<weight[index]){
            return KnapsackRecursion(weight, profit, capacity, index+1); //(skip case) if capacity is less then weight
        }
        int include=profit[index]+KnapsackRecursion(weight, profit, capacity-weight[index], index+1); //included curr weight index and decreasing weight in capacity
        int exclude=KnapsackRecursion(weight, profit, capacity, index+1); //excluding and increasing index by 1
        return Math.max(include, exclude);
        //return mat[index][capacity]=Math.max(include, exclude); memoization
    }
    public static int KnapsackInDP(int []weight,int []profit,int capacity,int index){
        int [][]dp=new int[weight.length+1][capacity+1]; //1 indexed 0/1 KP
        for(int i=0;i<=weight.length;i++) //till i th weight
        {
            for(int j=0;j<=capacity;j++) //capacity from 0 to maxcapacity
            {
                if(i==0||j==0) //if there is no item or 0 capacity
                {
                    dp[i][j]=0; //profit=0
                }else if(j<weight[i-1]) //if curr capacity is less than weight (i-1) as dp is 1 indexed
                {
                    dp[i][j]=dp[i-1][j]; //exclude case (not include  i th element and same curr capacity)
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],profit[i-1]+dp[i-1][j-weight[i-1]]);
                    //max of exclude and include->profit of curr item + dp of prev(i-1) + currcapacity - curr weight
                }
            }
        }
        return dp[weight.length][capacity];
    }
    public static void main(String[] args) {
        int []weight={1,2,3};
        int []profit={2,3,5};
        int maxCapacity=4;
        System.out.println("Recursion "+KnapsackRecursion(weight,profit,maxCapacity,0));
        System.out.println("Tabulation "+KnapsackInDP(weight,profit,maxCapacity,0));
    }
}
