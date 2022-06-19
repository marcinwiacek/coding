import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main57 {

    static long sort(int[] numbers, int k) {

        long aaaaaa = System.nanoTime();
        int[] numbers2 = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers2[i] = numbers[i];
        }
        Arrays.sort(numbers2);    //O(nlogn) when sorting nlogn
        System.out.println(k + " biggest number is " + numbers2[numbers2.length - k]);
        System.out.println("nano2 " + (System.nanoTime() - aaaaaa));
        return (System.nanoTime() - aaaaaa);
    }

    //code from https://www.youtube.com/watch?v=QGVCnjXmrNg
    static int partition(int[] numbers, int from, int to) {
        int pivot = numbers[to], index = from;
        for (int i = from; i < to; i++) {
            if (numbers[i] <= pivot) {
                int temp = numbers[index];
                numbers[index] = numbers[i];
                numbers[i] = temp;
                index++;
            }
        }
        int temp = numbers[index];
        numbers[index] = numbers[to];
        numbers[to] = temp;
        return index;
    }

    //code from https://www.youtube.com/watch?v=QGVCnjXmrNg
    static long partition(int[] numbers, int k) {
        long aaaaaa = System.nanoTime();
        int[] numbers2 = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers2[i] = numbers[i];
        }
        int from = 0;
        int to = numbers2.length - 1;
        /*for (int i=0;i<numbers.length;i++) {
            System.out.print(numbers2[i]+" ");
        }
        System.out.println();*/
        while (from <= to) {
            //System.out.println(from + " "+to);
            int pivotIndex = partition(numbers2, from, to);
          /*  for (int i=0;i<numbers2.length;i++) {
                System.out.print(numbers2[i]+" ");
            }
            System.out.println();*/
            if (pivotIndex == numbers2.length - k) {
                System.out.println(k + " biggest number is " + numbers2[pivotIndex]);
                System.out.println("nano2 " + (System.nanoTime() - aaaaaa));
                return (System.nanoTime() - aaaaaa);
            } else if (pivotIndex > numbers2.length - k) {
                to = pivotIndex - 1;
            } else {
                from = pivotIndex + 1;
            }
        }
        return 0;
    }

    static long blabla(int[] numbers, int k) {
        long aaaaaa = System.nanoTime();
        int[] numbers2 = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers2[i] = numbers[i];
        }
        int ind = numbers2.length - 1;
        while (ind > 0 && numbers2[0] < numbers2[ind]) {
            ind--;
        }
        int i = 0;
        while (i != ind) {
            /*for (int j = 0; j < numbers2.length; j++) {
                if (i == j) System.out.print("[");
                if (j == ind) System.out.print("<");
                System.out.print(numbers2[j]);
                if (i == j) System.out.print("]");
                if (j == ind) System.out.print(">");
                System.out.print(" ");
            }
            System.out.println();*/
            if (numbers2[i] > numbers2[ind]) {
                while (ind < numbers2.length - 1 && numbers2[i] > numbers2[ind + 1]) {
                    ind++;
                }
                int temp = numbers2[ind];
                numbers2[ind] = numbers2[i];
                numbers2[i] = temp;
                if (ind > 0) ind--;
            } else {
                i++;
            }
        }
        /*for (int j = 0; j < numbers2.length; j++) {
            if (i==j) System.out.print("[");
            if (j==ind) System.out.print("<");
            System.out.print(numbers2[j]);
            if (i==j) System.out.print("]");
            if (j==ind) System.out.print(">");
            System.out.print(" ");
        }
        System.out.println();*/
        System.out.println(k + " biggest number is " + numbers2[numbers2.length - k]);
        System.out.println("nano2 " + (System.nanoTime() - aaaaaa));
        return (System.nanoTime() - aaaaaa);
    }

    static long blabla2(int[] numbers, int k) {
        long aaaaaa = System.nanoTime();
        int[] numbers2 = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers2[i] = numbers[i];
        }
        int wazny = numbers2.length - k;
        int ind = numbers2.length - 1;
        while (ind > 0 && numbers2[ind - 1] < numbers2[ind]) {
            ind--;
        }
        int i = 0;
        while (i < ind) {
          /* for (int j = 0; j < numbers2.length; j++) {
                if (i == j) System.out.print("[");
                if (j == ind) System.out.print("<");
                System.out.print(numbers2[j]);
                if (i == j) System.out.print("]");
                if (j == ind) System.out.print(">");
                System.out.print(" ");
            }
            System.out.println();*/
            if (numbers2[i] > numbers2[ind]) {
                //int temp = numbers2[ind];
                int ind2 = ind;
                if (ind2 < wazny) ind2 = wazny;
                while (ind2 < numbers2.length - 1 && numbers2[i] > numbers2[ind2 + 1]) {
                    numbers2[ind2] = numbers2[ind2 + 1];
                    ind2++;
                }
                numbers2[ind2] = numbers2[i];
                //  numbers2[i] = temp; // we don-t need this part
                while (ind > 0 && numbers2[ind - 1] < numbers2[ind]) {
                    ind--;
                }
            }
            i++;
        }
        /*for (int j = 0; j < numbers2.length; j++) {
            if (i==j) System.out.print("[");
            if (j==ind) System.out.print("<");
            System.out.print(numbers2[j]);
            if (i==j) System.out.print("]");
            if (j==ind) System.out.print(">");
            System.out.print(" ");
        }
        System.out.println();*/
        System.out.println(k + " biggest number is " + numbers2[numbers2.length - k]);
        System.out.println("nano2 " + (System.nanoTime() - aaaaaa));
        return (System.nanoTime() - aaaaaa);
    }

    static long first(int[] numbers, int k) {
        //O(k*n)
        long aaaaaa = System.nanoTime();
        int nn = Integer.MIN_VALUE;
        for (int a : numbers) {
            if (a > nn) nn = a;
        }
        for (int i = 0; i < k - 1; i++) {
            int nnn = nn;
            nn = Integer.MIN_VALUE;
            for (int a : numbers) {
                if (a < nnn && a > nn) nn = a;
            }
        }
        System.out.println(k + " biggest number is " + nn);
        System.out.println("nano2 " + (System.nanoTime() - aaaaaa));
        return (System.nanoTime() - aaaaaa);
    }

    //code from https://www.codespeedy.com/building-heap-from-an-array-in-java/
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

    //https://www.codespeedy.com/building-heap-from-an-array-in-java/
    //o(N)+o(klongN)
    private static long withheap(int[] numbers, int k) {
        long aaaaaa = System.nanoTime();
        int[] numbers2 = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers2[i] = numbers[i];
        }

        int startIdx = (numbers2.length / 2) - 1; // Index of last non-leaf node
        for (int i = startIdx; i >= 0; i--) {
            heapify(numbers2, numbers2.length, i);
        }
        //System.out.println("nano22 " + (System.nanoTime() - aaaaaa));

        class x {
            final int value;
            final int index;

            x(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }
        PriorityQueue<x> pq = new PriorityQueue<>((one1, one2) ->
                Integer.compare(one2.value, one1.value)
        );
        pq.add(new x(numbers2[0], 0));
        for (int i = 0; i < k - 1; i++) {
            x j = pq.poll();
            pq.add(new x(numbers2[j.index * 2 + 1], j.index * 2 + 1));
            pq.add(new x(numbers2[j.index * 2 + 2], j.index * 2 + 2));
        }

        System.out.println(k + " biggest number is " + pq.poll().value);
        System.out.println("nano7 " + (System.nanoTime() - aaaaaa));
        return (System.nanoTime() - aaaaaa);
    }

    //https://www.youtube.com/watch?v=QGVCnjXmrNg
    //k largest number in unsorted array
    public static void main(String[] args) throws FileNotFoundException {
        int[] numbers = {100, 200, -1, 7, 50, 1, 3, 4, 5, 6, 7, 8, 9, 99, 10, 300, 0, 16, 14, 5, 7, 2, 3, 4, 1, 6, 9, 10, 11};
        int k = 7;

        long f = 0, s = 0, t = 0, ff = 0, fff = 0, h = 0;
        for (int i = 0; i < 1000; i++) {
            f += first(numbers, k);

            s += sort(numbers, k);

            ff += blabla(numbers, k); // possible bugs

            fff += blabla2(numbers, k); // possible bugs

            t += partition(numbers, k); // should be O(n)

            h += withheap(numbers, k);
        }
        System.out.println("nano " + f);
        System.out.println("nano " + s);
        System.out.println("nano " + ff); //possible bugs
        System.out.println("nano " + fff); //possible bugs
        System.out.println("partition " + t);
        System.out.println("with heap (priority queue) " + h);


        //heap
    }


}