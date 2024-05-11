package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준1697_숨바꼭질 {
    /**
     * 수빈이의 위치 n, 동생의 위치 k 입력받기
     * 위치배열에 초기화하기
     * 걸린시간배열 초기화하기
     * 걸린시간배열에 수빈이의 현재위치 기록
     * 수빈이의 1초당 행동 경우의 수 {
     * x - 1 (왼쪽으로 한 칸)
     * x + 1 (오른쪽으로 한 칸)
     * X * 2 (오른쪽으로 x 칸)
     * }
     * depth(dist) 가 곧 걸리는 시간
     */

    static int n, k;
    static int[] dx;
    static int[] dist;   // 방문 기록, depth, dist, 걸린 시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());

        dist = new int[100001];

        Arrays.fill(dist, -1);
        dist[n] = 0; // 시작점에 방문기록, 걸린 시간 0


        if (n == k) { // 시작점이 같을 경우
            System.out.println(0);
            return;
        }

        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            dx = new int[]{-1, 1, cur};
            for (int i = 0; i < 3; i++) {
                int nx = cur + dx[i];


                if (nx < 0 || nx > 100000) continue;
                if (dist[nx] != -1) continue;

                if (nx == k) { // 움직여서 수빈이가 동생과 만난다면
                    System.out.println(dist[cur] + 1);
                    return;
                }

                dist[nx] = dist[cur] + 1; // 방문기록, depth, dist, 걸린 시간
                queue.offer(nx);

            }
        }
    }

}
