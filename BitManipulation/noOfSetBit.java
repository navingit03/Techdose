package BitManipulation;
import java.util.Scanner;

public class noOfSetBit {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        for(int i=1;i<=n;i<<=1){
            if((n&i)!=0){
                count++;
            }
        }
        System.out.print(count);
    }
}
