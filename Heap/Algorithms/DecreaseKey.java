//we have to update value(diff) at given index which will become smaller
//percolate down approach
import java.util.*;
public class DecreaseKey {
    public static int[] heapify(int []arr,int i){
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
            heapify(arr,large); //recurssion calling of large(which may be left || right after changing large)
        }
        return arr;
    }
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int arr[]={0,9,8,7,6,5,4,3,2,1,0,-1}; //initial input maxheap array
    int updateIndex=2; //input index where we have to update the value at particular index
    int updateDiff=-8; //update index value by diff
    arr[updateIndex]=arr[updateIndex]+updateDiff;
    arr=heapify(arr,updateIndex);
    System.out.println(Arrays.toString(arr));
    }
}
