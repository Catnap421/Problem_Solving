// BOJ 1107 리모컨
// 핵심은 가장 근접한 수를 만들고, 그 수와 타겟 수만큼의 차이를 더해주면 된다.
// 가장 근접한 수를 만들기 보단, 이 문제의 경우 수의 범위가 작으니 0~1000000의 숫자를 탐색하자
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tar = br.readLine();
        int target = Integer.parseInt(tar);
        int num = Integer.parseInt(br.readLine());
        HashSet<String> broken = new HashSet<>();
        if(num != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                broken.add(st.nextToken());
            }
        }
        int ret = Math.abs(target - 100);

        // 숫자를 만드는 과정

        for(int i = 0; i < 1000000; i++){
            char[] c = String.valueOf(i).toCharArray();
            boolean flag = false;
            for(int j = 0; j < c.length; j++){
                if(broken.contains(Character.toString(c[j]))) flag = true;
            }
            if(!flag)
                ret = Math.min(ret, Math.abs(i - target) + c.length);
        }

        System.out.println(ret);

    }

}