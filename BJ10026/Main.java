package BJ10026;

import java.util.Scanner;

public class Main {
    static char[][] map;
    static boolean[][] ckNormal;
    static boolean[][] ckRG;
    static int NumRG;
    static int NumNormal;
    static int[] dc= {1,-1,0,0};
    static int[] dr= {0,0,-1,1};

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        map = new char[N][N];
        ckNormal = new boolean[N][N];
        ckRG = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String input = scan.next();
            for(int j = 0; j < N; j++){
                map[i][j] = input.charAt(j);
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
               if(!ckNormal[i][j]){
                    NumNormal++;
                   dfs(i,j,N);
               }
               if(!ckRG[i][j]){
                   NumRG++;
                   RGdfs(i,j,N);
               }
            }
            
        }


        System.out.println(NumNormal + " " + NumRG);

        
 
        
    }

    private static void dfs(int x, int y, int N){
        ckNormal[x][y] = true;

        for(int i = 0; i < 4; i++){
            int dx = x + dr[i];
            int dy = y + dc[i];

            if(dx >= 0 && dy >= 0 && dx < N && dy < N){
                if(!ckNormal[dx][dy]){
                    char color = map[x][y];
                    char nextColor = map[dx][dy];
                    if(color == nextColor){
                        dfs(dx,dy,N);
                    }
                }
            }
        }
        


    }

    private static void RGdfs(int x, int y, int N){
        ckRG[x][y] = true;

        for(int i = 0; i < 4; i++){
            int dx = x + dr[i];
            int dy = y + dc[i];

            if(dx >= 0 && dy >= 0 && dx < N && dy < N){
                if(!ckRG[dx][dy]){
                    char color = map[x][y];
                    char nextColor = map[dx][dy];
                    //같은색 
                    if(color == nextColor){
                        RGdfs(dx, dy, N);
                    }
                    //R=G || G=R
                    else{
                        if((color == 'R' && nextColor == 'G') || (color == 'G' && nextColor == 'R')){
                            RGdfs(dx, dy, N);
                        }
                    }
                }
            }
        }
    }
}
