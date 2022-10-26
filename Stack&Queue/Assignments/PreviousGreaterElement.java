// PreviousGreaterElement in array of curr arr[i]
//adding index into stack , if poping element in stack till finding greater value
package StackQueue;
import java.util.*;
public class PreviousGreaterElement {
    public static int[] PGE(int arr[]){
        int res[]=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            while(!stack.isEmpty()&&(arr[stack.peek()]<=arr[i]))
            {
                stack.pop(); //poping small elements before the curr arr[i] 
            }
            res[i]=stack.isEmpty()?-1:arr[stack.peek()]; //if stack is empty then no previous greater element so -1
            stack.push(i); //pushing the index
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
        sc.close();
        System.out.println("Original array : "+Arrays.toString(arr));
        int res[]=PGE(arr); //calling the function
        System.out.println("Previous Greater Element array : "+Arrays.toString(res));
    }
}
