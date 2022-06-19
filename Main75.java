import java.io.FileNotFoundException;
import java.util.HashSet;

public class Main75 {

    //https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1
    public static void main(String[] args) throws FileNotFoundException {
        int N = 4;
        Integer[] arr = {1, 5, 3, 2};

        long aaaaaa = System.nanoTime();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                int suma = arr[i] + arr[j];
                for (int z = 0; z < N; z++) {
                    if (z == i || z == j) continue;
                    if (suma == arr[z] && i > j) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[z]);
                    }
                }
            }
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

/*
        aaaaaa = System.nanoTime();
        HashSet<Integer> h = new HashSet<>(N, 1);
        for (int i = 0; i < N; i++) {
            h.add(arr[i]);
        }
        //h.addAll(Arrays.asList(arr)); //bardzo dużo czasu
        // System.out.println ("nano "+(System.nanoTime()-aaaaaa));
        for (int a : h) {
            for (int b : h) {
                if (a == b) continue;
                if (h.contains(a + b) && a > b) {
                    System.out.println(a + " " + b + " " + (a + b));
                }
            }
        }
        System.out.println("nano " + (System.nanoTime() - aaaaaa));
*/

     /*   aaaaaa = System.nanoTime();
        HashSet<Integer> hh = new HashSet<>(N, 1);
        for (int i = 0; i < N; i++) {
            hh.add(arr[i]);
        }
        //h.addAll(Arrays.asList(arr)); //bardzo dużo czasu
        // System.out.println ("nano "+(System.nanoTime()-aaaaaa));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (hh.contains(arr[i] + arr[j]) && i > j) {
                    System.out.println(arr[i] + " " + arr[j] + " " + (arr[i] + arr[j]));
                }
            }
        }
        System.out.println("nano " + (System.nanoTime() - aaaaaa));
*/

        /*
        aaaaaa = System.nanoTime();
        HashSet<Integer> hhh = new HashSet<>(N, 1);
        for (int i = 0; i < N; i++) {
            hhh.add(arr[i]);
        }
        //h.addAll(Arrays.asList(arr)); //bardzo dużo czasu
        // System.out.println ("nano "+(System.nanoTime()-aaaaaa));
        for (int a:arr) {
            for (int b:arr) {
                if (a==b) continue;
                if (hhh.contains(a+b) && a>b) {
                    System.out.println(a + " " + b + " " + (a+b));
                }
            }
        }
        System.out.println("nano " + (System.nanoTime() - aaaaaa));
*/

        aaaaaa = System.nanoTime();
        HashSet<Integer> hhh = new HashSet<>(N, 1);
        for (int i = 0; i < N; i++) {
            hhh.add(arr[i]);
        }
        //h.addAll(Arrays.asList(arr)); //bardzo dużo czasu
        // System.out.println ("nano "+(System.nanoTime()-aaaaaa));
        for (int i = 0; i < N; i++) {
            int j = 0;
            while (j != N && j != i) {
                if (i > j && hhh.contains(arr[i] + arr[j])) {
                    System.out.println(arr[i] + " " + arr[j] + " " + (arr[i] + arr[j]));
                }
                j++;
            }
        }
        System.out.println("nano " + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        HashSet<Integer> hhhh = new HashSet<>(N, 1);
        for (int i = 0; i < N; i++) {
            hhhh.add(arr[i]);
        }
        //h.addAll(Arrays.asList(arr)); //bardzo dużo czasu
        // System.out.println ("nano "+(System.nanoTime()-aaaaaa));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i > j && hhhh.contains(arr[i] + arr[j])) {
                    System.out.println(arr[i] + " " + arr[j] + " " + (arr[i] + arr[j]));
                }
            }
        }
        System.out.println("nano " + (System.nanoTime() - aaaaaa));

        //????
        aaaaaa = System.nanoTime();
        HashSet<Integer> hhhhh = new HashSet<>(N, 1);
        for (int i = 0; i < N; i++) {
            hhhhh.add(arr[i]);
        }
        //h.addAll(Arrays.asList(arr)); //bardzo dużo czasu
        // System.out.println ("nano "+(System.nanoTime()-aaaaaa));
        for (int j = 0; j < N; j++) {
            for (int i = j + 1; i < N; i++) {
                if (hhhhh.contains(arr[i] + arr[j])) {
                    System.out.println(arr[i] + " " + arr[j] + " " + (arr[i] + arr[j]));
                }
            }
        }
        System.out.println("nano " + (System.nanoTime() - aaaaaa));

        //???????
        aaaaaa = System.nanoTime();
        HashSet<Integer> hhhhhh = new HashSet<>(N, 1);
        for (int i = 0; i < N; i++) {
            hhhhhh.add(arr[i]);
        }
        //h.addAll(Arrays.asList(arr)); //bardzo dużo czasu
        // System.out.println ("nano "+(System.nanoTime()-aaaaaa));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (hhhhhh.contains(arr[i] + arr[j])) {
                    System.out.println(arr[i] + " " + arr[j] + " " + (arr[i] + arr[j]));
                }
            }
        }
        System.out.println("nano " + (System.nanoTime() - aaaaaa));

    }
}