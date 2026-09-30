package Week_3;
import java.io.*;
import java.util.*;

public class SimpleTextEditor {
    private Stack<String> st = new Stack<>();
    private StringBuilder str = new StringBuilder();

    public void append(String s) {
        st.push(str.toString());
        str.append(s);
    }

    public void delete(int n) {
        st.push(str.toString());
        str.delete(str.length() - n, str.length());
    }

    public void print(int n) {
        System.out.println(str.charAt(n - 1));
    }

    public void undo() {
        if (!st.isEmpty()) {
            str = new StringBuilder(st.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int q = sc.nextInt();
        SimpleTextEditor editor = new SimpleTextEditor();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            switch (type) {
                case 1:
                    String s = sc.next();
                    editor.append(s);
                    break;
                case 2:
                    int kDelete = sc.nextInt();
                    editor.delete(kDelete);
                    break;
                case 3:
                    int kPrint = sc.nextInt();
                    editor.print(kPrint);
                    break;
                case 4:
                    editor.undo();
                    break;
            }
        }
        sc.close();
    }
}
