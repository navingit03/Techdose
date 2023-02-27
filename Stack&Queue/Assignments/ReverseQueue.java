package Stack;
import java.util.*;
public class ReverseQueue {
    public static void reverse(Queue q)
    {
        if(q.isEmpty())
        {
            return;
        }
        int front=(int) q.peek();
        q.poll();
        reverse(q);
        q.offer(front);
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);
        reverse(q);
        System.out.println(q);
    }
}
