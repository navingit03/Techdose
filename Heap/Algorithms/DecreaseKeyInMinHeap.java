//We are give a minheap array we need to decrease value at key then we need to find updated minheap array
import java.util.*;
public class DecreaseKeyInMinHeap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={2,5,7,10,12,20,30}; //initial input maxheap array
        System.out.println("Original Array before decrease key : "+Arrays.toString(arr));
        int updateIndex=4; //input index where we have to update the value at particular index
        int updateDiff=-8; //update index value by diff
        arr[updateIndex]+=updateDiff; //updating the value at index
        int i=updateIndex;
        while(i>0 && arr[i]<arr[i/2-1]) //index i should below top(min element) else underflow happen as i/2 not avaiable
        {
            int temp=arr[i]; //if(child is smaller than its parent(i/2) we need to swap parent and child)
            arr[i]=arr[i/2-1];
            arr[i/2-1]=temp;
            i/=2; //moving to curr index's parent. i should not be <=0 as top 0 does not have parent
        }
        System.out.println("MinHeap Array after decrease value at index : "+Arrays.toString(arr));
        sc.close();
        /*output
        Original Array before decrease key : [2, 5, 7, 10, 12, 20, 30]
        MinHeap Array after decrease value at index : [2, 4, 7, 10, 5, 20, 30]
         */
    }
}
