package 백준.운선순위_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값_힙 {

    //https://www.acmicpc.net/problem/11286

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if (firstAbs == secondAbs) { // 절댓값이 같은 경우 음수 우선
                return o1 > o2 ? 1 : -1;
            }
            return firstAbs - secondAbs; // 절댓값이 작은 데이터 우선
        });

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (heap.isEmpty()) {
                    sb.append(0).append("\n");
                }else{
                    sb.append(heap.poll()).append("\n");
                }
            }else{
                heap.add(input);
            }
        }

        System.out.println(sb);
    }

}