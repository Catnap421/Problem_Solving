// 10819 차이를 최대호
// 모든 수열을 만든 후, 차이를 계산
// 8^8 * O(1)
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static int[] input;
    public static int[] ret;
    public static boolean[] choice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        input = new int[n];
        ret = new int[n];
        choice = new boolean[n];
        int idx = 0;
        while(st.hasMoreTokens()) input[idx++] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);
        System.out.println(solve(0));
    }
    public static int solve(int idx){
        boolean finished = true;
        for(boolean el : choice){
            if(!el) finished = false;
        }
        int sum = 0;
        if(finished){
            for(int i = 0; i < ret.length - 1; i++){
                sum += Math.abs(ret[i] - ret[i + 1]);
            }
            return sum;
        }

        for(int j = 0; j < ret.length; j++){
            if(choice[j])
                continue;
            else{
                choice[j] = true;
                ret[idx] = input[j];
                sum = Math.max(sum, solve(idx + 1));
                choice[j] = false;
            }
        }

        return sum;
    }



}