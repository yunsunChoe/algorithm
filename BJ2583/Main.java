package BJ2583;

import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] ck;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    static int count;
    static Map<Integer, Integer> region;
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int N = scan.nextInt();
        int K = scan.nextInt();

        map = new int[M][N];
        ck = new boolean[M][N];

        for(int i = 0; i < K; i++){
            int firstX = scan.nextInt();
            int firstY = scan.nextInt();
            int lastX = scan.nextInt();
            int lastY = scan.nextInt();

            for(int j = firstY; j < lastY; j++){
                for(int l = firstX; l < lastX; l++){
                    map[M-j-1][l] = 1;
                }
            }

        }

        int regionNum = 0;
        region = new HashMap<Integer,Integer>();
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!ck[i][j]){
                    if(map[i][j] == 0){
                        region.put(regionNum,0);
                        dfs(i,j,M,N,regionNum);
                        regionNum++;
                    }
                    
                }
            }
        }

        List<Map.Entry<Integer,Integer>> sortList = new LinkedList<>(region.entrySet());
        sortList.sort((o1,o2) -> region.get(o1.getKey()) - region.get(o2.getKey()));
        System.out.println(regionNum);
        
        for(Map.Entry<Integer,Integer> entry : sortList){
            System.out.print(entry.getValue()+" ");
        }
/*
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2
*/ 

    }
    
    private static void dfs(int x, int y, int M, int N, int regionNum){
        ck[x][y] = true;
        region.put(regionNum,region.get(regionNum)+1);

        for(int i = 0; i < 4; i++){
            int dx = x + dr[i];
            int dy = y + dc[i];
            if(dx >= 0 && dy >= 0 && dx < M && dy < N){
                if(!ck[dx][dy]){
                    
                    int num = map[x][y];
                    int nextNum = map[dx][dy];

                    //같으면
                    if(num == 0 && nextNum == 0){
                        dfs(dx,dy,M,N,regionNum);
                    }
                }
            }
        }
    }
}
