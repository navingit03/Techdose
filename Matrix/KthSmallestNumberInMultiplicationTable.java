//Leetcode 668. Kth Smallest Number in Multiplication Table
//Binary Search
//Element at matrix[i][j]=i*j;
class Solution {
    public int lessthanK(int mid,int m,int n) //function used to find number of elements which is <= mid between low and high
    {
        int sum=0;
        for(int i=1;i<=m;i++){
            sum+=Math.min(mid/i,n); minimum of mid/row , col
        }
        return sum; //no of elements <= mid
    }
    public int findKthNumber(int m, int n, int k) {
        int low=1; //initially low = 1
        int high=m*n; //initially high = m*n
        while(low<=high){
            int mid=low+(high-low)/2; //finding the middle element
            if(lessthanK(mid,m,n)<k) // If no of elements from 1 to mid is less than k, then kth smallest element will be for mid to m*n so updating low = mid+1
            {
                low=mid+1;
            }
            else //high=mid-1
            {
                high=mid-1;
            }
        }
        return low; //returning the k th smallest element 
    }
}
