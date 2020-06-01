import java.io.*;
import java.util.*;

class Main {
    public static LinkedList<Integer>[] list;
    public static int[] ret;
    public static LinkedList<Integer> arrived = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int edge = Integer.parseInt(br.readLine());
        ret = new int[edge + 1];
        list = new LinkedList[edge + 1];
        for(int i = 0 ; i <= edge; i++){
            list[i] = new LinkedList<>();
        }

        for(int i = 0 ; i < edge; i++) {
            String[] input = br.readLine().split(" ");
            Integer a = Integer.parseInt(input[0]);
            Integer b = Integer.parseInt(input[1]);
            list[a].add(b);
            list[b].add(a);
        }
        getLoop(1, -1);
        for(Integer el : arrived){
            getDistance(el, -1, 0);
        }
        for(int i = 1 ; i < ret.length; i++){
            wr.write(ret[i] + " ");
        }
        wr.flush();

    }
    public static boolean getLoop(Integer cur, Integer prev){
        // 만약 직전이 아닌 이전에 방문한 적이 있다면
        if(arrived.contains(cur)){
            while(arrived.get(0) != cur){
                arrived.pollFirst();
            }
            return true;
        }

        arrived.add(cur);
        Iterator<Integer> itr = list[cur].iterator();
        while(itr.hasNext()){
            Integer next = itr.next();
            if(next == prev) continue;
            if(getLoop(next, cur)) return true;
        }
        arrived.remove(cur);
        return false;
    }

    public static void getDistance(Integer cur, Integer prev, int cnt){
        ret[cur] = cnt;
        Iterator<Integer> itr = list[cur].iterator();
        while(itr.hasNext()){
            Integer next = itr.next();
            if(next == prev || arrived.contains(next)) continue;
            getDistance(next, cur, cnt + 1);
        }
    }
}