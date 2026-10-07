package Week_4;

import java.io.*;
import java.util.*;

public class CorrectnessInvariant {

    public static void insertionsort(int n, List<Integer> a){
        for(int i = 1 ; i < n ; i++){
            int temp = a.get(i);
            int j = i - 1;
            while (j >= 0){
                if(a.get(j) > temp){
                    a.set(j+1, a.get(j));
                    a.set(j, temp);
                }
                j--;
            }
            temp = a.get(j+1);
        }
        for(int num : a){
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0 ; i<n ; i++){
            int a = sc.nextInt();
            nums.add(a);
        }
        insertionsort(n, nums);

    }
}