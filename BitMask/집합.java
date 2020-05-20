// BOJ 11723 집합

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int bit = 0b00000000000000000000; // 이진수 표현
        int x = 0b11111111111111111111;
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = "";
            int num = 0;
            for(int i = 0 ; st.hasMoreTokens(); i++){
                if(i == 0) op = st.nextToken();
                else num = Integer.parseInt(st.nextToken());
            }
            switch(op){
                case "add":
                    bit = bit | (1 << (num - 1));
                    break;
                case "remove":
                    int y = ~(1 << (num - 1)) & x;
                    bit = bit & y;
                    break;
                case "check":
                    if((bit & (1 << (num - 1))) != 0) wr.write("1\n");
                    else wr.write("0\n");
                    break;
                case "toggle":
                    if((bit & (1 << (num - 1))) != 0){
                        y = ~(1 << (num - 1)) & x;
                        bit = bit & y;
                    } else {
                        bit = bit | (1 << (num - 1));
                    }
                    break;
                case "all":
                    bit = bit | x;
                    break;
                default:
                    bit = bit & 0;
                    break;
            }
        }
        wr.flush();

    }

}