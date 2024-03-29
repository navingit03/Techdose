//Leetcode - 88. Merge Sorted Array
//Merge two sorted array without extra space(using only nums1 length) - pointer approach
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,index=nums1.length-1;
        while(i>=0&&j>=0){
            if(nums1[i]<nums2[j])
                nums1[index--]=nums2[j--];
            else if(nums1[i]>=nums2[j])
                nums1[index--]=nums1[i--];
        }
        while(j>=0){
            nums1[index--]=nums2[j--];
        }
    }
}
