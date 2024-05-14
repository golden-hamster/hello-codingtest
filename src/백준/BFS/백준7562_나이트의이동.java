package 백준.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준7562_나이트의이동 {
    /**
     * 움직임 반경 -----> 시계방향대로
     * dx = {-1, -2, -2, -1, 1, 2, 2, 1}
     * dy = {-2, -1, 1, 2, 2, 1, -1, -2}
     *
     * 테스트케이스의 개수받음 tCase
     * tCase 만큼 반복{
     * 한 변의 길이 받기
     * 현재 있는 칸 받기
     * 이동하려고 하는 칸 받기
     * bfs(){
     * sb.append(dist).append("\n");
     *
     */


    static int[][] a;
    static int[][] dist;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int n, tx, ty;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());

        for (int c = 0; c < tCase; c++) {
            n = Integer.parseInt(br.readLine());
            a = new int[n][n];
            dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], -1);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            tx = Integer.parseInt(st.nextToken());
            ty = Integer.parseInt(st.nextToken());

//            if (curX == tx && curY == ty) {
//                sb.append(0).append("\n");
//            }
            bfs(curX, curY);
        }

        System.out.print(sb);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        dist[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nx, ny});

//                if (nx == tx && ny == ty) {
//                    sb.append(dist[nx][ny]).append("\n");
//                    return;
//                }
            }
        }
        sb.append(dist[tx][ty]).append("\n");
    }
}
