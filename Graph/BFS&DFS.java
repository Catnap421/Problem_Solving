// BOJ 1260 DFS&BFS
import java.io.*;
import java.util.*;

class Main {
    public static boolean[] arrived;
    public static int n;
    public static ArrayList<Integer>[] list;
    public static ArrayDeque<Integer> deque = new ArrayDeque<>();
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        list = new ArrayList[n + 1];
        arrived = new boolean[n + 1];
        for(int i = 0; i < list.length; i++){
            list[i] = new ArrayList<>();
        }
        int edge = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2]);

        while(edge-- > 0){
            String[] nodes = br.readLine().split(" ");
            int i = Integer.parseInt(nodes[0]);
            int j = Integer.parseInt(nodes[1]);
            list[i].add(j);
            list[j].add(i);
        }
        for(int j = 0; j < list.length; j++){
            Collections.sort(list[j]);
        }
        Arrays.fill(arrived, true);
        for(int i = 0 ; i < list.length; i++) if(list[i].size() != 0) arrived[i] = false;
        arrived[start] = true;
        solveDFS(start);
        wr.newLine();

        Arrays.fill(arrived, false);
        for(int i = 0 ; i < list.length; i++) if(list[i].size() != 0) arrived[i] = false;
        arrived[start] = true;
        solveBFS(start);
        wr.flush();
    }

    public static void solveDFS(int node) throws IOException{
        // node : 현재 노드의 위치
        // 기저 사례 1: 만약 arrived가 모두 true면 결과값을 출력하고 리턴
        wr.write(node + " ");
        boolean finished = true;
        for(boolean el : arrived) if(!el) finished = false;
        if(finished) return;

        Iterator<Integer> itr = list[node].iterator();
        while(itr.hasNext()){
            int next = itr.next();
            if(arrived[next])
                continue;
            else {
                arrived[next] = true;
                solveDFS(next);
            }
        }

    }

    public static void solveBFS(int node) throws IOException{
        wr.write(node + " ");
        boolean finished = true;
        for(boolean el : arrived) if(!el) finished = false;
        if(finished) return;

        Iterator<Integer> itr = list[node].iterator();
        while(itr.hasNext()){
            int next = itr.next();
            if(arrived[next])
                continue;
            else {
                arrived[next] = true;
                deque.addLast(next);
            }
        }
        while(!deque.isEmpty()) {
            int next = deque.poll();
            solveBFS(next);
        }
    }

}