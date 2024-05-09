package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준7576_토마토 {

    /**
     * 전체 코드:
     *     상자의 크기를 입력받는다.
     *     상자에 들어있는 토마토의 상태를 입력받는다.
     *     bfs 함수를 호출하여 모든 토마토가 익는데 걸리는 일수를 구한다.
     *     모든 토마토가 익었는지 여부를 확인한다.
     *     모든 토마토가 익었으면 최소 일수를 출력하고, 그렇지 않으면 -1을 출력한다.
     *
     * bfs 함수:
     *     큐를 생성한다.
     *     모든 토마토의 위치를 확인하며, 익은 토마토의 위치를 큐에 넣는다.
     *     초기 일수를 0으로 설정한다.
     *     큐가 빌 때까지 다음을 반복한다:
     *         큐에서 하나의 토마토를 꺼낸다.
     *         이 토마토의 상하좌우를 확인하며 익지 않은 토마토를 찾는다.
     *         익지 않은 토마토를 발견하면:
     *             해당 토마토를 익은 토마토로 표시한다.
     *             익은 토마토의 위치와 함께 일수를 증가시켜 큐에 넣는다.
     *             현재 일수와 기존 최대 일수 중 더 큰 값을 최대 일수로 갱신한다.
     *     최대 일수를 반환한다.
     */
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우
    static int[][] a; // 2차원배열(상자)
    static int m, n; // 상자의 크기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = bfs();

        boolean isAllRipe = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    isAllRipe = false;
                    break;
                }
            }
            if(!isAllRipe) break;
        }

        if (isAllRipe) {
            System.out.println(days);
        }else{
            System.out.println(-1);
        }


    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        int days = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                int day = now[2];

                if (x >= 0 && y >= 0 && x < m && y < n) {
                    if (a[x][y] == 0) {
                        a[x][y] = 1; // 토마토가 익음을 표시
                        queue.add(new int[]{x, y, day + 1});
                        days = Math.max(days, day + 1); // 걸리는 일 수
                    }
                }
            }
        }
        return days;
    }

}
