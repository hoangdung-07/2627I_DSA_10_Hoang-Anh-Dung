package Week_3;
import java.io.*;
import java.util.*;

public class QueueUsingTwoStacks {
    private static Stack<Integer> st1 = new Stack<>();
    private static Stack<Integer> st2 = new Stack<>();

    public static void Enqueue(int x){
        st1.push(x);
    }

    public static void Movest1tost2(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
    }

    public static void Dequeue(){
        Movest1tost2();
        if (!st2.isEmpty()){
            st2.pop();
        }
    }

    public static void print(){
        Movest1tost2();
        if (!st2.isEmpty()){
            System.out.println(st2.peek());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                Enqueue(x);
            } else if (type == 2) {
                Dequeue();
            } else if (type == 3) {
                print();
            }
        }

        sc.close();
    }
}
