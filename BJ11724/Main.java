package BJ11724;

import java.util.*;

public class Main {
	
    static List<Integer>[] list;
    static boolean[] ck;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
        ck = new boolean[N+1];
        list = new ArrayList[N+1];
        
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

		int a = 0;
        int b = 0;
		for(int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        int result = 0;
        for(int i = 1; i <= N; i ++){
            if(!ck[i]){
                result++;
                dfs(i);
            }
        }

        System.out.println(result);
			
			
		
	}

    private static void dfs(int K){
        ck[K] = true;

        for(int node : list[K]){
            if(!ck[node]){
                dfs(node);
            }
        }
    }
}