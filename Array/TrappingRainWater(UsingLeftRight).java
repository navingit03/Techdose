class Solution {
    public int trap(int[] height) {
        int left[]=new int[height.length]; //to store max height on left for curr index
        int right[]=new int[height.length]; //to store max height on right for curr index
        int max=-1; //initially max=-1
        for(int i=0;i<height.length;i++)
        {
            if(height[i]>max)
            {
                max=height[i];
            }
            left[i]=max;
        }
        max=-1;
        for(int i=height.length-1;i>=0;i--)
        {
            if(height[i]>max)
            {
                max=height[i];
            }
            right[i]=max;
        }
        int rainwater=0;
        for(int i=0;i<height.length;i++)
        {
            int min=Math.min(left[i],right[i]);
            rainwater+=(min-height[i]); //minus the height of building
        }
        return rainwater;
    }
}
