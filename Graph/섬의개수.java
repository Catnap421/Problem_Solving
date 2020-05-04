// BOJ 4963 섬의 개수
import java.io.*;
import java.util.*;

class Main {

    public static boolean arrived[][];
    public static int w, h, input[][];
    public static int[][] point = {{-1, 0},{-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while(!str.equals("0 0")){
            String[] arr = str.split(" ");
            w = Integer.parseInt(arr[0]);
            h = Integer.parseInt(arr[1]);
            input = new int[h][w];
            arrived = new boolean[h][w];

            for(int i = 0 ; i < h; i++){
                arr = br.readLine().split(" ");
                for(int j = 0; j < w; j++){
                    input[i][j] = Integer.parseInt(arr[j]);
                }
            }
            int cnt = 0; // 섬의 개수
            for(int y = 0; y < h; y++){
                for(int x = 0; x < w; x++){
                    if(input[y][x] == 1 && !arrived[y][x]){
                        cnt++;
                        solve(y, x);
                    }
                }
            }

            System.out.println(cnt);

            str = br.readLine();
        }
    }



    public static void solve(int y, int x) throws IOException{
        arrived[y][x] = true;
        for(int[] yx: point){
            int tempY = y + yx[0];
            int tempX = x + yx[1];
            if(0 <= tempY && tempY < h && 0 <= tempX && tempX < w){
                if(input[tempY][tempX] == 1 && !arrived[tempY][tempX]){
                    solve(tempY, tempX);
                }
            }
        }
    }
}