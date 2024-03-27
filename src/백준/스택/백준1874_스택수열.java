package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준1874_스택수열 {

    /**
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            if (num <= arr[i]) {
                while (num <= arr[i]) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }else{
                if (stack.pop() > arr[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    sb.append("-\n");
                }
            }
        }
        if(result)System.out.println(sb.toString());
    }
}
