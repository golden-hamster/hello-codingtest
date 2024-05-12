package 백준.BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준1012_배추 {

    static int n, m, k;
    static int[][] a;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tCase = Integer.parseInt(br.readLine());


        for (int c = 0; c < tCase; c++) {
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
             m = Integer.parseInt(st.nextToken()); // 가로길이
             n = Integer.parseInt(st.nextToken()); // 세로길이
             k = Integer.parseInt(st.nextToken()); // 배추의 개수

            a = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(a[i], 0);
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                a[y][x] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny] || a[nx][ny] != 1) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}
