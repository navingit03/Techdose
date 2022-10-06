//1011. Capacity To Ship Packages Within D Days
class Solution {
    public boolean ship(int mid,int []weights,int days){
        int currWeight=0; //initially the curr=0
        int daysTaken=1; //daysTaken=1
        for(int w:weights){
            currWeight+=w; //adding the weights[i] to curr
            if(currWeight>mid) //if the curr > mid
            {
                daysTaken++; //daysTaken++;
                currWeight=w; //curr=w because we need to find daysTaken for <mid.
            }
        }
        return daysTaken>days; //if daysTaken for mid(current mid) is > then days the we need to increase the mid value next time
    }
    public int shipWithinDays(int[] weights, int days) {
        int left=0,right=0;
        for(int i: weights){
            left=Math.max(left,i); //maximum value in the array
            right+=i; //sum of all elements in the weights
        }
        while(left<right){
            int mid=left+(right-left)/2; //finding middle value
            if(ship(mid,weights,days)) //if the daystaken for mid(weigths) per day is less than given days then we need to increase the mid value, so left=mid+1
            {
                left=mid+1;
            }else{
                right=mid; //making right = middle
            }
        }
        return right;
    }
}
