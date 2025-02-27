package Arrays;

import java.util.*;

public class UnionSorted {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {2, 3, 4, 5, 6, 7};
        List<Integer> list = new ArrayList<>();
        makeUnion(a, b, list);
        System.out.println(list);
    }

    private static void makeUnion(int[] a, int[] b, List<Integer> list) {
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                //Insert arr1
                if (!list.contains(a[i])) {
                    list.add(a[i++]);
                } else {
                    i++;
                }
            } else {
                //insert arr2
                if (!list.contains(b[j])) {
                    list.add(b[j++]);
                } else {
                    j++;
                }
            }
        }

        while (i < a.length) {
            //Insert Remaining values
            if (!list.contains(a[i])) {
                list.add(a[i++]);
            }
        }
        while (j < b.length) {
            //Insert Remaining values
            if (!list.contains(b[j])) {
                list.add(b[j++]);
            }
        }
    }
}
