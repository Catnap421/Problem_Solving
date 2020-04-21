// BOJ 13998 연속합2
import java.io.*;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] D = new int[N];
        int[] Dr = new int[N];
        D[0] = Integer.parseInt(input[0]);
        Dr[N - 1] = Integer.parseInt(input[N - 1]);
        for (int i = 1; i < N; i++) {
            if(D[i - 1] >= 0){
                D[i] = D[i - 1] + Integer.parseInt(input[i]);
            } else {
                D[i] = Integer.parseInt(input[i]);
            }
        }
        for (int j = N - 2; j > -1; j--) {
            if(Dr[j + 1] >= 0){
                Dr[j] = Dr[j + 1] + Integer.parseInt(input[j]);
            } else {
                Dr[j] = Integer.parseInt(input[j]);
            }
        }
        int ret = D[0];
        for(int el : D){
            ret = Math.max(ret, el);
        }
        for (int k = 1; k < N - 1; k++) {
            ret = Math.max(ret, D[k - 1] + Dr[k + 1]);
        }
        System.out.println(ret);
    }
}