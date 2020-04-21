// BOJ 2133 타일 채우기
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] D = new long[31];
        D[2] = 3;
        for(int i = 4; i <= N; i += 2){
            D[i] = D[i - 2] * 3 + 2;
            for(int j = i - 4; j > 0 ; j -= 2){
                D[i] += D[j] * 2;
            }
        }
        System.out.println(D[N]);
    }
}