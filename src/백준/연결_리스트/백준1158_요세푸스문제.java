package 백준.연결_리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준1158_요세푸스문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        sb.append("<");
        while (!list.isEmpty()) {
            for (int i = 0; i < k; i++) {
                if (i == k - 1) { // k 번 째 사람일 때
                    if (list.size() == 1) {
                        sb.append(list.remove());
                    } else {
                        sb.append(list.remove() + ", ");
                    }
                } else {
                    list.add(list.remove());
                }
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
