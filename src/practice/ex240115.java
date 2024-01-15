package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex240115 {

    /**
     * 백준 2164 카드 게임
     * N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며,
     * 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
     * 이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다.
     * 우선, 제일 위에 있는 카드를 바닥에 버린다.
     * 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
     * 예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다.
     * 1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다.
     * 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.
     * N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
     */

    /**
     * n(카드의 개수) myQueue(카드 저장 자료구조)
     * for(카드의 개수만큼 반복)
     * {
     *  큐에 카드 저장하기
     * }
     * while(카드가 1장 남을 때 까지)
     * {
     *     맨 위의 카드를 버림: poll()
     *     맨 위의 카드를 가장 아래의 카드 밑으로 이동: poll() -> add()
     * }
     * 마지막으로 남은 카드 출력
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQue = new LinkedList<>();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            myQue.add(i);
        }
        while (myQue.size() > 1) {
            myQue.poll();
            myQue.add(myQue.poll());
        }

        System.out.println(myQue.poll());
    }
}
