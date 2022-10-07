//Leetcode 4. Median of Two Sorted Arrays
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int pos=(n1+n2)/2;
        int arr[]=new int[n1+n2];
        int left1=0,left2=0,index=0;
        while(left1<n1&&left2<n2){
            if(nums1[left1]<nums2[left2]){
                arr[index++]=nums1[left1++];
            }else{
                arr[index++]=nums2[left2++];
            }
        }
        while(left1<n1)arr[index++]=nums1[left1++];
        while(left2<n2)arr[index++]=nums2[left2++];
        return ((n1+n2)%2!=0)?(double)arr[pos]:((double)(arr[pos]+arr[pos-1])/2);
    }
}
