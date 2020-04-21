// BOJ 17404 RGB거리 2
import java.io.*;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] Dr = new int[N][3];
        int[][] Dg = new int[N][3];
        int[][] Db = new int[N][3];
        String[] zero = br.readLine().split(" ");
        Dr[0][0] = Integer.parseInt(zero[0]);
        Dr[0][1] = 1000;
        Dr[0][2] = 1000;
        Dg[0][0] = 1000;
        Dg[0][1] = Integer.parseInt(zero[1]);
        Dg[0][2] = 1000;
        Db[0][0] = 1000;
        Db[0][1] = 1000;
        Db[0][2] = Integer.parseInt(zero[2]);
        for (int i = 1; i < N; i++) {
            String[] input = br.readLine().split(" ");
            Dr[i][0] = Math.min(Dr[i - 1][1], Dr[i - 1][2]) + Integer.parseInt(input[0]);
            Dr[i][1] = Math.min(Dr[i - 1][0], Dr[i - 1][2]) + Integer.parseInt(input[1]);
            Dr[i][2] = Math.min(Dr[i - 1][0], Dr[i - 1][1]) + Integer.parseInt(input[2]);
            Dg[i][0] = Math.min(Dg[i - 1][1], Dg[i - 1][2]) + Integer.parseInt(input[0]);
            Dg[i][1] = Math.min(Dg[i - 1][0], Dg[i - 1][2]) + Integer.parseInt(input[1]);
            Dg[i][2] = Math.min(Dg[i - 1][0], Dg[i - 1][1]) + Integer.parseInt(input[2]);
            Db[i][0] = Math.min(Db[i - 1][1], Db[i - 1][2]) + Integer.parseInt(input[0]);
            Db[i][1] = Math.min(Db[i - 1][0], Db[i - 1][2]) + Integer.parseInt(input[1]);
            Db[i][2] = Math.min(Db[i - 1][0], Db[i - 1][1]) + Integer.parseInt(input[2]);
        }

        int red = Math.min(Dr[N - 1][1], Dr[N - 1][2]);
        int green = Math.min(Dg[N - 1][0], Dg[N - 1][2]);
        int blue = Math.min(Db[N - 1][0], Db[N - 1][1]);
        int min = Math.min(red, green);
        min = Math.min(min, blue);
        System.out.println(min);
    }
}