package BJ1655;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        ArrayList<Integer> num = new ArrayList<Integer>();

        for(int i = 1; i <= N; i++){
            num.add(scan.nextInt());
            Collections.sort(num);
            int idx = 0;
            if(i % 2 == 0){ //짝수면
                idx = i / 2-1;
            }else{ //홀수면
                idx = i / 2;
            }
            System.out.println(num.get(idx));
        }
    }
    
}
