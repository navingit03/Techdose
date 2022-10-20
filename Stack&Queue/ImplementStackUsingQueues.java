//Leetcode 225. Implement Stack using Queues
//We have to implement Stack(LIFO) using Queue(FIFO)
//We have to implement push(),pop(),top(),empty() of Stack
class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q=new LinkedList<>(); //creating a queue
    }
    
    public void push(int x) {
        q.add(x); //add is a operation of queue
        for(int i=0;i<q.size()-1;i++){
            q.add(q.poll()); //poll is a operation of queue to remove first element
        }
    }
    
    public int pop() {
        return q.poll(); //poll is a operation of queue to remove first element
    }
    
    public int top() {
        return q.peek(); //peek is a operation of queue to get first element
    }
    
    public boolean empty() {
        return q.isEmpty(); //isEmpty is a operation of queue
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
