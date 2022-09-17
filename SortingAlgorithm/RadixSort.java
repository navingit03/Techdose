package SortingAlgorithm;
import java.util.*;
public class RadixSort {
    static int[] sort(int arr[],int n, int place){
        int hash[]=new int[10];//frequency array
        int output[]=new int[n];
        for(int i=0;i<n;i++){
            hash[(arr[i]/place)%10]++;
        }
        for(int i=1;i<10;i++){
            hash[i]+=hash[i-1];//cumulative
        }
        for(int i=n-1;i>=0;i--){
            output[hash[(arr[i]/place)%10]-1]=arr[i];//placing element in increaing order based on the place,s digit
            hash[(arr[i]/place)%10]--;//decrease the hash value after adding it into the output arr
        }
        arr=output;
        return arr;//returning arr
    }
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int arr[]=new int[n];
    int max=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
        if(max<arr[i]) max=arr[i];//To find max element in array
    }
    sc.close();
    int place=1;
    while(max/place>0){
        arr=sort(arr,n,place);//place represent the 10 power to divide to get the required digit place
        place*=10;
    }
    /*for(int place=1;(max/place)>0;place*=10){
        arr=sort(arr,n,place);
    }*/
    System.out.print(Arrays.toString(arr));
    }
}
