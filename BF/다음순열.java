// 10972 다음 순열
// 선택 자료구조: 스택, 리스트
// 방법 1: 모든 순열을 만들어보고, 입력값과 비교하여 다음 순열을 출력(1<= N <= 10000이기 때문에 불가능)
// 방법 2: 다음 순열은 현재 순열의 1의 자리수부터 오름차순인 수를 다 제거한 뒤에, 이후 올 수를 계산 해 주면 된다.
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static boolean[] check;
    public static int[] input;
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        input = new int[N];
        check = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) stack.push(Integer.parseInt(st.nextToken()));
        check[stack.peek()] = true;
        list.add(stack.pop());
        while(!stack.isEmpty() && stack.peek() > list.peekLast()) {
            int el = stack.pop();
            list.add(el);
            check[el] = true;
        }
        cnt = stack.size();
        if(stack.isEmpty()) System.out.println(-1);
        else solve(stack);


    }
    public static void solve(Stack<Integer> stack){
        boolean finished = true;
        for(int i = 0; i < check.length; i++){
            if(check[i]) finished = false;
        }
        if(finished) {
            Iterator<Integer> itr = stack.iterator();
            while(itr.hasNext()) System.out.print(itr.next() + " ");
            return;
        }

        for(int i = 1 ; i <= input.length; i++){
            if(stack.size() == cnt){
                cnt = -1;
                check[stack.peek()] = true;
                i = stack.pop() + 1;
            }
            if(check[i]) {
                stack.push(i);
                check[i] = false;
                solve(stack);
            }
        }

    }

}