//NextSmallestElement for curr arr[i]
package StackQueue;
import java.util.*;
public class nextSmallestElement {
    public static int[] NSE(int arr[]){
        int res[]=new int[arr.length]; //creating res array for NSE
        Stack<Integer> stack=new Stack<>(); //stack to add index
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]) //finding next greater element from last
            {
                stack.pop(); //poping next greater number
            }
            res[i]=stack.isEmpty()?-1:arr[stack.peek()]; //if not empty then top is NSE
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Original array : "+Arrays.toString(arr));
        sc.close();
        int []res=NSE(arr); //sending the original array to find next smallest element
        System.out.print("Next Smallest element Array : "+Arrays.toString(res));
    }
}
