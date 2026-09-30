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

class EqualStacks {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */
    public static int sumarray(List<Integer> h){
        int sum = 0;
        for (int i : h){
            sum+=i;
        }
        return sum;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        for (int i = h1.size() - 1; i >= 0; i--) st1.push(h1.get(i));
        for (int i = h2.size() - 1; i >= 0; i--) st2.push(h2.get(i));
        for (int i = h3.size() - 1; i >= 0; i--) st3.push(h3.get(i));

        int sum1 = sumarray(h1);
        int sum2 = sumarray(h2);
        int sum3 = sumarray(h3);

        while (sum1 != sum2 || sum2 != sum3 || sum1 != sum3){
            if (sum1 >= sum2 && sum1 >= sum3){
                sum1 = sum1 - st1.pop();
            }
            else if (sum2 >= sum1 && sum2 >= sum3){
                sum2 = sum2 - st2.pop();
            }
            else if (sum3 >= sum2 && sum3 >= sum1){
                sum3 = sum3 - st3.pop();
            }
        }
        return sum1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = EqualStacks.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
