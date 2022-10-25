//Leetcode 227. Basic Calculator II
//string s will contains only ('+', '-', '*', '/')
class Solution {
    public int calculate(String s) {
        s=s.replaceAll(" ",""); //removing all the space in string s
        Stack<Integer> stack=new Stack<>();
        char operator='+';
        int len=s.length(),result=0,currnum=0;
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
                currnum=(currnum*10)+(int)(ch-'0'); //converting string into number till next non digit character
            }
            if(!Character.isDigit(ch)||i==len-1) //if non digit or last character
            {
                if(operator=='+'){
                    stack.push(currnum);
                }
                else if(operator=='-'){
                    stack.push(-currnum);
                }
                else if(operator=='*'){
                    stack.push(stack.pop()*currnum);
                }else if(operator=='/'){
                    stack.push(stack.pop()/currnum);
                }
                currnum=0; //after every operation currnum becames zero so that next number is found using first if condition
                operator=ch;
            }
        }
        while (!stack.empty()){
            result+=stack.pop(); //poping all element and adding it to result
        }
        return result;
    }
}
/*
Given a string s which represents an expression, evaluate this expression and return its value. 
The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 
Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/
