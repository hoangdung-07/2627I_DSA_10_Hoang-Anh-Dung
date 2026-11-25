public class Solution {

    public static int[] selectionsort(int n, int[] a) {
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            int tmp = a[i];
            a[i] = a[index];
            a[index] = tmp;
        }
        return a;
    }

    public int Solution(int n, int[] a) {
        selectionsort(n, a);
        int h_index = 0;
        for (int i = 0; i < n; i++) {
            int count = n - i;
            if (a[i] >= count) {
                h_index = Math.max(h_index, count);
            }
        }
        return h_index;
    }
}