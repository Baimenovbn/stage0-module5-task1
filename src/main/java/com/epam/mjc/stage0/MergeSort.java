package com.epam.mjc.stage0;

public class MergeSort {
    static private void merge(int[] arr, int[] l, int[] r, int left, int right) {
        int i, j, k;
        i = j = k = 0;

        while (i < left && j < right) {
            while (i < left && j < right) {
                if (l[i] <= r[j]) {
                    arr[k++] = l[i++];
                }
                else {
                    arr[k++] = r[j++];
                }
            }
            while (i < left) {
                arr[k++] = l[i++];
            }
            while (j < right) {
                arr[k++] = r[j++];
            }
        }
    }

    static public void sort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        int[] l = new int[mid];
        int[] r = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }

        for (int i = mid; i < arr.length; i++) {
            r[i - mid] = arr[i];
        }

        sort(l);
        sort(r);

        merge(arr, l, r, mid, arr.length - mid);
    }
}
