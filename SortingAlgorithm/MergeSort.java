package SortingAlgorithm;
import java.util.*;
public class MergeSort {
    public static void merge(int []arr,int left,int mid,int right){
        int index=0;
        int n1=mid-left+1;
        int n2=right-mid;
        int L[]=new int[n1];
        int R[]=new int[n2];
        for(index=0;index<n1;index++){
            L[index]=arr[left+index];
        }
        for(index=0;index<n2;index++){
            R[index]=arr[mid+1+index];
        }
        int i=0,j=0,k=left;
        while(i<n1&&j<n2){
            if(L[i]<=R[j]){
                arr[k++]=L[i++];
            }else{
                arr[k++]=R[j++];
            }
        }
        while(i<n1){
            arr[k++]=L[i++];
        }
        while(j<n2){
            arr[k++]=R[j++];
        }
    }
    public static void mergesort(int []arr,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
            mergesort(arr, left, mid);
            mergesort(arr, mid+1,right);
            merge(arr,left,mid,right);
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
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
