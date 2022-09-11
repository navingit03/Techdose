package BitManipulation;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class subSet {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<(1<<n);i++){
            List<Integer> nums=new ArrayList<>();
            for(int j=0;j<n;j++){
                if(((1<<j)&i)!=0){
                    nums.add(arr[j]);

                }
            }
            ans.add(nums);
            
        }
        System.out.print(ans+" ");


    }
}
