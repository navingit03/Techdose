//Leetcode 386. Lexicographical Numbers
//Using stack
class Solution {
    public List<Integer> lexicalOrder(int n) {
        //method 2(using stack)
        List<Integer> res=new ArrayList<Integer>();
        Stack<Integer> stack=new Stack<>();
        for(int i=9;i>=1;i--){
            if(i<=n){
                stack.add(i);
            }
        }
        while(!stack.empty()){
            int curr=stack.pop();
            res.add(curr);
            if(curr<n){
                for(int i=0;i<=9;i++)
                {
                    int next=curr*10+i; if(curr=1,then we have to add (next-10,11,12,13,14,15,16,17,18,19) if(next<n) we have to add(next)
                    if(next<=n) res.add(next);
                }
            }
        }
        return res;
        
        //method 2(using in-built function)
        /*List<Integer> list=new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        Collections.sort(list,(a,b)->(Integer.toString(a).compareTo(Integer.toString(b))));
        return list;
        */
    }
}
/*
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
/*
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
You must write an algorithm that runs in O(n) time and uses O(1) extra space. 
Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
*/
