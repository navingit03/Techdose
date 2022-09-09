package SortingAlgorithm;
import java.util.*;
public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        List<Integer> output=new ArrayList<>();
        for(int i=0;i<n;i++){
            output.add(arr[i]);
            for(int j=output.size()-1;j>0;j--){
                if(output.get(j)>=output.get(j-1))
                break;
                Collections.swap(output,j-1,j);
            }
        }
        for(int k:output){
            System.out.print(k + " ");
        }
    }
}
