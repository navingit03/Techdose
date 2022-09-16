package SortingAlgorithm;
import java.util.Scanner;
public class QuickSort {
    public void Quicksort(int arr[],int left,int right){
        if(left<right){
            int pivot=arr[left];
            int i=left;
            int j=right;
            do{
                i++;
                while(i<=right&&arr[i]<pivot){
                    i++;
                }
                while(j>=left&&arr[j]>pivot){
                    j--;
                }
                if(i<j&&i<=right){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }while(i<j);
            int temp=arr[j];
            arr[j]=arr[left];
            arr[left]=temp;
            Quicksort(arr, left, j-1);
            Quicksort(arr, j+1, right);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
        QuickSort obj=new QuickSort();
        obj.Quicksort(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
