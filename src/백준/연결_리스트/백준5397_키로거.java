package 백준.연결_리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class 백준5397_키로거 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder[] results = new StringBuilder[n];


        for (int i = 0; i < n; i++) {
            LinkedList<Character> linkedList = new LinkedList<>();
            ListIterator<Character> list = linkedList.listIterator();
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                switch (c) {
                    case '<':
                        if (list.hasPrevious()) {
                            list.previous();
                        }
                        break;
                    case '>':
                        if (list.hasNext()) {
                            list.next();
                        }
                        break;
                    case '-':
                        if (list.hasPrevious()) {
                            list.previous();
                            list.remove();
                        }
                        break;
                    default:
                        list.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char s : linkedList) {
                sb.append(s);
            }
            results[i] = sb;
        }

        for (StringBuilder result : results) {
            System.out.println(result.toString());
        }
    }
}
