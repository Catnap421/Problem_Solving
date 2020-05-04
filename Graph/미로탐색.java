// BOJ 2178 미로 탐색
import java.io.*;
import java.util.*;

class Main {
    public static boolean arrived[][];
    public static int w, h;
    public static char[][] input;
    public static int D[][], point[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static ArrayDeque<Integer[]> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        h = Integer.parseInt(arr[0]);
        w = Integer.parseInt(arr[1]);
        input = new char[h][w];
        arrived = new boolean[h][w];
        D = new int[h][w];
        for(int i = 0; i < h; i++){
            input[i] = br.readLine().toCharArray();
        }
        arrived[0][0] = true;
        D[0][0] = 1;
        solve(0, 0);
        while(!deque.isEmpty()) {
            Integer[] next = deque.pollFirst();

            solve(next[0], next[1]);
        }
        System.out.println(D[h - 1][w - 1]);
    }



    public static void solve(int y, int x){
        if(y == h - 1 && x == w - 1){
            return;
        }

        for(int[] el : point){
            int ty = y + el[0];
            int tx = x + el[1];
            if(0 <= ty && ty < h && 0 <= tx && tx < w) {
                if(input[ty][tx] == '1' && !arrived[ty][tx]) {
                    Integer[] next = {ty, tx};
                    arrived[ty][tx] = true;
                    D[ty][tx] = D[y][x] + 1;
                    deque.addLast(next);
                }
            }
        }

    }
}