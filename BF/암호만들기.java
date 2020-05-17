// BOJ 1759 암호 만들기
import java.io.*;
import java.util.*;

class Main {
    public static String[] arr;
    public static String[] ret;
    public static int used;
    public static int n;
    public static String[] vowel = {"a","e","i","o","u"};
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        used = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        ret = new String[used];
        arr = br.readLine().split(" ");
        Arrays.sort(arr);
        solve(0, 0);
        wr.flush();
    }

    // a c i s t w
    public static void solve(int idx, int start)throws IOException{
        // idx : ret의 인덱스
        // start : 전체 배열에서 탐색 시작 위치
        if(idx == used){ // 모음 1개, 자음 2개 조건 부합하는 지 확인
            int count = 0; // vowel의 개수
            for(String word : ret){
                for(String el : vowel) if(el.equals(word)) count++;
            }
            if(count >= 1 && ret.length - count >= 2) {
                for(String word : ret) wr.write(word);
                wr.write("\n");
            }
            return;
        }

        for(int next = start; next < n; next++){
            ret[idx] = arr[next];
            solve(idx + 1, next + 1);
        }
    }
}