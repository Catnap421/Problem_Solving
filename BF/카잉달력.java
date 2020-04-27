// BOJ 6064 카잉달력
// M * i + x == N * j + y일 대를 구하면 된다.
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);
            long cnt = -1;
            int i = 0, j = 0;

            while(x + M * i <= N * M){
                if(x + M * i > y + N * j){
                    j++;
                }else if(x + M * i < y + N * j){
                    i++;
                }else {
                    cnt = x + M * i;
                    break;
                }
            }
            System.out.println(cnt);
        }


    }

}