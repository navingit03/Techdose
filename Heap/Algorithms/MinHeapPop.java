//Given minheap array pop min value and copy last value to first value and minheapify index 0
import java.util.*;
public class MinHeapPop {
    public static int[] minheapify(int arr[],int index){
        int n=arr.length;
        int small=index;
        int left=2*index+1;
        int right=2*index+2;
        if(left>=n||right>=n) return arr;
        if(left<n && (arr[left]<arr[small])){
            small=left;
        }
        if(right<n && (arr[right]<arr[small])){
            small=right;
        }
        if(small!=index){
            int temp=arr[index];
            arr[index]=arr[small];
            arr[small]=temp;
            minheapify(arr, small);
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[]={3,5,6,9,84,19,17,22,10};
        //int arr[]={2,5,7,10,12,20,30};
        System.out.println("Original Array : "+Arrays.toString(arr)); //printing min heap array before poping min element
        System.out.println("Min element in heap is "+arr[0]); //printing min element and poping it
        arr[0]=arr[arr.length-1]; //copying last element to first element
        arr=Arrays.copyOf(arr, arr.length-1);
        arr=minheapify(arr,0);
        System.out.println("Array after poping min element : "+Arrays.toString(arr));  //array after poping max element
        /* output
        Original Array : [3, 5, 6, 9, 84, 19, 17, 22, 10]
        Min element in heap is 3
        Array after poping min element : [5, 9, 6, 10, 84, 19, 17, 22]
         */
    }
}
