package 백준.스택의활용;

import java.io.*;
import java.util.Stack;

public class 백준10799_쇠막대기 {

    /**
     * stack 에 아무값도 없음{ stack.push }
     * '(' 를 받으면 계속 stack.push
     * ')' 를 받으면 stack.pop
     *  1. 만약 바로 전 문자가 '(' 이면 레이저를 의미하므로 ans 에 stack 의 사이즈만큼 더함
     *  2. 만약 바로 전 문자가 ') 이면 그것은 단순히 닫힌 문자열(하나의 막대 조각을 가리킴)이므로 ans 에 +1 을 함
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int result = solve(input);
        bw.write(result + "\n");
        bw.flush();
    }

    public static int solve(String input){
        Stack<Character> stack = new Stack<>();
        char[] array = input.toCharArray();

        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
                continue;
            }
            if (input.charAt(i) == ')') {
                stack.pop();
                if (input.charAt(i - 1) == '(') {
                    result += stack.size();
                }else{
                    result++;
                }
            }
        }

        return result;
    }
}
