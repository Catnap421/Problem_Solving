// 15663 N과 M(9)
import java.io.*;
import java.util.*;

class Main {
    public static int n, m;
    public static int[] arr;
    public static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n];
        check = new boolean[n];
        Integer[] ret = new Integer[m];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while(st.hasMoreTokens()){
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 여기까지 입력을 받는 과정

        solve(0, ret);
        // 문제 해결 과정

        Iterator<String> itr = set.iterator();
        while(itr.hasNext()){
            wr.write(itr.next());
            wr.write("\n");
        }
        wr.flush();
        // 문제에 대한 답 출력 과정
    }
    public static void solve(int idx, Integer[] ret){ // idx를 통해 현재 입력 받을 배열의 idx를 표현
        for(int i = 0; i < arr.length; i++){
            if(idx != m){ // idx가 ret.length가 될 때까진 탐색 후 재귀, 탐색 후 재귀를 반복
                if(!check[i]){
                    ret[idx] = arr[i];
                    check[i] = true;
                    solve(idx + 1, ret);
                    check[i] = false;
                }
                continue;
            } // idx가 ret.length가 되면(ret가 다 채워지면, set에 add)
            String str = "";
            for(Integer el : ret){
                str += el + " ";
            }
            set.add(str);
            return;
        }
    }
}