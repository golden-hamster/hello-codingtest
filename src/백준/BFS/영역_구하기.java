package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영역_구하기 {

    // https://www.acmicpc.net/problem/2583


    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int areaCount = 0;
    static int m;
    static int n;
    static List<Integer> sizeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         m = Integer.parseInt(st.nextToken());
         n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int a = y1; a < y2; a++) {
                for (int b = x1; b < x2; b++) {
                    visited[a][b] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    areaCount++;
                }
            }
        }
        Collections.sort(sizeList);
        StringBuilder sb = new StringBuilder();
        for (int size : sizeList) {
            sb.append(size).append(" ");
        }

        System.out.println(areaCount);
        System.out.println(sb);
    }

    public static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        visited[a][b] = true;
        int size = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(visited[nx][ny]) continue;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                size++;
            }
        }
        sizeList.add(size);
    }
}
