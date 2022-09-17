package SortingAlgorithm;
import java.util.*;
public class BucketSort {
    static int[] bucketsort(int arr[],int n,int max){
        int bucket[]=new int[max+1];
        for(int i=0;i<n;i++){
            bucket[arr[i]]++;
        }
        int index=0;
        for(int i=0;i<=max;i++){
            while(bucket[i]>0){
                arr[index++]=i;
                bucket[i]--;
            }
        }
        return arr;
}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           arr[i]=sc.nextInt();
           if(max<arr[i]) max=arr[i];
        }
        arr=bucketsort(arr,n,max);// calling method
        System.out.println(Arrays.toString(arr));
    }
}
