package Heap;
import java.util.Arrays;
public class BuildMaxHeap {
    public static int[] maxheapify(int arr[],int root)
    {
        int largeIndex=root;
        int leftchild=2*root;
        int rightchild=2*root+1;
        if(leftchild>arr.length || rightchild>arr.length) //if left or right is outOfBound then return arr
        {
            return arr;
        }
        if(leftchild<arr.length && arr[leftchild]>arr[largeIndex]) //if leftchild > root then make largeIndex=left
        {
            largeIndex=leftchild;
        }
        if(rightchild<arr.length && arr[rightchild]>arr[largeIndex]) //if rightchild > largeIndex then make largeIndex=right
        {
            largeIndex=rightchild;
        }
        if(largeIndex!=root) //if root is not large then swap root with largeIndex
        {
            int temp=arr[largeIndex];
            arr[largeIndex]=arr[root];
            arr[root]=temp;
            //now root will have large number than left and right
            maxheapify(arr, largeIndex); //call maxheapify on largeIndex as its left||right can be larger
        }
        return arr;
    }
    public static int[] buildmaxheap(int arr[])
    {
        int n=arr.length;
         //calling heapify function for level above leaf nodes from bottom to up(percolate up).
        //As leave nodes are already max heap/min heap because it does not have childs
         for(int i=n/2+1;i>0;i--)
         {
            maxheapify(arr, i); //calling maxheapify of another class using obj
         }
         return arr;
    }
    public static void main(String[] args) {
        int arr[]={0,3,6,5,0,8,2,1,9};
        //given array we have to build max heap
        System.out.println("Given Array : "+Arrays.toString(arr)); //original array
        arr=buildmaxheap(arr); //buildheap function
        System.out.println("Max heap Array : "+Arrays.toString(arr)); //after building heap array
    }
}
