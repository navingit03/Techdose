package BitManipulation;
import java.util.Scanner;
public class changeCases {
    static char tolower(char ch){
        return (char) (ch|(char)(1<<5));
    }
    static char toupper(char ch){
        return (char) (ch &(~(1<<5)));
    }
    static char togglecase(char ch){
        return (char) (ch ^ (1<<5));
    } 
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        char ch=sc.next().charAt(0);
        char ch1=sc.next().charAt(0);
        char ch2=sc.next().charAt(0);
        System.out.print(tolower(ch));
        System.out.print(toupper(ch1));
        System.out.print(togglecase(ch2));
    }
}
