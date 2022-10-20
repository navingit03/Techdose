//Leetcode 155. Min Stack (Design stack which supports getmin in O(1) time and space (Read editorial))
class MinStack {
    Stack<Integer> stack=new Stack<Integer>();
    int min;
    public MinStack() {
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<=min) //if curr val is less than min then we have to update min
        {
            stack.push(min); //pushing old min
            min=val; //updating the min=val
        }
        stack.push(val); //pushing all the val into stack
    }
    
    public void pop() {
        if(stack.pop()==min) //if pop val is equal to min the update min
        {
            min=stack.pop(); //min is updated and old min is poped
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
