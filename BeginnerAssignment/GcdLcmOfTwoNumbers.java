package BeginnerAssignment;

import java.util.Scanner;

public class GcdLcmOfTwoNumbers {
    static int GCD(int a,int b){
        if(a==0){
            return b;
        }else{
            return (GCD(b%a,a));
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int gcd=GCD(a,b);
        System.out.println("GCD " + gcd);
        System.out.print("LCM " + ((a*b)/gcd));

    }
}
