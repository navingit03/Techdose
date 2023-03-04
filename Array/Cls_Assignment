public class FindMinimumTimeToFinishAllJobs {
    public static boolean isMidTimeWorkDone(int arr[],int n,int workers,int work)
    {
        int sum=0,k=workers;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>work)
            {
                return false;
            }
            if(sum+arr[i]>=work)
            {
                if(k>0)
                {
                    k--;
                }else
                {
                    return false;
                }
                sum=(sum+arr[i]<=work)?0:arr[i]; //if sum is < work make it 0 
            }else
            {
                sum+=arr[i];
            }
        }
        if(sum<=work && k>0)
        {
            k--;
            sum=0;
        }
        return sum==0;
    }
    public static int minTime(int []arr,int n,int workers)
    {
        int low=0,high=0;
        //low-if there are more than n workers then max in arr will be the time to complete the work by workers
        //high-if there is only 1 worker then work time = sum of all works in arr
        for(int i=0;i<n;i++)
        {
            high+=arr[i];
            if(arr[i]>low)
            {
                low=arr[i];
            }
        }
        int mintime=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(isMidTimeWorkDone(arr,n,workers,mid)==true)
            {
                mintime=mid; //if in mid time work is done then it can be min time
                high=mid-1;
            }else
            {
                low=mid+1;
            }
        }
        return mintime;
    }
    public static void main(String[] args) {
        int arr[]={5,8,2,10,11,12};
        int n=arr.length;
        int workers=3;
        System.out.println(minTime(arr,n,workers));
    }
}
