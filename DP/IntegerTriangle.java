// BOJ 1932 정수 삼각형
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][N];
        int[][] cache = new int[N][N];

        // 입력 채워넣기
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < str.length; j++){
                input[i][j] = Integer.parseInt(str[j]);
            }
        }
        // cache[k][m] = [k][m] 위치에서 만들 수 있는 최대 합
        // cache[k][m] = Math.max(cache[k - 1][m - 1], cache[k - 1][m]) + input[k][m]
        cache[0][0] = input[0][0];
        for(int k = 1; k < N; k++){
            for(int m = 0; m <= k; m++){
                int max = cache[k - 1][m];
                if(m != 0)
                    max = Math.max(cache[k - 1][m - 1], cache[k - 1][m]);
                cache[k][m] = max + input[k][m];
            }
        }

        int ret = 0;
        for(int el : cache[N - 1]){
            ret = Math.max(ret, el);
        }
        System.out.println(ret);
    }
}