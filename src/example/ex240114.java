package example;

import java.util.Scanner;
import java.util.Stack;

public class ex240114 {

    /**
     * 백준 1874
     * 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
     * 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop)
     * 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
     * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써,하나의 수열을 만들 수 있다.
     * 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
     * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지,
     * 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.
     */

    /**
     * n(수열 개수) a[](수열 배열)
     * 수열 배열 채우기
     * for(n만큼 반복)
     * {
     *     if(오름차순 자연수 <= 현재 수열 값){
     *         while(값이 같아질 때까지)
     *         {
     *             push()
     *             (+)저장
     *         }
     *         pop()
     *         (-)저장
     *     }
     *     else(오름차순 자연수 > 현재 수열 값){
     *         pop()
     *         if(스택 pop 결과값 > 현재 수열 값) NO 출력
     *         else (-)저장
     *     }
     * }
     * if(-값을 출력한 적이 없으면) 저장한 값 출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            if (num <= a[i]){
                while(num <= a[i]){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }else {
                if (stack.pop() > a[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}
