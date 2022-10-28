//Given unsorted array we need to sort the array. we need to first build minheap and then swaping min value at index 0 in reverse order and heapify at index 0(because index 0 value will not be min)
import java.util.*;
public class HeapSortUsingMinHeap {
    public static int[] minheapify(int arr[],int n,int index){
        int small=index; //given index=large(parent)
        int left=2*index; //finding left child = 2*i
        int right=2*index+1; //finding right child = 2*i +1
        if(left>=n||right>=n){
            return arr;  //if left or right is outOfBound then return arr
        }
        if(left<n && arr[left]<arr[small]) //if left child is smaller than parent then make large=left and swap
        {
            small=left;
        }
        if(right<n && arr[right]<arr[small]) //if right child is smaller than parent then make right=left and swap
        {
            small=right;
        }
        if(small!=index) //if curr smaller is not parent then we need to swap
        {
            int temp=arr[index];
            arr[index]=arr[small];
            arr[small]=temp;
            minheapify(arr,n,small); //recurssion calling of small(which may be left || right after changing small)
        }
        return arr;
    }
    public static int[] buildminheap(int arr[]){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--)//calling heapify function for level above leave nodes from bottom to up(percolate up).
        //As leave nodes are already min heap because it does not have childs
        {
            minheapify(arr,n,i); //heapify nodes from bottom to up
        }
        return arr;
    }
    public static int[] heapsort(int arr[]){
        int n=arr.length;
        for(int i=n-1;i>0;i--)//storing min value of index 0 at ith (for decreasing order) by swapping
        {
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            minheapify(arr, i, 0); //heapify at index 0 as min value at index 0 is swaped with index i
            //sending size as i as heapify is needed to done till that
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={5,52,2,66,78,558,15,4,11,11,12,2,22,2,2,0}; 
        System.out.println("Original Array : "+Arrays.toString(arr)); //input non minheap array
        arr=buildminheap(arr); //calling function for to build minheap for given array
        System.out.println("Array after heapify : "+Arrays.toString(arr));
        arr=heapsort(arr); //calling function to sort the array using min heap
        System.out.print("Array after sorted : "+Arrays.toString(arr));
        sc.close();
      /* output
      Original Array : [5, 52, 2, 66, 78, 558, 15, 4, 11, 11, 12, 2, 22, 2, 2, 0]
      Array after heapify : [0, 2, 2, 2, 11, 5, 15, 2, 78, 11, 12, 558, 22, 52, 66, 4]
      Array after sorted : [558, 78, 66, 52, 22, 15, 12, 11, 11, 5, 4, 2, 2, 2, 2, 0]
      */
    }
}
