// 1748 수 이어 쓰기1
// 9 - 1 90 - 10 900 - 100 9000 - 1000 90000 - 10000
// 1의 자리가 9개 10의 자리가 90개 ..을 이용하여,
// 해당 수의 자릿 수 -1 까지는 계산식으로 구하고(for문)
// 해당 수의 자릿 수는  (num - ((int)Math.pow(10, len - 1) - 1)) * len을 통해 계산
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int len = (num + "").length();
        int ret = 0;
        ret = (num - ((int)Math.pow(10, len - 1) - 1)) * len;
        for(int i = 1; i < len; i++){
            ret += i * 9 * (int)Math.pow(10, i - 1);
        }
        System.out.println(ret);

    }
}