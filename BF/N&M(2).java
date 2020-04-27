// 15650 N과 M(2)
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
        combination(list);
    }
    public static void combination(LinkedList<Integer> list){
        if(list.size() == m){
            for(int el: list)
                System.out.print(el + " ");
            System.out.println("");
        }
        Integer i;
        if(list.isEmpty())
            i = 1;
        else
            i = list.peekLast();
        for(; i <= n; i++){
            if(!isChecked[i]){
                list.add(i);
                isChecked[i] = true;
                combination(list);
                list.remove(i);
                isChecked[i] = false;
            }
        }

    }
}