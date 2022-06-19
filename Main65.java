import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main65 {

    private static void go(int x, int y, String[][] matrix, String prev, ArrayList<String> possible) {
        //System.out.println(x+" "+y);
        if (x == 2 && y == 2) {
            possible.add(prev + matrix[y][x]);
        }
        if (x + 1 < 3) {
            go(x + 1, y, matrix, prev + matrix[y][x], possible);
        }
        if (y + 1 < 3) {
            go(x, y + 1, matrix, prev + matrix[y][x], possible);
        }
    }

    //https://practice.geeksforgeeks.org/problems/number-of-paths0926/1
    //Right und Down moves, paths
    public static void main(String[] args) throws FileNotFoundException {
        String[][] s = {{"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"}};

        long aaaaaa = System.nanoTime();
        ArrayList<String> possible = new ArrayList<>();
        go(0, 0, s, "", possible);
        System.out.println(possible);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        possible = new ArrayList<>();
        Stack<p> ss = new Stack<>();
        ss.push(new p(0, 0, ""));
        while (!ss.isEmpty()) {
            p x = ss.pop();
            if (x.x == 2 && x.y == 2) {
                possible.add(x.prev + s[x.y][x.x]);
                continue;
            }
            if (x.x + 1 < 3) {
                ss.push(new p(x.x + 1, x.y, x.prev + s[x.y][x.x]));
            }
            if (x.y + 1 < 3) {
                ss.push(new p(x.x, x.y + 1, x.prev + s[x.y][x.x]));
            }
        }
        System.out.println(possible);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        possible = new ArrayList<>();
        LinkedList<p> sss = new LinkedList<>();
        sss.push(new p(0, 0, ""));
        while (!sss.isEmpty()) {
            p x = sss.pop();
            if (x.x == 2 && x.y == 2) {
                possible.add(x.prev + s[x.y][x.x]);
                continue;
            }
            if (x.x + 1 < 3) {
                sss.push(new p(x.x + 1, x.y, x.prev + s[x.y][x.x]));
            }
            if (x.y + 1 < 3) {
                sss.push(new p(x.x, x.y + 1, x.prev + s[x.y][x.x]));
            }
        }
        System.out.println(possible);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        possible = new ArrayList<>();
        LinkedList<p> sssd = new LinkedList<>();
        sssd.addLast(new p(0, 0, ""));
        while (!sssd.isEmpty()) {
            p x = sssd.getFirst();
            sssd.removeFirst();
            if (x.x == 2 && x.y == 2) {
                possible.add(x.prev + s[x.y][x.x]);
                continue;
            }
            if (x.x + 1 < 3) {
                sssd.addLast(new p(x.x + 1, x.y, x.prev + s[x.y][x.x]));
            }
            if (x.y + 1 < 3) {
                sssd.addLast(new p(x.x, x.y + 1, x.prev + s[x.y][x.x]));
            }
        }
        System.out.println(possible);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        possible = new ArrayList<>();
        LinkedList<p> sssdd = new LinkedList<>();
        sssdd.addLast(new p(0, 0, ""));
        while (!sssdd.isEmpty()) {
            p x = sssdd.pollFirst();
            if (x.x == 1 && x.y == 2) {
                possible.add(x.prev + s[x.y][x.x] + s[x.y][x.x + 1]);
                continue;
            } else if (x.x == 2 && x.y == 1) {
                possible.add(x.prev + s[x.y][x.x] + s[x.y + 1][x.x]);
                continue;
            }
            if (x.x < 2) {
                sssdd.addLast(new p(x.x + 1, x.y, x.prev + s[x.y][x.x]));
            }
            if (x.y < 2) {
                sssdd.addLast(new p(x.x, x.y + 1, x.prev + s[x.y][x.x]));
            }
        }
        System.out.println(possible);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));
    }

    static class p {
        int x;
        int y;
        String prev;

        p(int x, int y, String prev) {
            this.prev = prev;
            this.x = x;
            this.y = y;
        }
    }

}