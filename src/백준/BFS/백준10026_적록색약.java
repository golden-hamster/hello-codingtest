package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준10026_적록색약 {

    /**
     * R 탐색의 개수, B 개수, G 개수
     * R, G 개수, B 개수
     *
     * rgb 배열 돌면서 bfs
     *
     */

    static int n;
    static char[][] a;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, +1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = line.substring(j, j + 1).charAt(0);
            }
        }

        int p1 = area(); // 적록색약이 아닌 사람

        // 적록색약인 사람을 구하기 위한 방문 배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        // 적록색약은 초록과 빨강을 구분 못하므로 초록이면 빨강으로 바꿔줌
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'G') {
                    a[i][j] = 'R';
                }
            }
        }

        int p2 = area(); // 적록색약인 사람
        System.out.println(p1 + " " + p2);

    }

    public static int area() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        return cnt;
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visited[nx][ny] || a[x][y] != a[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }


}
