//Leetcode 20. Valid Parentheses
//TC: O(n)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>(); //creating a stack
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='{') //if ch is '{' then push '}'
            {
                stack.push('}');
            }
            else if(s.charAt(i)=='[') //if ch is '[' then push ']'
            {
                stack.push(']');
            }
            else if(s.charAt(i)=='(') ////if ch is '(' then push ')'
            {
                stack.push(')');
            }
            else if(stack.empty()||stack.pop()!=s.charAt(i)) // if ),},] comes, we check stack.pop != ch then return false
            {
                return false;
            }
        }
        return stack.empty();
    }
}
