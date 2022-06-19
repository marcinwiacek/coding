import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Stack;

public class Main70 {

    public static void iterate0(int[][] a, int[][] border, int x, int y) {
        int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] step : steps) {
            int newx = x + step[0];
            int newy = y + step[1];
            if (newx < 0 || newx > 5 || newy < 0 || newy > 5) {
                continue;
            }
            if (border[newy][newx] == 0 && a[newy][newx] == 1) {
                border[newy][newx] = 1;
                iterate(a, border, newx, newy);
            }
        }
    }

    public static void iterate(int[][] a, int[][] border, int x, int y) {
        if (a[y][x] == 0) return;
        if (x == 0 || x == 5 || y == 0 || y == 5) {
            border[y][x] = 1;
        }
        int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] step : steps) {
            int newx = x + step[0];
            int newy = y + step[1];
            if (newx < 0 || newx > 5 || newy < 0 || newy > 5) {
                continue;
            }
            if (border[newy][newx] == 0 && a[newy][newx] == 1) {
                border[newy][newx] = 1;
                iterate(a, border, newx, newy);
            }
        }
    }

    public static void iterate2(int[][] a, int[][] border, int x, int y) {
        if (a[y][x] == 0) return;
        if (x == 0 || x == 5 || y == 0 || y == 5) {
            border[y][x] = 1;
        }
        Stack<p> s = new Stack<>();
        s.push(new p(x, y));
        while (!s.isEmpty()) {
            p point = s.pop();
            int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] step : steps) {
                int newx = point.x + step[0];
                int newy = point.y + step[1];
                if (newx < 0 || newx > 5 || newy < 0 || newy > 5) {
                    continue;
                }
                if (border[newy][newx] == 0 && a[newy][newx] == 1) {
                    border[newy][newx] = 1;
                    s.push(new p(newx, newy));
                }
            }
        }
    }

    public static void iterate3(int[][] a, int[][] border, int x, int y) {
        if (a[y][x] == 0) return;
        if (x == 0 || x == 5 || y == 0 || y == 5) {
            border[y][x] = 1;
        }
        LinkedList<p> s = new LinkedList<>();
        s.push(new p(x, y));
        while (!s.isEmpty()) {
            p point = s.pop();
            int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] step : steps) {
                int newx = point.x + step[0];
                int newy = point.y + step[1];
                if (newx < 0 || newx > 5 || newy < 0 || newy > 5) {
                    continue;
                }
                if (border[newy][newx] == 0 && a[newy][newx] == 1) {
                    border[newy][newx] = 1;
                    //s.addLast(new p(newx,newy));
                    s.push(new p(newx, newy));
                }
            }
        }
    }

    public static void iterate4(int[][] a, int[][] border, int x, int y) {
        /*if (a[y][x] == 0) return;
        if (x == 0 || x == 5 || y == 0 || y == 5) {
            border[y][x] = 1;
        }*/
        int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int newx;
        int newy;
        p point;
        LinkedList<p> s = new LinkedList<>();
        s.addLast(new p(x, y));
        while (!s.isEmpty()) {
            point = s.getFirst();
            s.removeFirst();
            for (int[] step : steps) {
                newx = point.x + step[0];
                newy = point.y + step[1];
                if (newx < 0 || newx > 5 || newy < 0 || newy > 5) {
                    continue;
                }
                if (border[newy][newx] == 0 && a[newy][newx] == 1) {
                    border[newy][newx] = 1;
                    s.addLast(new p(newx, newy));
                }
            }
        }
    }

    //https://www.youtube.com/watch?v=4tYoVx0QoN0
    //finding border islands
    public static void main(String[] args) throws FileNotFoundException {
        int[][] a = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}};

        long aaaaaa = System.nanoTime();
        int[][] border = new int[6][6];
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                iterate3(a, border, x, y);
            }
        }
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                System.out.print(border[y][x]);
            }
            System.out.println();
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        border = new int[6][6];
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                iterate2(a, border, x, y);
            }
        }
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                System.out.print(border[y][x]);
            }
            System.out.println();
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        border = new int[6][6];
        for (int x = 0; x < 6; x++) {
            iterate(a, border, x, 0);
            iterate(a, border, x, 5);
        }
        for (int y = 0; y < 6; y++) {
            iterate(a, border, 0, y);
            iterate(a, border, 5, y);
        }
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                System.out.print(border[y][x]);
            }
            System.out.println();
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));


        aaaaaa = System.nanoTime();
        border = new int[6][6];
        for (int x = 0; x < 6; x++) {
            if (a[0][x] == 1) {
                border[0][x] = 1;
                iterate0(a, border, x, 0);
            }
            if (a[5][x] == 1) {
                border[5][x] = 1;
                iterate0(a, border, x, 5);
            }
        }
        for (int y = 0; y < 6; y++) {
            if (a[y][0] == 1) {
                border[y][0] = 1;
                iterate0(a, border, 0, y);
            }
            if (a[y][5] == 1) {
                border[y][5] = 1;
                iterate0(a, border, 5, y);
            }
        }
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                System.out.print(border[y][x]);
            }
            System.out.println();
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        border = new int[6][6];
        for (int x = 0; x < 6; x++) {
            if (a[0][x] == 1) {
                border[0][x] = 1;
                iterate4(a, border, x, 0);
            }
            if (a[5][x] == 1) {
                border[5][x] = 1;
                iterate4(a, border, x, 5);
            }
        }
        for (int y = 0; y < 6; y++) {
            if (a[y][0] == 1) {
                border[y][0] = 1;
                iterate4(a, border, 0, y);
            }
            if (a[y][5] == 1) {
                border[y][5] = 1;
                iterate4(a, border, 5, y);
            }
        }
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                System.out.print(border[y][x]);
            }
            System.out.println();
        }
        System.out.println("nano" + (System.nanoTime() - aaaaaa));
    }

    private static class p {
        public int x, y;

        p(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}