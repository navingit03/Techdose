package Stack;
import java.util.*;
public class ReverseStack {
    static Stack<Integer> st=new Stack<>();
    public static void insertAtBottom(int val)
    {
        if(st.size()==0)
        {
            st.push(val);
        }else{
            int top=st.pop();
            insertAtBottom(val);
            st.push(top);
        }
    }
    public static void reverse()
    {
        if(st.size()>0)
        {
            int top=st.pop();
            reverse(); //recursion call
            insertAtBottom(top);
        }
    }
    public static void main(String[] args) {
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        //method 1
        for(int i=0;i<st.size()-1;i++){
            st.add(i,st.pop());
        }
        //reverse();
        while(!st.isEmpty())
        {
            System.out.println(st.pop()+" ");
        }
    }
}
