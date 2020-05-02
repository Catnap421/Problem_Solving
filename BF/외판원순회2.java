import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static int[][] input;
    public static boolean[] choice;
    public static int[] ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        input = new int[n][n];
        choice = new boolean[n];
        ret = new int[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while(st.hasMoreTokens()) input[i][idx++] = Integer.parseInt(st.nextToken());
        }
        choice[0] = true;
        System.out.println(solve(0));

    }
    public static int solve(int start){
        boolean finished = true;
        for(boolean el : choice) if(!el) finished = false;
        int sum = 987654321;
        if(finished){
            sum = 0;
            int cnt = ret.length;
            int idx = 0;
            while(cnt-- > 0){
                if(input[idx][ret[idx]] == 0) sum = 987654321;
                sum += input[idx][ret[idx]];
                idx = ret[idx];
            }
            return sum;
        }

        for(int end = 1; end < ret.length; end++){
            if(choice[end] || start == end || input[start][end] == 0)
                continue;
            else{
                ret[start] = end;
                choice[end] = true;
                sum = Math.min(sum, solve(end));
                choice[end] = false;
                ret[start] = 0;
            }
        }
        return sum;
    }

}