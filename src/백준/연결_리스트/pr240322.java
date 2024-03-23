package 백준.연결_리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class pr240322 {

    /**
     * 백준 1406 - 에디터
     */

    /**
     * 문자열 입력받기(영어 소문자, <=100,000)
     * 입력할 명령어의 개수 M 입력받기
     * M 개의 명령어 입력받기(L, D, B, P)
     * 명령어 수행후 문자열 출력하기
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        List<Character> list = new LinkedList<>();
        for (char c : string.toCharArray()) {
            list.add(c);
        }
        int commandCounts = Integer.parseInt(br.readLine());
        ListIterator<Character> listIterator = list.listIterator(list.size());
        for (int i = 0; i < commandCounts; i++) {
//            String command = br.readLine();
//            char cmd = command.charAt(0):
            String[] command = br.readLine().split(" ");
            char cmd = command[0].charAt(0);

            switch (cmd) {
                case 'L' :
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                    break;
                case 'D' :
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                    break;
                case 'B' :
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                    break;
                case 'P' :
//                    char charToAdd = command.charAt(0);
                    char charToAdd = command[1].charAt(0);
                    listIterator.add(charToAdd);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
