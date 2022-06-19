public class Main54 {
//all code from https://www.codespeedy.com/building-heap-from-an-array-in-java/

    static void heapify(int[] array, int size, int i) {
        int largest = i;    // Initialize current node as largest
        int left = 2 * i + 1;   // position of left child in array = 2*i + 1
        int right = 2 * i + 2;   // position of right child in array = 2*i + 2

        if (left < size && array[left] > array[largest])  // If left child is larger than root
            largest = left;

        if (right < size && array[right] > array[largest]) // If right child is larger than largest so far
            largest = right;

        if (largest != i) {         // If largest is not root swap it
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, size, largest); // Recursively heapify the sub-tree
        }
    }

    static void buildHeap(int[] arr, int n) {

        int startIdx = (n / 2) - 1; // Index of last non-leaf node
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    static void printHeap(int[] arr, int n) {
        System.out.println("Array representation of Heap:");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 4, 5, 6, 7, 8, 9, 5};

        buildHeap(arr, arr.length);
        printHeap(arr, arr.length);


    }

}