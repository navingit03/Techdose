//Evaluation Of PostFix Expression
//ex: 2 5 3 6 + * * 5 / 2 - result=16
//ex: 4 5 + result=9
package StackQueue;
import java.util.*;
public class EvaluationOfPostFixExp {
    public static int postfix(String[] s){
        Stack<Integer> stack=new Stack<>();
        List<String> operator=new ArrayList<>();
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");
        operator.add("^");
        operator.add("%");
        for(int i=0;i<s.length;i++) //iteration from first as operator will be after values
        {
            if(operator.contains(s[i])){
                int val2=stack.pop(); //val2 is top as it is pushed after val1
                int val1=stack.pop();
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
            }
            else
            {
                stack.push(Integer.parseInt(s[i]));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        System.out.print(postfix(s));
        sc.close();
    }
}
