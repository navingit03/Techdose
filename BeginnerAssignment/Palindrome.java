package BeginnerAssignment;
import java.util.*;
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int len=s.length();
        for(int i=0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                System.out.print("The given string is not a palindrome");
                System.exit(0);
            }
        }
        System.out.print("The given string is a palindrome");
    }
}
