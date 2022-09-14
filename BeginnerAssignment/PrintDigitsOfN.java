package BeginnerAssignment;
import java.util.Scanner;
public class PrintDigitsOfN {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int digit[]=new int[10];
        int index=0;
        while(N>0){
            digit[index]=(N%10);
            index++;
            N/=10;
        }
        for(int i=index-1;i>=0;i--){
            System.out.println(digit[i]);
        }
    }
}
