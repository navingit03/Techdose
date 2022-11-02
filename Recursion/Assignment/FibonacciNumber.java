//Leetcode 509. Fibonacci Number
class Solution {
    public int fib(int n) 
    {
        if(n==0||n==1) //base condition
        {
            return n;
        }
        return fib(n-1)+fib(n-2); //return + recursion call
    }
}
