package Recursion;

import java.util.*;
public class StringMergeSort {

    public static void printArr(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort(String arr[], int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(String arr[], int start, int mid, int end) {
        String[] newArr = new String[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                newArr[k] = arr[i];
                k++;
                i++;
            } else {
                newArr[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            newArr[k] = arr[i];
            k++;
            i++;
        }

        while (j <= end) {
            newArr[k++] = arr[j++];
        }

        for (k = 0, i = start; k < newArr.length; i++, k++) {
            arr[i] = newArr[k];
        }

    }

    public static void main(String[] args) {
        String[] planets = { "sun", "earth", "mars", "mercury" };
        int start = 0;
        int end = planets.length-1;
        sort(planets, start, end);
        printArr(planets);
    }
}
