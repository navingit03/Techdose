package BuildDS;
public class StackUsingArray {
    static final int MAX_SIZE=30;
    static int s[]=new int[MAX_SIZE];
    static int topOfStack=-1;
    public static void push(int data)
    {
        topOfStack++;
        if(topOfStack==MAX_SIZE)
        {
            System.out.println("Stack is Full");
        }else{
        s[topOfStack]=data;
        }
    }
    public static int pop()
    {
        if(topOfStack<0)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        return s[topOfStack--];
        
    }
    public static int peek()
    {
        if(topOfStack<0)
        {
            System.out.println("Stack is Empty");
            return -1;
        }
        return s[topOfStack];
    }
    public static boolean isEmpty()
    {
        if(topOfStack<0)
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        push(5);
        push(7);
        push(8);
        System.out.println( pop() );
        System.out.println( peek() );
        System.out.println( pop() );
        System.out.println(isEmpty());
        System.out.println( pop() );
        System.out.println(isEmpty());
    }
}
