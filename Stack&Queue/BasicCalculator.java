//Leetcode 224. Basic Calculator
class Solution {
    public int calculate(String s) {
        s=s.replaceAll(" ",""); //removing all the spaces
        Stack<Integer> stack=new Stack<>(); //stack to find res inside () parathesis
        int len=s.length();
        int sign=1; //first sign is positive
        int result=0; //we need to find the result
        int currnum=0; //finding currnum till non digit character
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)) //if is digit of ch then add it to currnum
            {
                currnum=(currnum*10)+(int)(ch-'0');
            }
            else if(ch=='+')
            {
                result+=(sign*currnum); //adding previous (sign * currnum)
                currnum=0; //making currnum=0 for upcoming numbers
                sign=1; //sign = 1 for next result calculation
            }
            else if(ch=='-'){
                result+=(sign*currnum); //adding previous (sign * currnum)
                currnum=0; //making currnum=0 for upcoming numbers
                sign=-1; //sign = -1 for next result calculation
            }
            else if(ch=='('){
                stack.push(result); //first pushing the result
                stack.push(sign); //then pushing the sign
                result=0; //making result=0 as it is pushed into the stack
                sign=1;
            }
            else if(ch==')'){
                result+=(sign*currnum); adding previous(sign*currnum)
                currnum=0;
                result*=stack.pop(); //multiplying the result by sign in stack which is before '(' parathesis (ex: if sign is '-' before '(' then whole value is * by sign
                result+=stack.pop(); //adding the previous sign
            }
        }
        if(!(currnum==0))
        {
            result+=(sign*currnum); //finally if  number is not 0 add it to result;
        }
        return result;
    }
}
