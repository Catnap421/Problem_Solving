// BOJ 2309 일곱 난쟁이
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        int n = 9;
        while (n-- > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        int sum = 0;
        for(int el : list){
            sum += el;
        }
        for(int i = 0; i < 9 ; i++){
            sum -= list.get(i);
            for(int j = i + 1; j < 9; j++){
                sum -= list.get(j);
                if(sum == 100){
                    for(int k = 0 ; k < 9; k++){
                        if(k != i && k != j)
                            ret.add(list.get(k));
                    }
                    for(int el : ret)
                        System.out.println(el);
                    return;
                }
                sum += list.get(j);
            }
            sum += list.get(i);
        }


    }

}