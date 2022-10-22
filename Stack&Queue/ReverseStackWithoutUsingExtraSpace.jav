import java.util.*;
class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            stack.push(i); //pushing form 1 to n
        }
        System.out.print("Stack before reverse : "+stack+"\n"); //Stack before reverse : [1, 2, 3, 4, 5, 6, 7]
        //method 1
        /*for(int i=0;i<stack.size()-1;i++){
            stack.add(i,stack.pop());
        }*/
        //method 2
        for(int i=0,mid=stack.size()/2,j=stack.size()-1;i<mid;i++,j--){
            stack.set(i,(stack.set(j,stack.get(i))));
        }
        System.out.print("Stack after reverse : "+stack); //Stack after reverse : [7, 6, 5, 4, 3, 2, 1]
    }
}
