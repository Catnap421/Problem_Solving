// BOJ 11054 가장 긴 바이토닉 부분 수열
import java.io.*;

class Main {
    public static int[][] cache;
    public static String[] input;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cache = new int[N][2];
        // cache[n][0] = 가장 긴 증가하는 부분 수열
        // cache[n][1] = 가장 긴 감소하는 부분 수열
        // ret = Max(cache[n][0] + cache[n][1]) - 1; <= 자기 자신이 중복됨
        input = br.readLine().split(" ");
        makeSubsequence("increasing");
        makeSubsequence("decreasing");
        int ret = 0;
        for(int k = 0 ; k < N; k++){
            ret = Math.max(ret, cache[k][0] + cache[k][1]);
        }
        System.out.println(ret - 1);


    }
    public static void makeSubsequence(String type){
        if(type.equals("increasing")){
            for(int i = 0 ; i < cache.length; i++){
                int max = cache[i][0];
                for(int j = 0; j < i; j++){
                    if(Integer.parseInt(input[j]) < Integer.parseInt(input[i])){
                        max = Math.max(max, cache[j][0]);
                    }
                }
                cache[i][0] = max + 1;
            }
        } else { // 감소하는 부분 수열 -> 증가하는 부분 수열의 역순
            for(int i = cache.length - 1 ; i >= 0 ; i--){
                int max = cache[i][1];
                for(int j = cache.length - 1; j > i; j--){
                    if(Integer.parseInt(input[j]) < Integer.parseInt(input[i])){
                        max = Math.max(max, cache[j][1]);
                    }
                }
                cache[i][1] = max + 1;
            }
        }
    }
}