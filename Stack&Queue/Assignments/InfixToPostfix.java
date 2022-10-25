//Converting infix expression to postfix expression
//ex: s="a*(b+c)/d" result="abc+*d/"
package StackQueue;
import java.util.*;
public class infixTopostfixexp {
    public static String intopost(String s){
        HashMap<Character,Integer> precidence=new HashMap<>(); //creating a precidence for operator
        precidence.put('+',1);
        precidence.put('-', 1);
        precidence.put('*',2);
        precidence.put('/', 2);
        precidence.put('%', 2);
        precidence.put('^',3);
        Stack<Character> stack=new Stack<>();
        String result="";
        int len=s.length();
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(ch>='a'&&ch<='z') //if it is a character then add it to result
            {
                result+=ch+"";
            }
            else if(ch=='(') //add '(' into stack
            {
                stack.push(ch);
            }
            else if(ch==')')
            {
                while(!stack.isEmpty()&&stack.peek()!='(') //if ch==')' pop till '('
                {
                    result+=stack.pop()+"";
                }
                stack.pop(); //pop '('
            }
            else{
                while(!stack.isEmpty() && stack.peek()!='(' && precidence.get(stack.peek())>=precidence.get(ch)){
                    result+=stack.pop()+""; //first adding stack top with high precidence
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            result+=stack.pop()+"";
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.print(intopost(s));
        sc.close(); 
    }
}
