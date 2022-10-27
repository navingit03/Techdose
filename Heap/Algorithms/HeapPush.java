//pushing an element into maxheap
//bottom to up approach(percolate up)
import java.util.*;
public class HeapPush {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={0,20,9,8,7,6,5,4,3}; // initial input maxheap array
        int pushnum=12; //pushing 12 into maxheap
        arr=Arrays.copyOf(arr, arr.length+1); //increase size of array by 1 to add new element
        arr[arr.length-1]=pushnum; //adding element to last index
        int i=arr.length-1; //checking correct place for newly added element
        while(i>1 && arr[i/2]<arr[i]) //index i should below top(max element) else underflow happen as i/2 not avaiable
        {
            int temp=arr[i]; //if(child is greater than its parent(i/2) we need to swap parent and child)
            arr[i]=arr[i/2];
            arr[i/2]=temp;
            i/=2; //moving to curr index's parent. i should not be <=1 as top 1 does not have parent
        }
        sc.close();
        System.out.println(Arrays.toString(arr)); //printing after pushing element into array
    }
}
