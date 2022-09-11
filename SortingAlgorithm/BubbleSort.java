package SortingAlgorithm;
import java.util.Scanner;
public class BubbleSort {
    public int[] BubbleSortAlgo(int arr[],int size){
        for(int i=0;i<size-1;i++){
            boolean isSwapped=false;
            for(int j=0;j<size-i-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j]=arr[j]^arr[j+1];
                    arr[j+1]=arr[j]^arr[j+1];
                    arr[j]=arr[j]^arr[j+1];
                    isSwapped=true;
                }
            }
            if(!isSwapped){
                break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        BubbleSort obj=new BubbleSort();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        obj.BubbleSortAlgo(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
/*
Time complexity:
Worst case  : O(N^2)
Best case   : O(N) Array already sorted
Average case: O(N) Array element in random order
 */