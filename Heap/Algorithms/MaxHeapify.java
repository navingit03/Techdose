//It is a maxheap algorithm
//input tree's left and right should be maxheap
//Percolate down(top-down aproach)
//TC: O(log n)
import java.util.*;
public class Maxheapify {
    public static int[] heapify(int []arr,int i){
        int large=i; //given index=large(parent)
        int left=2*i; //finding left child = 2*i
        int right=2*i+1; //finding right child = 2*i +1
        if(left>arr.length||right>arr.length) return arr; //if left or right is outOfBound then return arr
        if(left<arr.length && arr[left]>arr[large]) //if left child is greater than parent then make large=left and swap
        {
            large=left;
        }
        if(right<arr.length && arr[right]>arr[large]) //if right child is greater than parent then make right=left and swap
        {
            large=right;
        }
        if(large!=i) //if curr large is not parent then we need to swap
        {
            int temp=arr[i];
            arr[i]=arr[large];
            arr[large]=temp;
            heapify(arr,large); //recurssion calling of large(which may be left || right after changing large)
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //number of nodes
        int[] arr=new int[n+1]; //for non heap array input but left and right tree of index 1 is maxheap
        for(int i=1;i<=n;i++)
        {
            arr[i]=sc.nextInt(); //scanning the element from 1 as heap is array 1 indexed
        }
        System.out.println("Before Heapify"+Arrays.toString(arr)); //input array should be max heap of left and right side of the tree root
        arr=heapify(arr, 1); //modify the arr= heapify(arr)
        System.out.print("After Heapify"+Arrays.toString(arr)); //after heapify the input array
    }
}
