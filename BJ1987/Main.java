package BJ1987;

import java.util.Scanner;

public class Main {

    static int[] dc = {1,-1,0,0};
    static int[] dr = {0,0,1,-1};

    static int N;
    static int M;

    static String[][] board;

    static boolean[][] check;

    static int answer;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        
        board = new String[N][M];

        for(int i = 0; i < N; i ++){
            String str = scan.next();
            for(int j = 0; j < M; j++){
                board[i][j] = str.substring(j, j+1);
            }
        }

        check = new boolean[N][M];

        String first_str = board[0][0];
        check[0][0] = true;

        dfs(0,0,first_str,1);
        System.out.println(answer);
        
    }

    private static void dfs(int x, int y, String alphabet, int count){
        
        for(int i = 0; i < 4; i++){
            int dx = x + dr[i];
            int dy = y + dc[i];

            if(dx >= 0 && dy >= 0 && dx < N && dy < M){
                if(!check[dx][dy] && alphabet.indexOf(board[dx][dy]) < 0){
                    dfs(dx,dy,alphabet+board[dx][dy],count+1);
                }
            }
        }

        answer = Math.max(answer, count);

    }
    
}
