package SortingAlgorithm;
import java.util.*;
public class CountingSort {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if(max<arr[i]) max=arr[i];
        }
        int hash[]=new int[max+1];
        for(int i=0;i<n;i++){
            hash[arr[i]]++;
        }
        for(int i=1;i<=max;i++){
            hash[i]+=hash[i-1];
        }
        int output[]=new int[n];
        for(int i=n-1;i>=0;i--){
            output[hash[arr[i]]-1]=arr[i];
            hash[arr[i]]--;
        }
        arr=output;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
