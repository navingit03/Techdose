//Leetcode 295. Find Median from Data Stream
//TC: O(n * log n) log n for operations in priorityqueue
//Using minheap and maxheap is a binary tree
// input 5 3 2 4 1 
// -> 1 2 3(maxheap)have top root val as 3(highest)
// -> 4 5(minheap) has top root val as 4(smallest)
class MedianFinder {
    PriorityQueue<Integer> maxheap; //It will have the last value of 1st half
    PriorityQueue<Integer> minheap; //It will have the first value of 2nd half
    public MedianFinder() {
        maxheap=new PriorityQueue(Collections.reverseOrder()); //priorityqueue(tree) in reverse has high value at top
        minheap=new PriorityQueue(); //priorityqueue(tree) in small value at top
    }
    
    public void addNum(int num) {
        maxheap.offer(num); //adding num in maxheap then maxvalue will be in top of the tree
        minheap.offer(maxheap.poll()); //adding maxheap top value in minheap
        if(minheap.size()>maxheap.size()) //if minheap has 1 value more than maxheap, add minheap first value in added in maxheap
        {
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size()) return (maxheap.peek()+minheap.peek())/2.0; //median of even size of twoheap then median of two value/2
        else return maxheap.peek(); //maxheaps top value is median
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
