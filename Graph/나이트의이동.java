// BOJ 7562
import java.io.*;
import java.util.*;

class Main {
    public static boolean arrived[][];
    public static int targetX, targetY;
    public static int point[][] = {{-2, 1},{-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    public static ArrayDeque<Integer[]> deque = new ArrayDeque<>();
    public static ArrayDeque<Integer[]> temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-- > 0) {
            deque = new ArrayDeque<>();
            temp = new ArrayDeque<>();
            int n = Integer.parseInt(br.readLine());
            arrived = new boolean[n][n];
            String[] cur = br.readLine().split(" ");
            String[] target = br.readLine().split(" ");
            int curY = Integer.parseInt(cur[0]);
            int curX = Integer.parseInt(cur[1]);
            targetY = Integer.parseInt(target[0]);
            targetX = Integer.parseInt(target[1]);

            Integer[] next = {curY, curX};
            temp.add(next);
            boolean finished = false;
            int cnt;
            for (cnt = 0; !finished; cnt++) {
                deque = temp;
                temp = new ArrayDeque<>();
                while (!deque.isEmpty()) {
                    next = deque.pollFirst();
                    int y = next[0];
                    int x = next[1];
                    if(solve(y, x)) {
                        finished = true;
                        break;
                    }
                }
            }
            cnt -= 1; // 끝나고 한 번 더 돌기 때문에
            System.out.println(cnt);
        }

    }

    public static boolean solve(int y, int x){
        if(targetY == y && targetX == x)
            return true;

        for(int[] el : point){
            int ty = y + el[0];
            int tx = x + el[1];
            if(0 <= ty && ty < arrived.length && 0 <= tx && tx < arrived.length){
                if(!arrived[ty][tx]){
                    Integer[] next = {ty, tx};
                    arrived[ty][tx] = true;
                    temp.add(next);
                }
            }
        }

        return false;
    }
}