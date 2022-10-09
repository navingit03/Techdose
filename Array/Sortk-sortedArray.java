//Sort a K-sorted Array
//Using minheap
//TC: O(n*log(k))
import java.util.*;
public class Main
{
    public static void sortArray(int[] arr,int n,int k){
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        int minK=Math.min(k+1,n);
        for(int i=0;i<minK;i++) //adding first k+1 element in minheap
        {
            minheap.add(arr[i]);
        }
        int index=0;
        for(int i=k+1;i<n;i++){
            arr[index++]=minheap.peek(); //adding element in arr of top of minheap
            minheap.poll(); //polling top element
            minheap.add(arr[i]); //adding element from k+1
        }
        while(index<n){
            arr[index++]=minheap.peek(); //adding balance element from minheap to array
            minheap.poll();
        }
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
		    arr[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		sortArray(arr,n,k);
		System.out.print(Arrays.toString(arr));
	}
}
