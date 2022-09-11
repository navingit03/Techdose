package BeginnerAssignment;
import java.util.Scanner;
public class Factorial {
    public long fact(long n){
        if(n<=1) return 1;
        else return n*fact(n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Factorial obj=new Factorial();
        long output=obj.fact(n);
        System.out.println(output);
    }
}
