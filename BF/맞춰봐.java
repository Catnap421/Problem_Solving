// BOJ 1248 맞춰봐
import java.io.*;
import java.util.*;

class Main {
    public static char[][] arr;
    public static int[] ret;
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        arr = new char[N][N];
        ret = new int[N];
        // 수의 범위는 -10 ~ 10까지
        int idx = 0;
        for(int size = N; size > 0; size--) {
            for (int i = N - size; i < N; i++){
                arr[N - size][i] = input[idx++];
            }
        }

        fill(0);

    }
    public static boolean fill(int idx) throws IOException{
        // ret을 채우는 게 목표
        // ret이 끝
        // idx : ret[idx]의 인덱스 값
        boolean finished = false;
        boolean answer;
        if(idx == ret.length){
            for(int el : ret)
                wr.write(el + " ");
            wr.flush();
            finished = true;
            return finished;
        }

        int start, end;
        if(arr[idx][idx] == '0'){
            start = 10;
            end = 10;
        } else if(arr[idx][idx] == '-'){
            start = 0;
            end = 11;
        } else {
            start = 11;
            end = 0;
        }

        for(int i = -10 + start; i <= 10 - end; i++){
            answer = true;

            ret[idx] = i;
            for(int j = 0; j <= idx && answer; j++) {
                answer = answer && check(idx - j,idx);
            }
            if(answer){
                finished = finished || fill(idx + 1);
            }
            ret[idx] = 0;

            if(finished) break;
        }

        return finished;
    }

    public static boolean check(int start, int end){
        // start, end : arr[start][end]

        int sum = 0;
        boolean flag = true;
        for(int i = start; i <= end; i++){
            sum += ret[i];
        }

        switch(arr[start][end]){
            case '+':
                if(sum <= 0) flag = false;
                break;
            case '-':
                if(sum >= 0) flag = false;
                break;
            default:
                if(sum != 0) flag = false;
                break;
        }

        return flag;
    }

}