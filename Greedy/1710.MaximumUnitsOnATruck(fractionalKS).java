class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]); //sorting based on unit per box
        int ans=0;
        for(int i=0;i<boxTypes.length;i++)
        {
            int currbox=boxTypes[i][0]; //curr no of boxes
            if(truckSize>=currbox) //if currSize<=truckSize
            {
                ans+=(currbox*boxTypes[i][1]); //we can fit all curr box
                truckSize-=currbox;
            }
            else if(truckSize>0 && currbox>truckSize) //else putting bal trucksize box in truck
            {
                ans+=truckSize*boxTypes[i][1];
                truckSize=0; //make it zero
            }
            if(truckSize==0) //if max reached break
            {
                break;
            }
        }
        return ans;
    }
}
