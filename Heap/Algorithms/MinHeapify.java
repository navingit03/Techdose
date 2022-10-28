//TC : O(log N)
//for minheapify array input's left and right subtree of index 0 must be minheap
import java.util.*;
public class MinHeapify {
    public static int[] minheapify(int arr[],int index)
    {
        int n=arr.length;
        int small=index; //given index=large(parent)
        int left=2*index+1; //finding left child = 2*i
        int right=2*index+2; //finding right child = 2*i +1
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
            minheapify(arr, small); //recurssion calling of small(which may be left || right after changing small)
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={10,5,2,20,30,15,7}; //for minheapify-array input left and right tree of index 0 must be minheap
        System.out.println("Before MinHeapify"+Arrays.toString(arr)); //input array should be max heap of left and right side of the tree root
        arr=minheapify(arr, 0); //modify the arr= heapify(arr)
        System.out.print("After MinHeapify"+Arrays.toString(arr)); //after heapify the input array
        sc.close();
    }
}
