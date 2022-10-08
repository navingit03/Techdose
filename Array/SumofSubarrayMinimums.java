//Leetcode 907. Sum of Subarray Minimums
//Using monotonoic stack
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long res=0;
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(-1);
        long mod=(long)1e9+7;
        for(int i=0;i<arr.length+1;i++){
            int c=(i<arr.length)?arr[i]:0;
            while(stack.peek()!=-1&&c<arr[stack.peek()]){
                int index=stack.pop();
                int currIndex=stack.peek();
                int rightDiff=i-index;
                int leftDiff=index-currIndex;
                long sum=(long)(leftDiff*rightDiff*(long)arr[index])%mod;
                res+=sum;
                res%=mod;
            }
            stack.push(i);
        }
        return (int)res;

    }
}
