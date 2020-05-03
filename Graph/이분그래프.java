// BOJ 1707 이분 그래프
// 바둑돌을 두는 문제랑 비슷하다
// 정점의 차수가 모두 2인 그래프가 있다고 했을때, 이 그래프의 정점의 개수가 홀수면 불가능
import java.io.*;
import java.util.*;

class Main {
    public static int[] arrived;
    public static ArrayList<Integer> past;
    public static int n;
    public static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            int test = Integer.parseInt(input[1]);
            arrived = new int[n + 1];
            list = new ArrayList[n + 1];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }

            while (test-- > 0) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                list[a].add(b);
                list[b].add(a);
            }

            boolean flag = false;
            Arrays.fill(arrived, -1);
            for(Integer i = 1; i <= n; i++) {
                if(arrived[i] != -1) continue;
                past = new ArrayList<>();
                past.add(i);
                arrived[i] = 0;
                flag = flag || solve(i);
                if(flag)
                    break;
            }
            if(flag) System.out.println("NO");
            else System.out.println("YES");
        }

    }

    public static boolean solve(int node) throws IOException{ // 탐색의 방법 : DFS
        // node : 현재 노드의 위치
        boolean flag = false;
        Iterator<Integer> itr = list[node].iterator();
        while(itr.hasNext()){
            Integer next = itr.next();
            if(arrived[next] != -1) {
                if(arrived[node] == arrived[next]) flag = true;
                continue;
            } else {
                arrived[next] = (arrived[node] + 1) % 2;
                past.add(next);
                flag = flag || solve(next);
                past.remove(next);
            }
        }
        return flag;
    }
}