// 가장 큰 증가 부분 수열(BIS)
// 가장 긴 증가 부분 수열(LIS)과 비슷한 문제
// 차이는 LIS는 수열의 길이를 저장했다면, BIS는 cache[i]를 포함하는 최대합을 저장하면 된다.
// BOJ 11055 가장 큰 증가 부분 순열
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] cache = new int[N];
        cache[0] = Integer.parseInt(input[0]);
        for(int i = 1; i < N; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(Integer.parseInt(input[j]) < Integer.parseInt(input[i])){
                    max = Math.max(max, cache[j]);
                }
            }
            cache[i] = max + Integer.parseInt(input[i]);
        }
        int max = 0;
        for(int el : cache){
            max = Math.max(max, el);
        }
        System.out.println(max);
    }

}