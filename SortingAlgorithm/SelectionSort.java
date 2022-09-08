package SortingAlgorithm;
import java.util.Scanner;
public class SelectionSort {
    public int[] SelectionSortAlgo(int arr[],int size){
        int minIndex;
        for(int i=0;i<size-1;i++){
            minIndex=i;
            for(int j=i+1;j<size;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SelectionSort obj=new SelectionSort();
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        obj.SelectionSortAlgo(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
/*
Time complexity:
Worst case  : O(N^2)
Best case   : O(N^2)
Average case: O(N^2)
 */
