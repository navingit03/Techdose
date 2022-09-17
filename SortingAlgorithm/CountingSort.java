import java.util.*;
class CountingSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int output[]=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if(max<arr[i]) max=arr[i];
        }
        int freq[]=new int[max+1];//Frequency of given elements in array;
        for(int i=0;i<n;i++){
            freq[arr[i]]++;
        }
        for(int i=1;i<max+1;i++){
            freq[i]+=freq[i-1];//cumulative sum of frequency array
        }
        for(int i=n-1;i>=0;i--){
            output[freq[arr[i]]-1]=arr[i];
            freq[arr[i]]--;
        }
        for(int i=0;i<n;i++){
            System.out.print(output[i]+" ");
        }
    }
}
