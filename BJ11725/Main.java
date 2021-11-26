package BJ11725;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    static List<Integer>[] list;
    static int[] parent;
    static boolean[] ck;
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); //노드 개수

        list = new ArrayList[N+1];
        parent = new int[N+1];
        ck = new boolean[N+1];
        
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
        
    }

    private static void dfs(int K){
        ck[K] = true;

        for(int i = 0; i < list[K].size(); i++){
            int node = list[K].get(i);

            if(!ck[list[K].get(i)]){
                parent[node] = K;
                dfs(node);
            }
        }

    }
    
}
