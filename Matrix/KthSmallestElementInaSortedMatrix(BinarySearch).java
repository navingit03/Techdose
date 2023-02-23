//Leetcode 378. Kth Smallest Element in a Sorted Matrix
//Using BinarySearch
class Solution {
    public int countno(int [][]matrix,int mid) // counting no of elements <= mid
    {
        int count=0; //Initially the count to 0
        int row=0; //row = 0
        int col=matrix.length-1; //col = last col
        while(row<matrix.length&&col>=0)
        {
            if(matrix[row][col]<=mid) //if the value of element at mat[row][col] is less than mid then we add the no of elements in that row to the count 
            {
                count+=(col+1);
                row++;
            }else{
                col--; //decrement the col;
            }
        }
        return count; //returning count of elements in matrix which is less than mid value
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int low=matrix[0][0],high=matrix[n-1][n-1];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(countno(matrix,mid)<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}
