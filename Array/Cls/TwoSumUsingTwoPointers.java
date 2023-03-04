package Array;
import java.util.*;
public class TwoSumUsingTwoPointers {
    public static void main(String[] args) {
        int arr[]={5,7,12,15,1,3,6,9};
        Arrays.sort(arr);
        //arr become 1,3,5,6,7,9,12,15
        int target=15;
        int p1=0,p2=arr.length-1;
        while(p1<p2)
        {
            int sum=arr[p1]+arr[p2];
            if(sum==target)
            {
                System.out.println(arr[p1]+" "+arr[p2]+" true");
                return;
            }
            if(sum>target)
            {
                p2--; //since its sorted p2 points to large no
            }else
            {
                p1++;
            }
        }
        System.out.println("false");
    }
}
