//Merge two sorted array without extra space
import java.util.*;
class HelloWorld {
    public static void sortArrayWithoutSpace(int[] arr1,int m,int []arr2,int n){
        for(int i=n-1;i>=0;i--) //Traversing arr2 from last
        {
            int last=arr1[m-1]; //storing last element of arr1
            int j=m-2;
            for(j=m-2;j>=0&&(arr1[j]>arr2[i]);j--) if arr1[j]>arr2[i](right shifting elements in arr1 till smaller element is found), from m-2 because m-2 is stored in last
            {
                arr1[j+1]=arr1[j]; //right shifting
            }
            if(j!=m-2||last>arr2[i]){
                arr1[j+1]=arr2[i]; //arr1[j+1] is the next greater element than arr2[i]
                arr2[i]=last; //storing arr2[i] = last element in arr1
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int arr1[]=new int[m];
        for(int i=0;i<m;i++){
            arr1[i]=sc.nextInt();
        }
        int n=sc.nextInt();
        int arr2[]=new int[n];
        for(int i=0;i<n;i++){
            arr2[i]=sc.nextInt();
        }
        sortArrayWithoutSpace(arr1,m,arr2,n);
        System.out.print(Arrays.toString(arr1));
        System.out.print(Arrays.toString(arr2));
    }
}
