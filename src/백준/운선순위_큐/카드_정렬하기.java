package 백준.운선순위_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드_정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            heap.add(Integer.parseInt(br.readLine()));
        }

        if (n == 1) { // 카드 묶음이 하나인 경우
            System.out.println(0);
            return;
        }

        while (heap.size() >= 2) { // 카드 묶음이 둘 이상인 경우
            int first = heap.poll();
            int second = heap.poll();
            int sum = first + second;
            count += sum;
            heap.add(sum);
        }

        System.out.println(count);
    }
}
