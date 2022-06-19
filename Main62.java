import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Stack;

public class Main62 {


    //https://cp-algorithms.com/graph/breadth-first-search.html#implementation
    //BFS nie robi push na początku jak!!!!!!!


    //https://www.youtube.com/watch?v=IWvbPIYQPFM
    //https://www.geeksforgeeks.org/difference-between-bfs-and-dfs/
    //https://www.geeksforgeeks.org/breadth-first-traversal-bfs-on-a-2d-array/
    //https://www.geeksforgeeks.org/depth-first-traversal-dfs-on-a-2d-array/
    private static int odwiedzonych = 0;

    static int x(int x, int y, int[][] p, int[][] visited, int m) {
        int r = m;
        for (int[] points : new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}}) {
            int newx = x + points[0];
            int newy = y + points[1];
            if (newx < 0 || newy < 0 || newy >= 3 || newx >= 4) continue;
            if (visited[newy][newx] == 0 && p[newy][newx] == p[y][x]) {
                visited[newy][newx] = 1;
                odwiedzonych++;
                if (odwiedzonych == 4 * 3) break;
                r = x(newx, newy, p, visited, r + 1);
            }
        }
        return r;
    }

    static int bfs(int x, int y, int[][] p, int[][] visited, int m) {
        if (visited[y][x] == 1) return m;
        int r = m;

        LinkedList<pair> tovisit = new LinkedList<>();
        tovisit.add(new pair(x, y));
        while (!tovisit.isEmpty()) {
            pair punkt = tovisit.getFirst();
            tovisit.removeFirst();
            visited[punkt.y][punkt.x] = 1;
            r++;
            System.out.println("odwiedzam2 " + punkt.x + " " + punkt.y);
            odwiedzonych++;
            if (odwiedzonych == 4 * 3) break;
            for (int[] points : new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}}) {
                int newx = punkt.x + points[0];
                int newy = punkt.y + points[1];
                if (newx < 0 || newy < 0 || newy >= 3 || newx >= 4) continue;
                if (visited[newy][newx] == 0 && p[newy][newx] == p[punkt.y][punkt.x]) {
                    visited[newy][newx] = 1;
                    tovisit.addLast(new pair(newx, newy));
                }
            }

        }
        return r;
    }

    static int bfs2(int x, int y, int[][] p, int[][] visited, int m) {
        if (visited[y][x] == 1) return m;
        int r = m;

        LinkedList<pair> tovisit = new LinkedList<>();
        tovisit.addLast(new pair(x, y));
        while (!tovisit.isEmpty()) {
            pair punkt = tovisit.getFirst();
            tovisit.removeFirst();
            visited[punkt.y][punkt.x] = 1;
            r++;
            System.out.println("odwiedzam2 " + punkt.x + " " + punkt.y);
            odwiedzonych++;
            if (odwiedzonych == 4 * 3) break;
            for (int[] points : new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}}) {
                int newx = punkt.x + points[0];
                int newy = punkt.y + points[1];
                if (newx < 0 || newy < 0 || newy >= 3 || newx >= 4) continue;
                if (visited[newy][newx] == 0 && p[newy][newx] == p[punkt.y][punkt.x]) {
                    visited[newy][newx] = 1;
                    tovisit.addLast(new pair(newx, newy));
                }
            }

        }
        return r;
    }

    static int dfs(int x, int y, int[][] p, int[][] visited, int m) {
        if (visited[y][x] == 1) return m;
        int r = m;

        LinkedList<pair> tovisit = new LinkedList<>();
        tovisit.addFirst(new pair(x, y));
        while (!tovisit.isEmpty()) {
            pair punkt = tovisit.getFirst();
            tovisit.removeFirst();
            visited[punkt.y][punkt.x] = 1;
            r++;
            System.out.println("odwiedzam2 " + punkt.x + " " + punkt.y);
            odwiedzonych++;
            if (odwiedzonych == 4 * 3) break;
            for (int[] points : new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}}) {
                int newx = punkt.x + points[0];
                int newy = punkt.y + points[1];
                if (newx < 0 || newy < 0 || newy >= 3 || newx >= 4) continue;
                if (visited[newy][newx] == 0 && p[newy][newx] == p[punkt.y][punkt.x]) {
                    visited[newy][newx] = 1;
                    tovisit.addFirst(new pair(newx, newy));
                }
            }

        }
        return r;
    }

    static int dfs2(int x, int y, int[][] p, int[][] visited, int m) {
        if (visited[y][x] == 1) return m;
        int r = m;

        Stack<pair> tovisit = new Stack<>();
        tovisit.add(new pair(x, y));
        while (!tovisit.isEmpty()) {
            pair punkt = tovisit.pop();
            visited[punkt.y][punkt.x] = 1;
            r++;
            System.out.println("odwiedzam2 " + punkt.x + " " + punkt.y);
            odwiedzonych++;
            if (odwiedzonych == 4 * 3) break;
            for (int[] points : new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}}) {
                int newx = punkt.x + points[0];
                int newy = punkt.y + points[1];
                if (newx < 0 || newy < 0 || newy >= 3 || newx >= 4) continue;
                if (visited[newy][newx] == 0 && p[newy][newx] == p[punkt.y][punkt.x]) {
                    visited[newy][newx] = 1;
                    tovisit.push(new pair(newx, newy));
                }
            }

        }
        return r;
    }

    static int dfs3(int x, int y, int[][] p, int[][] visited, int m) {
        if (visited[y][x] == 1) return m;
        int r = m;

        Stack<pair> tovisit = new Stack<>();
        tovisit.push(new pair(x, y));
        while (!tovisit.isEmpty()) {
            pair punkt = tovisit.pop();
            visited[punkt.y][punkt.x] = 1;
            r++;
            System.out.println("odwiedzam2 " + punkt.x + " " + punkt.y);
            odwiedzonych++;
            if (odwiedzonych == 4 * 3) break;
            for (int[] points : new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}}) {
                int newx = punkt.x + points[0];
                int newy = punkt.y + points[1];
                if (newx < 0 || newy < 0 || newy >= 3 || newx >= 4) continue;
                if (visited[newy][newx] == 0 && p[newy][newx] == p[punkt.y][punkt.x]) {
                    visited[newy][newx] = 1;
                    tovisit.push(new pair(newx, newy));
                }
            }

        }
        return r;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[][] p = {{1, 1, 0, 2},
                {1, 0, 2, 0},
                {2, 0, 0, 0}};

        long aaaaaa = System.nanoTime();
        int[][] visited = new int[3][4];
        int maxnum = 0;
        odwiedzonych = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 4; x++) {
                if (visited[y][x] == 0) {
                    visited[y][x] = 1;
                    odwiedzonych++;
                }
                System.out.println("odwiedzam " + x + " " + y);
                if (odwiedzonych != 4 * 3) {
                    maxnum = Math.max(x(x, y, p, visited, 1), maxnum);
                }
                System.out.println("odwiedzonych " + odwiedzonych);
                for (int yy = 0; yy < 3; yy++) {
                    for (int xx = 0; xx < 4; xx++) {
                        System.out.print(visited[yy][xx]);
                    }
                    System.out.println();
                }
                System.out.println();
                if (odwiedzonych == 4 * 3) break;
            }
        }
        System.out.println(maxnum);
        System.out.println("nano x " + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        visited = new int[3][4];
        maxnum = 0;
        odwiedzonych = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 4; x++) {
                if (odwiedzonych != 4 * 3) {
                    maxnum = Math.max(bfs(x, y, p, visited, 0), maxnum);
                }
                System.out.println("odwiedzonych " + odwiedzonych);
                for (int yy = 0; yy < 3; yy++) {
                    for (int xx = 0; xx < 4; xx++) {
                        System.out.print(visited[yy][xx]);
                    }
                    System.out.println();
                }
                System.out.println();
                if (odwiedzonych == 4 * 3) break;
            }
        }
        System.out.println(maxnum);
        System.out.println("nano bfs " + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        visited = new int[3][4];
        maxnum = 0;
        odwiedzonych = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 4; x++) {
                if (odwiedzonych != 4 * 3) {
                    maxnum = Math.max(dfs(x, y, p, visited, 0), maxnum);
                }
                System.out.println("odwiedzonych " + odwiedzonych);
                for (int yy = 0; yy < 3; yy++) {
                    for (int xx = 0; xx < 4; xx++) {
                        System.out.print(visited[yy][xx]);
                    }
                    System.out.println();
                }
                System.out.println();
                if (odwiedzonych == 4 * 3) break;
            }
        }
        System.out.println(maxnum);
        System.out.println("nano dfs " + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        visited = new int[3][4];
        maxnum = 0;
        odwiedzonych = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 4; x++) {
                if (odwiedzonych != 4 * 3) {
                    maxnum = Math.max(dfs2(x, y, p, visited, 0), maxnum);
                }
                System.out.println("odwiedzonych " + odwiedzonych);
                for (int yy = 0; yy < 3; yy++) {
                    for (int xx = 0; xx < 4; xx++) {
                        System.out.print(visited[yy][xx]);
                    }
                    System.out.println();
                }
                System.out.println();
                if (odwiedzonych == 4 * 3) break;
            }
        }
        System.out.println(maxnum);
        System.out.println("nano dfs2 " + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        visited = new int[3][4];
        maxnum = 0;
        odwiedzonych = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 4; x++) {
                if (odwiedzonych != 4 * 3) {
                    maxnum = Math.max(bfs2(x, y, p, visited, 0), maxnum);
                }
                System.out.println("odwiedzonych " + odwiedzonych);
                for (int yy = 0; yy < 3; yy++) {
                    for (int xx = 0; xx < 4; xx++) {
                        System.out.print(visited[yy][xx]);
                    }
                    System.out.println();
                }
                System.out.println();
                if (odwiedzonych == 4 * 3) break;
            }
        }
        System.out.println(maxnum);
        System.out.println("nano bfs2 " + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        visited = new int[3][4];
        maxnum = 0;
        odwiedzonych = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 4; x++) {
                if (odwiedzonych != 4 * 3) {
                    maxnum = Math.max(dfs3(x, y, p, visited, 0), maxnum);
                }
                System.out.println("odwiedzonych " + odwiedzonych);
                for (int yy = 0; yy < 3; yy++) {
                    for (int xx = 0; xx < 4; xx++) {
                        System.out.print(visited[yy][xx]);
                    }
                    System.out.println();
                }
                System.out.println();
                if (odwiedzonych == 4 * 3) break;
            }
        }
        System.out.println(maxnum);
        System.out.println("nano dfs3 " + (System.nanoTime() - aaaaaa));
    }

    static class pair {
        public int x;
        public int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}