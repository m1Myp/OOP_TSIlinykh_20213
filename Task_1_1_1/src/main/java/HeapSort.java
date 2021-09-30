package ru.nsu.fit.oop.lab1;


import java.util.Arrays;

public class HeapSort {
    /**
     * Return first elements (strange swap realization)
     *
     * @param x,y - elements
     */
    private static int returnFirst(int x, int y) {
        return x;
    }

    /**
     * Compares current id's element with his two children
     * if parent greater then children swap them. Repeats this action before end of heap
     *
     * @param arr heap
     * @param N   len of heap
     * @param id  index of element we should sift down
     */
    private static void siftDown(int[] arr, int id, int N) {
        int current = id;
        int left = id * 2 + 1;
        int right = id * 2 + 2;
        if (left < N && arr[current] > arr[left])
            current = left;
        if (right < N && arr[current] > arr[right])
            current = right;
        if (current != id) {
            arr[current] = returnFirst(arr[id], arr[id] = arr[current]);
            /*int t = arr[current];
            arr[current] = arr[id];
            arr[id] = t;*/
            siftDown(arr, current, N);
        }
    }

    /**
     * Find root of the tree (heap) preserving the heap invariant
     * Swap with elem in last position
     *
     * @param arr heap
     * @param len len of heap
     */
    private static void takeRoot(int[] arr, int len) {
        int last = len - 1;
        arr[0] = returnFirst(arr[last], arr[last] = arr[0]);
        /*int t = arr[0];
        arr[0] = arr[last];
        arr[last] = t;*/
        siftDown(arr, 0, len - 1);
    }

    /**
     * Heap sort of array
     *
     * @param arr array to sort
     */
    public static void heapSort(int[] arr) {
        int len = arr.length;
        for (int i = len-1; i >= 0; i--)
            siftDown(arr, i, len);

        while(len > 0) {
            takeRoot(arr, len);
            --len;
        }
        for(int j = 0; j < arr.length/2; ++j){
            arr[j] = returnFirst(arr[(arr.length-1)-j], arr[(arr.length-1)-j] = arr[j]);
        }
    }
}
