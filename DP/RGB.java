// BOJ 1149 RGB거리
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cache = new int[N + 1][3];
        // cache[n][0] = n번째까지 집을 칠하는 최소 비용 중 n번째 집은 R로 선택한 경우
        // cache[n][1] = G로 선택한 경우
        // cache[n][2] = B로 선택한 경우
        for(int i = 1; i <= N ; i++){
            String[] input = br.readLine().split(" ");
            cache[i][0] = Math.min(cache[i - 1][1], cache[i - 1][2]) + Integer.parseInt(input[0]);
            cache[i][1] = Math.min(cache[i - 1][0], cache[i - 1][2]) + Integer.parseInt(input[1]);
            cache[i][2] = Math.min(cache[i - 1][0], cache[i - 1][1]) + Integer.parseInt(input[2]);
        }
        int min = cache[N][0];
        min = Math.min(min, cache[N][1]);
        min = Math.min(min, cache[N][2]);
        System.out.println(min);
    }


}