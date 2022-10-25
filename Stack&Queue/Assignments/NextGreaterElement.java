//we need to find next greater element of curr arr[i]
//ex : arr[] = [ 4 , 5 , 2 , 25 ] res[] = arr[] = [ 5 , 25 , 25 , -1 ]
package StackQueue;
import java.util.*;
public class nextGreaterElement {
    public static int[] NGE(int[] arr){
        Stack<Integer> stack=new Stack<>(); //stack to add index
        int res[]=new int[arr.length]; //creating res array for NGE
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty()&&(arr[stack.peek()]<=arr[i])) //finding next small element from last
            {
                stack.pop();
            }
            res[i]=stack.isEmpty()?-1:arr[stack.peek()]; //if not empty then top is NGE
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
        int []res=NGE(arr); //sending the original array to find next greater element
        System.out.print("Next Greater element Array : "+Arrays.toString(res));

    }
}
