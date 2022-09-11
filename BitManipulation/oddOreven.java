package BitManipulation;
import java.util.Scanner;

public class oddOreven {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print(((n&1)==0)?"even":"odd");
    }
}
