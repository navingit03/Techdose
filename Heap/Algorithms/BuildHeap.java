//Building a heap for given input array
//TC: O(n)
//Percolate up (Bottom to up algorithm)
import java.util.*;
public class BuiltHeap {
    public static int[] heapify(int arr[],int i){
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
            int temp=arr[large];
            arr[large]=arr[i];
            arr[i]=temp;
            heapify(arr, large); //recurssion calling of large(which may be left || right after changing large)
        }
        return arr;
    } 
    public static int[] buildheap(int arr[]){
        int N=arr.length;
        for(int i=N/2+1;i>0;i--) //calling heapify function for level above leave nodes from bottom to up(percolate up).
        //As leave nodes are already max heap/min heap because it does not have childs
        {
            heapify(arr,i);  //heapify nodes from bottom to up
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //int arr[]={0,1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int n=sc.nextInt(); //number of nodes
        int arr[]=new int[n+1]; //1 indexed array so n+1 elements
        for(int i=1;i<n+1;i++){
            arr[i]=sc.nextInt(); //index from 1 to n
        }
        System.out.println("Given Array : "+Arrays.toString(arr)); //original array
        arr=buildheap(arr); //buildheap function
        System.out.println("Max heap Array : "+Arrays.toString(arr)); //after building heap array
        //Given Array : [0, 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17]
        //Max heap Array : [0, 17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1]
        sc.close();
    }
}
