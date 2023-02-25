package BuildDS;
public class QueueUsingArray {
    static final int MAX_SIZE=30;
    static int arr[]=new int[MAX_SIZE];
    static int front=0,rear=-1;
    public static void enqueue(int val)
    {
        rear++;
        if(rear==MAX_SIZE)
        {
            System.out.println("Queue is Full");
        }else
        {
            arr[rear]=val;
        }
    }
    public static int dequeue()
    {
        if(rear==-1)
        {
            throw new IndexOutOfBoundsException("Queue is Empty");
        }
        int temp=arr[0];
        for(int i=0;i<rear;i++)
        {
            arr[i]=arr[i+1];
        }
        rear--;
        return temp;
    }
    public static void main(String[] args) {
        enqueue(7);
        enqueue(8);
        enqueue(9);
        enqueue(10);
        enqueue(11);
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
    }
}
