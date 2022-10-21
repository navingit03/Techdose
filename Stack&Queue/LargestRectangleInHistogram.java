//Leetcode 84. Largest Rectangle in Histogram
/*Finding 
1.The left[i] which less than curr heights[i]
2.The right[i] which less than curr heights[i]
3.Area of current height[i] will be from width(left to right)*(height[i])
4.The max of area is found by max area of area[i]
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int left[]=new int[n]; //left array to find less heigth of current height[i] in left side
        int right[]=new int[n]; //right array to find less heigth of current height[i] in right side
        Stack<Integer> stack=new Stack<>(); //stack is used to find left[i] and right[i]
        // finding the left[i] next less height of current height[i] on left side
        for(int i=0;i<n;i++){
            if(stack.empty())
            {
                left[i]=0; //if i=0 or no less height in left side
            }else{
                while(!stack.empty()&&heights[stack.peek()]>=heights[i]) //poping till next less element
                {
                    stack.pop();
                }
                left[i]=stack.empty()?0:stack.peek()+1; //left[i]=next less element on left side
            }
            stack.push(i);
        }
      
        //removing all element in stack to reuse the stack
        while(!stack.empty()) 
        {
            stack.pop();
        }
      
        // finding the left[i] next less height of current height[i] on left side
        for(int i=n-1;i>=0;i--)
        {
            if(stack.empty())
            {
                right[i]=n-1; //if i=n-1 or no less height in right side
            }else{
                while(!stack.empty()&&heights[stack.peek()]>=heights[i]) //poping till next less element
                {
                    stack.pop();
                }
                right[i]=stack.empty()?n-1:stack.peek()-1; //right[i]=next less element on right side
            }
            stack.push(i);
        }
        int max_area=0;
        for(int i=0;i<n;i++){
            max_area=Math.max(max_area,(heights[i]*(right[i]-left[i]+1))); //find area=(height[i])*(right[i]-left[i]+1)
        }
        return max_area;
    }
}
