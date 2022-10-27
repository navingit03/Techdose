//we have to update value(diff) at given index
//percolate up approach
import java.util.*;
public class IncreaseKey {
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int arr[]={0,9,8,7,6,5,4,3,2,1,0,-1}; //initial input maxheap array
    int updateIndex=5; //input index where we have to update the value at particular index
    int updateDiff=4; //update index value by diff
    arr[updateIndex]=arr[updateIndex]+updateDiff;
    int i=updateIndex; //i is the node which is updated we have to move it to its correct position
    while(i>1 && arr[i]>arr[i/2]) //index i should below top(max element) else underflow happen as i/2 not avaiable
    {
        int temp=arr[i];  //if(child is greater than its parent(i/2) we need to swap parent and child)
        arr[i]=arr[i/2];
        arr[i/2]=temp;
        i/=2; //moving to curr index's parent. i should not be <=1 as top 1 does not have parent
    }
    System.out.println(Arrays.toString(arr));
    sc.close();
   } 
}
