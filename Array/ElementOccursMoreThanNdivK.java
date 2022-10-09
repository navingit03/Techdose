//Finding the elements in array occuring >n/k times
//Using HashMap method
import java.util.*;
public class Main
{
    public static void freqGreaterthanndivK(int[] arr,int n,int k){
        List ans=new ArrayList<Integer>();
        Map<Integer,Integer> hash=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> a:hash.entrySet()){
            if(a.getValue()>(n/k)){
                ans.add(a.getKey());
            }
        }
        System.out.print(ans);
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
		    arr[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		freqGreaterthanndivK(arr,n,k);
	}
}
