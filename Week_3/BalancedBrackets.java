package Week_3;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BalancedBrackets {

    public static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        if (s.length() % 2 != 0) {
            return "NO";
        }

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (!st.isEmpty()) {
                    if (c == ')' && st.peek() == '(') {
                        st.pop();
                    } else if (c == ']' && st.peek() == '[') {
                        st.pop();
                    } else if (c == '}' && st.peek() == '{') {
                        st.pop();
                    }
                } else {
                    return "NO";
                }
            }
        }
        if (st.isEmpty()) {
            return "YES";
        }
        return "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = BalancedBrackets.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}