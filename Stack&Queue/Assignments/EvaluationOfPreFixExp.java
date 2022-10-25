//Evaluation of prefix experssion
//ex: - / * 2 * 5 + 3 6 5 2 result=16
//ex: + - 5 3 7 result=9
package StackQueue;
import java.util.*;
public class EvaluationOfPreFixExp {
    public static int prefix(String s[]){
        Stack<Integer> stack=new Stack<>();
        List<String> operator=new ArrayList<>();
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");
        operator.add("^");
        operator.add("%");
        for(int i=s.length-1;i>=0;i--) //iteration from last as operator will be before two values
        {
            if(operator.contains(s[i])){
                int val1=stack.pop();
                int val2=stack.pop();
                switch(s[i]){
                    case "+":
                        stack.push(val1+val2);
                        break;
                    case "-":
                        stack.push(val1-val2);
                        break;
                    case "*":
                        stack.push(val1*val2);
                        break;
                    case "/":
                        stack.push(val1/val2);
                        break;
                    case "^":
                        stack.push(val1^val2);
                        break;
                    case "%":
                        stack.push(val1%val2);
                        break;
                    default:
                        break;
                }
            }else{
                stack.push(Integer.parseInt(s[i]));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        System.out.print(prefix(s));
        sc.close();
    }
}
