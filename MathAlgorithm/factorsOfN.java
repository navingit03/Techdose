package MathAlgorithm;

import java.util.*;

public class factorsOfN {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        List<Integer> factors =new ArrayList<>();
        for(int i=1;i*i<=N;i++){
            if(N%i==0){
                factors.add(i);
                if((i*i)!=N){
                    factors.add(N/i);
                }
            }
        }
        Collections.sort(factors);
        System.out.print(factors);
    }
}
