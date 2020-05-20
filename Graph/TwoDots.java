// BOJ 16929 Two Dots
import java.io.*;
import java.util.*;

class Main {
    public static boolean[][] visited;
    public static char[][] board;
    public static int[][] move =   {{-1,0},{0,1},{1,0},{0,-1}};
    public static ArrayDeque<Integer[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        board = new char[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            board[i] = br.readLine().toCharArray();
        }
        boolean flag = false;
        for(int i = 0; i < n && !flag; i++){
            for(int j = 0 ; j < m && !flag; j++){
                if(visited[i][j])
                    continue;
                else {
                    visited[i][j] = true;
                    bfs(i, j, i, j, board[i][j]);
                    while(!q.isEmpty()){
                        Integer[] next = q.pollFirst();
                        int y = next[0];
                        int x = next[1];
                        int py = next[2];
                        int px = next[3];
                        if(bfs(y, x, py, px, board[y][x])){
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }
        if(flag) System.out.println("Yes");
        else System.out.println("No");
    }
    public static boolean bfs(int y, int x, int py, int px, char ch){
        // 쭉 돌다가 만나는 방법
        for(int i = 0 ; i < 4; i++){
            int ty = y + move[i][0];
            int tx = x + move[i][1];
            if(ty == py && tx == px) continue;
            if(0 <= ty && ty < board.length && 0 <= tx && tx < board[0].length){
                if(visited[ty][tx] && board[ty][tx] == ch){
                    return true;
                } else if(board[ty][tx] == ch) {
                    Integer[] next = {ty, tx, y, x};
                    visited[ty][tx] = true;
                    q.addLast(next);
                }
            }
        }
        return false;

    }
}