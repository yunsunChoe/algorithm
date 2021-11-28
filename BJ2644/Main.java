package BJ2644;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer>[] list;
    static boolean[] ck;
    static int result = -1;
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt(); //사람 수
        int target1 = scan.nextInt();
        int target2 = scan.nextInt();

        int m = scan.nextInt(); //부모 자식 관계 수

        ck = new boolean[n+1];
        list = new ArrayList[n+1];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            list[x].add(y);
            list[y].add(x);
        }
        result = 0;

        dfs(target1, target2, 0);

        System.out.println(result);

        
    }

    private static void dfs(int K, int target, int count){

        ck[K] = true;
        
        if(K == target){
            result = count;
            return;
        }
        for(int node : list[K]){
            if(!ck[node]){
                count++;
                dfs(node, target, count);
            }
        }
    }


}
