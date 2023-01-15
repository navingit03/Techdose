public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[]={1, 101, 2, 3, 100, 4, 5}; //ans-106
        int msis[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            msis[i]=arr[i]; //upating msis by curr arr[i] value
        }
        int max=msis[0];
        for(int i=1;i<arr.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j]<arr[i] && msis[j]+arr[i]>msis[i]) //if arr[i]>arr[j] && msis[j]+arr[i]>msis[i]
                {
                    msis[i]=msis[j]+arr[i]; //update
                }
            }
            max=Math.max(max,msis[i]); //finding max
        }
        System.out.print(max);
    }
}
