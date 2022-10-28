//given minheap array we need to update a value at give index , then we need to make updated array into minheap
import java.util.*;
public class IncreaseKeyInMinHeap {
    public static int[] minheapify(int arr[],int n,int index){
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
            minheapify(arr,n,small); //recurssion calling of small(which may be left || right after changing small)
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[]={2,5,7,10,12,20,30};
        System.out.println("Original Array : "+Arrays.toString(arr)); // initial input minheap array
        int updateIndex=1; //given index to update value
        int updateValue=6; //update value(diff)
        arr[updateIndex]+=updateValue; //updating value at updateIndex
        arr=minheapify(arr,arr.length,updateIndex); //calling heapify for the particular index
        System.out.println("Array after updating the key : "+Arrays.toString(arr)); //array after updating value
    }
}
