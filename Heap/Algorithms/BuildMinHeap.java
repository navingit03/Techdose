//Building a minheap for given input array
//TC: O(n)
//Percolate up (Bottom to up algorithm)
import java.util.*;
public class BuiltMinHeap {
    public static int[] minheapify(int arr[],int size,int index){
        int small=index; //given index=large(parent)
        int left=2*index+1; //finding left child = 2*i
        int right=2*index+2; //finding right child = 2*i +1
        if(left>=size || right>=size){
            return arr; //if left or right is outOfBound then return arr
        }
        if(left<size && (arr[left]<arr[small])) //if left child is smaller than parent then make small=left and swap
        {
            small=left;
        }
        if(right<size && (arr[right]<arr[small])) //if right child is smaller than parent then make small=right and swap
        {
            small=right;
        }
        if(small!=index) //if curr smaller is not parent then we need to swap
        {
            int temp=arr[small];
            arr[small]=arr[index];
            arr[index]=temp;
            minheapify(arr, size, small); //recurssion calling of small(which may be left || right after changing small)
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
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
        int arr[]={5,3,17,10,84,19,6,22,9}; //number of nodes
        System.out.println("Given Array : "+Arrays.toString(arr)); //original array
        arr=buildminheap(arr); //buildMinHeap function
        System.out.println("Min Heap Array : "+Arrays.toString(arr)); //after building minheap array
        //Given Array : [5, 3, 17, 10, 84, 19, 6, 22, 9]
        //Min Heap Array : [3, 5, 6, 9, 84, 19, 17, 22, 10]
        sc.close();
   } 
}
