//adding a value to minheap and we have to place it in right palce so that the array will be minheap
import java.util.*;
public class MinHeapPush {
    public static void main(String[] args) {
        int arr[]={ 2,5,7,20,30,15,10};
        System.out.println("Original Array of minheap : "+Arrays.toString(arr)); // initial input minheap array
        int pushnum=1; //pushing 1 into minheap
        arr=Arrays.copyOf(arr, arr.length+1); //increase size of array by 1 to add new element
        arr[arr.length-1]=pushnum; //adding element to last index
        int i=arr.length-1; //to checking correct place for newly added element
        while(i>0 && arr[i]<arr[i/2]) //index i should below top(min element) else underflow happen as i/2 not avaiable
        {
            int temp=arr[i];  //if(child is greater than its parent(i/2) we need to swap parent and child)
            arr[i]=arr[i/2];
            arr[i/2]=temp;
            i/=2; //moving to curr index's parent. i should not be <=1 as top 1 does not have parent
        }
        System.out.println("After pushing a number in minHeap the Array is : "+Arrays.toString(arr));
    }
}
