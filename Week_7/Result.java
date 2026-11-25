package Week_7;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static int cookies(int k, List<Integer> A) {
        int steps = 0;

        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        for(int num : A){
            min_heap.add(num);
        }

        while(min_heap.peek() <= k ){
            int count = min_heap.poll();
            if (count < k){
                min_heap.add(count + 2 * min_heap.peek());
                min_heap.poll();
            }
            steps +=1;

        }
        if(min_heap.peek() < k){
            return -1;
        }
        else return steps;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

