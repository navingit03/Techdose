//PreviousSmallerElement of curr arr[i]
//poping elements in stack till finding smaller element for curr arr[i]
package StackQueue;
import java.util.*;
public class PreviousSmallerElement {
    public static int[] PSE(int []arr){
        int res[]=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty()&&(arr[stack.peek()]>=arr[i]))
            {
                stack.pop(); //poping till finding the previous smaller element
            }
            res[i]=stack.isEmpty()?-1:arr[stack.peek()]; //if stack is empty then no previous smaller element so -1
            stack.push(i); //pushing index
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
        int res[]=PSE(arr); //calling the function
        System.out.println("Previous Smaller Element : "+Arrays.toString(res));
    }
}
