import java.util.Scanner;

public class complimentOfN {
    public static void main(String[] args) {
        Scanner sc=new Scanner((System.in));
        int n=sc.nextInt();
        System.out.println("1s Compliment" + (~n));
        System.out.println("2s Compliment" + (~n+1));
    }
}
