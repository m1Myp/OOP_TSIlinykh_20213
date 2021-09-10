import java.util.Arrays;

public class HeapSort {
    /**
     * Take element from heap with index id if this element is smaller then its parent swap them
     *
     * @param arr - heap
     * @param id  - sifting element index
     */
    private static void siftUp(int[] arr, int id) {
        while (arr[(id - 1) / 2] < arr[id] && id > 0) {
            int temp = arr[id];
            arr[id] = arr[(id - 1) / 2];
            arr[(id - 1) / 2] = temp;
            id = (id - 1) / 2;
        }
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
        if (left < N && arr[current] < arr[left])
            current = left;
        if (right < N && arr[current] < arr[right])
            current = right;
        if (current != id) {
            int t = arr[current];
            arr[current] = arr[id];
            arr[id] = t;
            siftDown(arr, current, N);
        }
    }

    /**
     * Return the root of the tree (heap) preserving the heap invariant
     *
     * @param arr heap
     * @param len len of heap
     * @return the largest element of the heap (root of the tree)
     */
    private static int takeRoot(int[] arr, int len) {
        int last = len - 1;
        int returnValue = arr[0];
        arr[0] = arr[last];
        arr[last] = returnValue;
        siftDown(arr, 0, len - 1);
        return returnValue;
    }

    /**
     * Heap sort of array
     *
     * @param arr array to sort
     * @param len its length
     */
    public static void heapSort(int[] arr, int len) {
        for (int i = 0; i < len; i++)
            siftUp(arr, i);

        int[] temp = new int[len];
        int i = 0;
        while(len > 0){
            temp[i] = takeRoot(arr, len);
            --len;
            ++i;
        }
        arr = temp;
    }
}
