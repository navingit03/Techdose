package BitManipulation;
import java.util.Scanner;
public class largestPossiblePowerOf2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=0;
        for(int i=1;i<=n;i<<=1){
            k=i;
        }
        System.out.println(k);
    }
}
