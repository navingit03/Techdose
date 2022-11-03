import java.util.*;
public class MergeSort {
    
    public static void merge(int arr[],int low,int mid,int high)
    {
        //geeksforgeeks method
        for(int i=high;i>mid;i--) //second arr traverse from last
        {
            int j,last=arr[mid]; //storing last element of second half
            for(j=mid-1;j>=low&&arr[j]>arr[i];j--)  //finding while arr1[j] is greater than arr2[i] moving arr1[j] by 1 pos
            {
                arr[j+1]=arr[j]; //making space in arr1 by moving greater element left by 1 pos for the less number of arr2
            }
            if(last>arr[i]) //last element of arr1 is > arr2[i]
            {
                arr[j+1]=arr[i]; //storing i th element of arr2 in arr1[j+1]
                arr[i]=last; //the last element of arr1 is stored in arr2 
            }
        }
    }
    public static void mergesort(int arr[],int low,int high)
    {
        if(low<high)
        {
            int mid=low+(high-low)/2; //finding mid element
            mergesort(arr, low, mid); //divide first half
            mergesort(arr, mid+1, high); //divide second half
            merge(arr,low,mid,high); //merge call
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        mergesort(arr,0,n-1);
        System.out.print(Arrays.toString(arr));
        sc.close();
    }
}
