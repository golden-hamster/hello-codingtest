package 백준.스택의활용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준4949_균형잡힌세상 {

    // https://www.acmicpc.net/problem/4949

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if(input.equals(".")) break;

            String result = isBalanced(input) ? "yes" : "no";
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
