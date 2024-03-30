package 백준.덱;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준10866_덱 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int x = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer command = new StringTokenizer(br.readLine());
            String cmd = command.nextToken();
            switch(cmd){
                case "push_front" :
                    x = Integer.parseInt(command.nextToken());
                    deque.offerFirst(x);
                    break;
                case "push_back" :
                    x = Integer.parseInt(command.nextToken());
                    deque.offerLast(x);
                    break;
                case "pop_front" :
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                case "pop_back" :
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty" :
                    if (deque.isEmpty()) {
                        sb.append(1).append("\n");
                    }else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front" :
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case "back" :
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
