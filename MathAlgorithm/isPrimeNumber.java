package MathAlgorithm;
import java.util.*;
public class isPrimeNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                System.out.print("N is not a prime number");
                System.exit(0);
            }
        }
        System.out.print("N is a prime number");
    }
}
