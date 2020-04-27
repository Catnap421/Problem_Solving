// 15649 N과 M(1)
import java.io.*;
import java.util.LinkedList;

class Main {
    public static int n;
    public static int m;
    public static boolean[] isChecked;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        isChecked = new boolean[n + 1];
        LinkedList<Integer> list = new LinkedList<>();
        permutation(list);
    }
    public static void permutation(LinkedList<Integer> list){
        if(list.size() == m){
            for(int el: list)
                System.out.print(el + " ");
            System.out.println("");
        }

        for(Integer i = 1; i <= n; i++){
            if(!isChecked[i]){
                list.add(i);
                isChecked[i] = true;
                permutation(list);
                list.remove(i);
                isChecked[i] = false;
            }
        }

    }
}