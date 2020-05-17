// BOJ 7576
import java.io.*;
import java.util.*;

class Main {
    public static boolean arrived[][];
    public static int w, h;
    public static Integer[][] input;
    public static int point[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static ArrayDeque<Integer[]> deque = new ArrayDeque<>();
    public static ArrayDeque<Integer[]> temp = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        w = Integer.parseInt(arr[0]);
        h = Integer.parseInt(arr[1]);
        input = new Integer[h][w];
        arrived = new boolean[h][w];
        for(int i = 0; i < h; i++){
           StringTokenizer st = new StringTokenizer(br.readLine(), " ");
           int idx = 0;
           while(st.hasMoreTokens()) input[i][idx++] = Integer.parseInt(st.nextToken());
        }
        int cnt;
        for(int i = 0 ; i < h; i++){
            for(int j = 0; j < w; j++){
                if(input[i][j] == 1){
                    Integer[] next = {i, j};
                    temp.add(next);
                }
            }
        }
        for(cnt = 0; !temp.isEmpty(); cnt++){
            deque = temp;
            temp = new ArrayDeque<>();
            while(!deque.isEmpty()) {
                Integer[] next = deque.pollFirst();
                int y = next[0];
                int x = next[1];
                solve(y, x);
            }
        }
        cnt -= 1; // 끝나고 한 번 더 돌기 때문에
        if(!finished()) cnt = -1;
        System.out.println(cnt);


    }

    public static boolean finished(){
        boolean flag = true;
        for(Integer[] line : input){
            for(Integer el : line) {
                if(el == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }


    public static void solve(int y, int x){
        for(int[] el : point){
            int ty = y + el[0];
            int tx = x + el[1];
            if(0 <= ty && ty < h && 0 <= tx && tx < w){
                if(input[ty][tx] == 0 && !arrived[ty][tx]){
                    Integer[] next = {ty, tx};
                    input[ty][tx] = 1;
                    temp.add(next);
                }
            }
        }
    }
}