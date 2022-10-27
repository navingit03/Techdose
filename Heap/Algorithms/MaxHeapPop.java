//Poping the top element in maxheap and maxheapify the array
// top to bottom(precolate down)
import java.util.*;
public class Heap_Pop {
    public static int[] Maxheapify(int arr[],int i){
        int large=i; //given index=large(parent)
        int left=2*i; //finding left child = 2*i
        int right=2*i+1; //finding right child = 2*i +1
        if(left>=arr.length||right>=arr.length) return arr; //if left or right is outOfBound then return arr
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
            Maxheapify(arr, large); //recurssion calling of large(which may be left || right after changing large)
        }
        return arr;
    }
    public static int FindMaxAndPop(int arr[]){
        if(arr.length<=1) return -1; //if there is len<= 1 elements in array of 1 indexed then no max element
        int max=arr[1]; //storing the max element. Searching max element is TC:O(n)
        arr[1]=arr[arr.length-1]; //copying last element to top(first element)
        arr=Arrays.copyOf(arr, arr.length-1); //removing the last element
        arr=Maxheapify(arr,1); //maxheapify the index 1 as left and right of element 1 is already maxheap
        System.out.println("After Poping max element in Heap"+Arrays.toString(arr)); //array after poping max element
        return max; //returning max element
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //number of nodes
        int arr[]=new int[n+1]; //1 indexed array so n+1 elements
        for(int i=1;i<=n;i++)
        {
            arr[i]=sc.nextInt(); //reading all the nodes
        }
        System.out.println("Original Array"+Arrays.toString(arr)); //printing max heap array before poping max element
        System.out.println("Max element in heap is "+FindMaxAndPop(arr)); //printing max element and poping it
        sc.close();
    }
}
