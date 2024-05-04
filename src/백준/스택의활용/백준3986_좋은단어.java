package 백준.스택의활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준3986_좋은단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < a; i++) {
            String input = br.readLine();
            if (isGood(input)) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isGood(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
