// BOJ 11724 연결 요소의 개수
// DFS 혹은 BFS를 통해 탐색해야하는 건 맞음
// 새로운 탐색이 몇 번 이루어지는 가를 세면 된다.
import java.io.*;
import java.util.*;

class Main {
    public static boolean[] arrived;
    public static int n;
    public static ArrayList<Integer>[] list;
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int test = Integer.parseInt(input[1]);
        arrived = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for(int i = 0; i < list.length; i++){
            list[i] = new ArrayList<>();
        }

        while(test-- > 0){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list[a].add(b);
            list[b].add(a);
        }
        int ret = 0;
        arrived[0] = true;

        for(int i = 1; i < list.length; i++ ){
            if(!arrived[i]){
                ret++;
                solve(i);
            }
        }

        System.out.println(ret);

    }

    public static void solve(int node) throws IOException{ // 탐색의 방법 : DFS
        // node : 현재 노드의 위치
        Iterator<Integer> itr = list[node].iterator();
        while(itr.hasNext()){
            int next = itr.next();
            if(arrived[next])
                continue;
            else {
                arrived[next] = true;
                solve(next);
            }
        }
    }
}