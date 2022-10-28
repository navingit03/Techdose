//TC : O(n log n)
//Given an array , first we need to build max heap array and then swaping max value at index 1 in reverse order and heapify at index 1(because index 1 value will not be max)
import java.util.*;
public class HeapSort {
    public static int[] heapify(int arr[],int size,int index)
    {
        int large=index; //given index=large(parent)
        int left=2*index; //finding left child = 2*i
        int right=2*index+1; //finding right child = 2*i +1
        if(left>=size||right>=size) return arr; //if left or right is outOfBound then return arr
        if(left<size && arr[left]>arr[large]){
            large=left; //if left child is greater than parent then make large=left and swap
        }
        if(right<size && arr[right]>arr[large]){
            large=right; //if right child is greater than parent then make right=left and swap
        }
        if(large!=index) //if curr large is not parent then we need to swap
        {
            int temp=arr[large];
            arr[large]=arr[index];
            arr[index]=temp;
            heapify(arr, size, large); //recurssion calling of large(which may be left || right after changing large)
        }
        return arr;
    }
    public static int[] buildheap(int arr[]){
        int n=arr.length;
        for(int i=n/2+1;i>0;i--) //calling heapify function for level above leave nodes from bottom to up(percolate up).
        //As leave nodes are already max heap/min heap because it does not have childs
        {
            heapify(arr,n,i); //heapify nodes from bottom to up
        }
        return arr;
    }
    public static int[] heapsort(int arr[])
    {
        int n=arr.length;
        for(int i=n-1;i>0;i--) //storing max value of index1 at ith (for increasing order) by swapping
        {
            int temp=arr[1];
            arr[1]=arr[i];
            arr[i]=temp;
            heapify(arr, i, 1); //heapify at index 1 as max value at index 1 is swaped with index i
            //sending size as i as heapify is needed to done till that
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={0, 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17}; 
        System.out.println("Original Array : "+Arrays.toString(arr)); //input non heap array
        arr=buildheap(arr); //calling function for to build maxheap for given array
        System.out.println("Array after heapify : "+Arrays.toString(arr));
        arr=heapsort(arr); //calling function to sort the array using max heap
        System.out.print("Array after sorted : "+Arrays.toString(arr));
        sc.close();
        /*Output
        Original Array : [0, 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17]
        Array after heapify : [0, 17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1]
        Array after sorted : [0, 1, 3, 4, 5, 6, 8, 9, 10, 13, 15, 17]
         */
