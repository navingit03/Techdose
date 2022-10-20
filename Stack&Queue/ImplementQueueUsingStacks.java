//Leetcode 232. Implement Queue using Stacks
//We have to implement Queue(FIFO) using Stack(LIFO)
//We have to implement add(),poll(),peek(),isEmpty() of Queue
class MyQueue {
    Stack<Integer> stack1; //Creating two stack for implementation of queue
    Stack<Integer> stack2;
    public MyQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x); //push(x) is a operation of stack to Implement add operation of queue
    }
    
    public int pop() {
        while(stack1.size()>1) //pushing element into stack2 till only one element is left in stack1
        {
            int top=stack1.pop(); //stack1.pop() is the top element of stack1
            stack2.push(top); //pushing the top element in the stack2
        }
        int front=stack1.pop(); //it is the front element(pop element of queue)
        while(!stack2.empty()) //adding all the value in stack2 back into stack1
        {
            stack1.push(stack2.pop());
        }
        return front; //returning the front element
    }
    
    public int peek() {
        while(stack1.size()>0) //pushing element into stack2 of stack1
        {
            stack2.push(stack1.pop());
        }
        int front=stack2.peek(); //peeking the front element
        while(!stack2.empty())
        {
            stack1.push(stack2.pop()); //adding all the value in stack2 back into stack1
        }
        return front; //returning the front element
    }
    
    public boolean empty() {
        return stack1.empty(); //checking if queue is empty using stack.empty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
