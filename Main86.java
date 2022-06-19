import java.util.Arrays;
import java.util.LinkedList;

public class Main86 {

    static void pierwszy() {
        long aaaaaa = System.nanoTime();
        LinkedList<String> ret2 = new LinkedList<>();
        LinkedList<x> processing = new LinkedList<>();
        processing.addLast(new x(0, 0, new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}}, ""));
        xx[] kroki = new xx[]{new xx(-1, 0, "L"), new xx(1, 0, "R"), new xx(0, 1, "D"), new xx(0, -1, "U")};
        x a;
        int newx;
        int newy;
        while (!processing.isEmpty()) {
            a = processing.pollFirst();
            a.m[a.y][a.x] = 0;
            for (xx krok : kroki) {
                newx = a.x + krok.x;
                newy = a.y + krok.y;
                if (newx < 0 || newy < 0 || newx == a.m[0].length || newy == a.m.length || a.m[newy][newx] == 0)
                    continue;
                if (newx == a.m[0].length - 1 && newy == a.m.length - 1) {
                    //   System.out.println(processing.size()+" "+a.ret + krok.a);
                    ret2.addLast(a.ret + krok.a);
                } else {
                    //System.out.println(processing.size()+" "+newx + " " + newy + " " + a.ret + krok.a);
                    int[][] mm = new int[a.m[0].length][a.m.length];
                    for (int yy = 0; yy < a.m.length; yy++) {
                        for (int xx = 0; xx < a.m[0].length; xx++) {
                            mm[yy][xx] = a.m[yy][xx];
                        }
                    }
                    processing.addLast(new x(newx, newy, mm, a.ret + krok.a));
                }
            }
        }
        System.out.println(ret2);
        System.out.println("nano " + (System.nanoTime() - aaaaaa));

    }

    static void drugi() {
        long aaaaaa = System.nanoTime();
        LinkedList<String> ret2 = new LinkedList<>();
        LinkedList<x> processing = new LinkedList<>();
        processing.addLast(new x(0, 0, new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}}, ""));
        xx[] kroki = new xx[]{new xx(-1, 0, "L"), new xx(1, 0, "R"), new xx(0, 1, "D"), new xx(0, -1, "U")};
        x a;
        int newx;
        int newy;
        while (!processing.isEmpty()) {
            a = processing.pollFirst();
            //System.out.println("processing "+a.ret);
            a.m[a.y][a.x] = 0;
            for (xx krok : kroki) {
                newx = a.x + krok.x;
                newy = a.y + krok.y;
                if (newx == -1 || newy == -1 || newx == a.m[0].length || newy == a.m.length || a.m[newy][newx] == 0)
                    continue;
                if (newx == a.m[0].length - 1 && newy == a.m.length - 1) {
                    //System.out.println(processing.size()+" "+a.ret + krok.a);
                    ret2.addLast(a.ret + krok.a);
                } else {
                    // System.out.println(processing.size()+" "+newx + " " + newy + " " + a.ret + krok.a);
                    int[][] mm = new int[a.m[0].length][a.m.length];
                    for (int yy = 0; yy < a.m.length; yy++) {
                        for (int xx = 0; xx < a.m[0].length; xx++) {
                            mm[yy][xx] = a.m[yy][xx];
                        }
                    }
                    processing.addFirst(new x(newx, newy, mm, a.ret + krok.a));
                }
            }
        }
        //  System.out.println(processing.isEmpty());
        System.out.println(ret2);
        System.out.println("nano " + (System.nanoTime() - aaaaaa));

    }

    // trawersing from (0,0) into (2,2) on points with 1 with Right or Down moves
    public static void main(String[] args) {

        long aaaaaa = System.nanoTime();
        LinkedList<String> ret = (new Main86()).solve("", 0, 0, new int[][]{{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}});
        System.out.println(ret);
        System.out.println("nano " + (System.nanoTime() - aaaaaa));

        pierwszy();
        // drugi(); //błąd?????????????
    }

    //https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
    public LinkedList<String> solve(String ss, int x, int y, int[][] m) {
        if (x < 0 || y < 0 || x == m[0].length || y == m.length || m[y][x] == 0) return new LinkedList<>();
        if (x == m[0].length - 1 && y == m.length - 1) {
            return new LinkedList<>(Arrays.asList(ss));
        }

        LinkedList<String> ret = new LinkedList<>();
        int[][] mm = new int[m[0].length][m.length];
        for (int yy = 0; yy < m.length; yy++) {
            for (int xx = 0; xx < m[0].length; xx++) {
                mm[yy][xx] = m[yy][xx];
            }
        }

        mm[y][x] = 0;
        ret.addAll(solve(ss + "L", x - 1, y, mm));
        ret.addAll(solve(ss + "R", x + 1, y, mm));
        ret.addAll(solve(ss + "U", x, y - 1, mm));
        ret.addAll(solve(ss + "D", x, y + 1, mm));
        return ret;
    }

    static class xx {
        String a;
        int x;
        int y;

        xx(int x, int y, String a) {
            this.a = a;
            this.x = x;
            this.y = y;
        }
    }

    static class x {
        int x;
        int y;
        int[][] m;
        String ret;

        x(int x, int y, int[][] m, String ret) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.ret = ret;
        }
    }
}