// BOJ 2156 포도주 시식
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // D[n] = n개의 잔의 포도주가 있을 대, 최대로 마실 수 있는 양
        // X => 안 마신다, O => 마신다.
        // D[n - 1] + X
        // D[n - 2] + X,O
        // D[n - 3] + X,O,O
        // D[n - 4] + X,O,O,X
        int[] D = new int[N + 1];
        int[] input = new int[N + 1];
        for(int idx = 1; idx <= N; idx++)
            input[idx] = Integer.parseInt(br.readLine());

        D[1] = input[1];
        if(N > 1)
            D[2] = input[1] + input[2];
        for(int i = 3; i <= N; i++){
            int max = D[i - 1];
            max = Math.max(max, D[i - 2] + input[i]);
            max = Math.max(max, D[i - 3] + input[i - 1] + input[i]);
            //if(i != 3) max = Math.max(max, D[i - 4] + input[i - 2] + input[i - 1]);
            D[i] = max;
        }
        System.out.println(D[N]);
    }

}