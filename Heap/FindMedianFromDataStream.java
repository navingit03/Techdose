//Leetcode 295. Find Median from Data Stream 
/*
if input is odd number of element (ex : 1,2,3,4,5,6,7)
  maxheap will have 4 3 2 1 (maxheap will have one element greater than minheap to find median(maxheap.peek() is median)
  minheap will have 5 6 7
  
if input is even number of element (ex : 1,2,3,4,5,6,7,8)
  maxheap will have 4 3 2 1 
  minheap will have 5 6 7 8
  median will be for even maxheap.peek() + minheap.peek() / 2 (median=4+5/2)
*/
class MedianFinder {
    //if input is 1,2,3,4,5,6,7,8 then 
    PriorityQueue<Integer> maxheap; //maxheap will have 4 3 2 1
    PriorityQueue<Integer> minheap; //minheap will have 5 6 7 8
    //median is ((maxheap.peek) 4 + (minheap.peek) 5) = 9/2 = 4.5 median
    public MedianFinder() {
        maxheap=new PriorityQueue(Collections.reverseOrder()); //creating a maxheap
        minheap=new PriorityQueue(); //creating a minheap
    }
    
    public void addNum(int num) 
    {
        maxheap.add(num); //first we need to add num in maxheap
        minheap.add(maxheap.poll()); //adding max value of maxheap in minheap(so that min heap will have greater numbers and max heap will have smaller value)
        if(minheap.size()>maxheap.size()) //maxheap need one element more than minheap if no of element is odd because maxheap.peek will be median
        {
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size()) return (maxheap.peek()+minheap.peek())/2.0; //4(maxheap.peek) + 5(minheap.peak) / 2 for 1-8 input
        else return maxheap.peek(); //if odd number of input then maxheap.peek() is median
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/* Question
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
*/
