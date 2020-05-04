// BOJ 2667 단지 번호 붙이기
import java.io.*;
import java.util.*;

class Main {

    public static boolean arrived[][];
    public static char[][] input;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int[][] point = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrived = new boolean[N][N];
        input = new char[N][N];

        for(int i = 0 ; i < N; i++){
            input[i] = br.readLine().toCharArray();
        }
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                if(input[y][x] == '1' && !arrived[y][x]){
                    cnt = 0;
                    solve(y, x);
                    list.add(cnt);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(Integer el : list){
            System.out.println(el);
        }

    }



    public static void solve(int y, int x) throws IOException{
        arrived[y][x] = true;
        cnt++;
        for(int[] yx: point){
            int tempY = y + yx[0];
            int tempX = x + yx[1];
            if(0 <= tempY && tempY < N && 0 <= tempX && tempX < N){
                if(input[tempY][tempX] == '1' && !arrived[tempY][tempX]){
                    solve(tempY, tempX);
                }
            }
        }
    }
}