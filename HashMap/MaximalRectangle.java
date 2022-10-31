//Leetcode 85. Maximal Rectangle
// refer Leetcode 84. Largest Rectangle in Histogram
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max=-1; //to find max area
        int r=matrix.length; //find no.of row
        int c=matrix[0].length; //find no.of col
        int height[]=new int[c]; //height array of cummulative previous row(like building height)
        int left[]=new int[c]; //to find index element which is previous smaller element + 1(as we need not include previous small height)
        int right[]=new int[c]; //to find index element which is next smaller element - 1(as we need not include next small height)
        Stack<Integer> stack=new Stack<>(); //stack to find next smaller and previous smaller
        for(int i=0;i<r;i++) //for every row we can have height as cumm sum but mat[i][j]=0 then height[j]=0
        {
            for(int j=0;j<c;j++) //to find cummsum for each row
            {
                if(i==0 || matrix[i][j]=='0') //if i=0 or mat[i][j]=0 then height[j]=0
                {
                    height[j]=matrix[i][j]-'0';
                }else
                {
                    height[j]=height[j]+matrix[i][j]-'0'; //cummsum of height
                }
            }
            for(int j=0;j<c;j++)
            {
                while(!stack.isEmpty() && height[stack.peek()]>=height[j]) //poping all greater element
                {
                    stack.pop();
                }
                left[j]=(stack.isEmpty()?0:stack.peek()+1); //if stack is empty, there is no prev small element , so 0 is left[j]
                //else index of previous small element +1 as we not need small element
                stack.push(j);
            }

            stack.clear();

            for(int j=c-1;j>=0;j--){
                while(!stack.isEmpty()&&height[stack.peek()]>=height[j]) //poping all greater element
                {
                    stack.pop();
                }
                right[j]=(stack.isEmpty()?c-1:stack.peek()-1);//if stack is empty, there is no next small element , so c-1 is right[j]
                //else index of next small element -1 as we not need small element index
                stack.push(j);
                
                max=Math.max(max,(right[j]-left[j]+1)*height[j]); // width=(right-left+1) height=h[j] -> area=width*h[j]
            }
            stack.clear();
        }
        return max;
    }
}
