package Array;
import java.util.Arrays;

public class CountInversionOfTwoArray {
    public static void main(String[] args) {
        //find number of element in arr1 lesser than curr i in arr2 
        int arr1[]={2,4,6,8};
        int arr2[]={1,5,7,8};
        //   ans[]={0,2,3,4}; as 0 element <1 ,2 element <5,3 element <7,4 element <8
        int p1=0,m=arr1.length,n=arr2.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {  
            while(p1<m && arr1[p1]<=arr2[i])
            {
                p1++;
            }
            ans[i]=p1;
        } 
        System.out.println(Arrays.toString(ans));
    }
}
