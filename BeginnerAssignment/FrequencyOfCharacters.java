package BeginnerAssignment;
import java.util.*;
public class FrequencyOfCharacters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int freq[]=new int[26];
        String str=sc.next();
        for(int i=0;i<str.length();i++){
            freq[(int)str.charAt(i)-(int)'a']++;
        }
        for(int i=0;i<26;i++){
            char ch=(char)((char)i+'a');
            if(freq[i]>0){
                System.out.println(ch+"-"+freq[i]);
            }
        }

    }
}
