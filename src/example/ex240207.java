package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class ex240207 {

    /**
     * 백준 11286 절댓값 힙 구현하기
     * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
     * 배열에 정수 x (x ≠ 0)를 넣는다.
     * 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
     * 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
     * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
     */

    /**
     * n(질의 요청 개수)
     * 우선순위 큐 선언
     *  - 절댓값 기준으로 정렬되도록 설정하기
     *  - 단, 절댓값이 같으면 음수 우선 정렬하기
     *  for(n만큼 반복)
     *  {
     *      요청이 0일 때: 큐가 비어 있으면 0, 비어 있지 않으면 큐의 front값 출력하기(poll())
     *      요청이 1일 때: 새로운 데이터를 우선순위 큐에 더하기(add())
     *  }
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) { // 절댓값이 같은 경우 음수 우선
                return o1 > o2 ? 1 : -1;
            }
            return first_abs - second_abs; //  절댓값 작은 데이터 우선
        });

        for (int i = 0; i < n; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (myQueue.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(request);
            }
        }
    }
}
