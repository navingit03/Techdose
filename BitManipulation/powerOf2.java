package BitManipulation;
import java.util.Scanner;

class Java{
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print((n&n-1)==0);
    }
}