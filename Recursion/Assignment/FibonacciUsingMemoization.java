//to find fibonacci number using Memoization
import java.util.*;
public class FibonacciUsingMemoization {
    static int arr[]=new int[31]; //to store arr[n] if fib(n) is already found for further use
    public static int fib(int n)
    {
        if(n==0||n==1) return n; //base case
        else if(arr[n]!=0) //if fib(n) is already stored in arr
        {
            return arr[n]; //return fib val in arr
        }
        else
        {
            arr[n]=fib(n-1)+fib(n-2); //recursion call
            return arr[n];
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        arr[0]=0; //base case
        arr[1]=1; //base case
        System.out.print(fib(n)); //function call
        sc.close();
    }
}

