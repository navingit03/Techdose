class Solution {
    public void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    } 
    public int partion(int arr[],int left,int right){
        int pivot=arr[left];
        int i=left,j=right;
        while(i<j){
            do{
                i++;
            }while(pivot>arr[i]);
            do{
                j--;
            }while(pivot<arr[j]);
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,left,j);
        return j;
    }
    public int sort(int []arr,int left,int right,int target){
        int pivot=0;
        pivot=partion(arr,left,right);
        if(target==pivot)
              return arr[pivot];
        else if(target<pivot)
            return sort(arr,left,pivot,target);
        else
            return sort(arr,pivot+1,right,target);
    }
    public int findKthLargest(int[] array, int k) {
        int n=array.length;
        int arr[]=new int[n+1];
        for(int i=0;i<n;i++){
            arr[i]=array[i];
        }
        arr[n]=Integer.MAX_VALUE;
        return sort(arr,0,n,n-k);
    }
}
