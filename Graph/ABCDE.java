// BOJ 13023 ABCDE
// 그래프 문제
// 총 5개의 정점을 중복되는 간선을 거치지 않고 도달할 수 있으면 1
// 그래프 표현을 어떻게 할 것 인가? 1. 인접 행령 2. 인접 리스트
// 2의 경우, 이 문제는 방향이 정해져 있지 않기 때문에 단일 리스트로만 표현하기엔 문제가 있다.
// ArrayList[]을 만들어서 표현할까? -> ok
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

class Main {
    public static boolean[] arrived;
    public static int n;
    public static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        arrived = new boolean[n];
        list = new ArrayList[n];
        for(int j = 0 ; j < n; j++){
            list[j] = new ArrayList<>();
        }
        int m = Integer.parseInt(input[1]);
        while(m-- > 0){
            input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            list[i].add(j);
            list[j].add(i);
        }
        boolean ret = false;
        for(int i = 0; i < n; i++){
            arrived[i] = true;
            ret = ret || solve(1, i);
            arrived[i] = false;
        }
        if(ret) System.out.println(1);
        else System.out.println(0);
    }

    public static boolean solve(int cnt, int cur){
        // cnt : 지금까지 도달한 정점의 수
        // cur : 현재 정점 위치
        if(cnt == 5){
            return true;
        }
        boolean ret = false;
        Iterator<Integer> itr = list[cur].iterator();
        while(itr.hasNext()){
            int next = itr.next();
            if(arrived[next])
                continue;
            else{
                arrived[next] = true;
                ret = ret || solve(cnt + 1, next);
                arrived[next] = false;
            }
        }

        return ret;
    }
}