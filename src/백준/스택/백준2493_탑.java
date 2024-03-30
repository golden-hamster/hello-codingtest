package 백준.스택;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    int num;
    int height;

    Top(int num, int height) {
        this.num = num;
        this.height = height;
    }
}

public class 백준2493_탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().height >= height) {
                    sb.append(stack.peek().num + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(new Top(i, height));
//            if (stack.isEmpty()) {
//                sb.append("0 ");
//                stack.push(new Top(i, height));
//            }else{
//                while (true) {
//                    if (stack.isEmpty()) {
//                        sb.append("0 ");
//                        stack.push(new Top(i, height));
//                        break;
//                    }
//
//                    Top top = stack.peek();
//
//                    if (top.height >= height) {
//                        sb.append(top.num + " ");
//                        stack.push(new Top(i, height));
//                        break;
//                    }else{
//                        stack.pop();
//                    }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
