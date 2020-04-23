// BOJ 3085 사탕 게임
import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

class Main {
    public static char[][] input;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        input = new char[N][N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine().toCharArray();
        }
        int ret = game(0, 0);
        System.out.println(ret);
    }

    public static int game(int y, int x){
        // 기저 사례 1: 해당 좌표가 끝인 경우(y == len - 1, x == len - 1) 리턴
        int len = input.length;
        if(y == len || x == len) return 0;

        int ret = 0;
        if(x != len - 1) {
            changeX(y, x);
            ret = Math.max(ret, counting());
            changeX(y, x);
        }
        if (y != len - 1) {
            changeY(y, x);
            ret = Math.max(ret, counting());
            changeY(y, x);
        }

        // 가로로 한 바퀴 탐색후,
        // 세로(y)를 1 증가 시킨 후, 가로 탐색

        ret = Math.max(ret, game(y, x + 1));
        if(x == 0){
            ret = Math.max(ret, game(y + 1, x));
        }
        return ret;
    }

    public static void changeX(int y, int x){
        char temp;
        temp = input[y][x];
        input[y][x] = input[y][x + 1];
        input[y][x + 1] = temp;
    }

    public static void changeY(int y, int x){
        char temp;
        temp = input[y][x];
        input[y][x] = input[y + 1][x];
        input[y + 1][x] = temp;
    }
    public static int counting(){
        Stack<Character> stack = new Stack<>();
        int ret = 0;
        int len = input.length;
        int maxH = 0;
        for(int i = 0; i < len; i++){
            int cnt = 0;
            for(int j = 0 ; j < len; j++){
                if(stack.isEmpty()){
                    stack.push(input[i][j]);
                } else if (stack.peek() == input[i][j]) {
                    stack.push(input[i][j]);
                } else {
                    cnt = stack.size();
                    while(!stack.isEmpty()) stack.pop();
                    stack.push(input[i][j]);
                    maxH = Math.max(maxH, cnt);
                }
            }
            cnt = stack.size();
            while(!stack.isEmpty()) stack.pop();
            maxH = Math.max(maxH, cnt);
        }

        int maxV = 0;
        for(int j = 0; j < len; j++){
            int cnt = 0;
            for(int i = 0 ; i < len; i++){
                if(stack.isEmpty()){
                    stack.push(input[i][j]);
                } else if (stack.peek() == input[i][j]) {
                    stack.push(input[i][j]);
                } else {
                    cnt = stack.size();
                    while(!stack.isEmpty()) stack.pop();
                    stack.push(input[i][j]);
                    maxV = Math.max(maxV, cnt);
                }
            }
            cnt = stack.size();
            while(!stack.isEmpty()) stack.pop();
            maxV = Math.max(maxV, cnt);
        }

        ret = Math.max(maxH, maxV);
        return ret;
    }
}