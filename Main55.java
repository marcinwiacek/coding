import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Main55 {

    static void first(char[][] edges) {
        HashMap<Character, Character> previous = new HashMap<>();
        HashMap<Character, Integer> length = new HashMap<>();
        for (char[] e : edges) {
            length.put(e[0], Integer.MAX_VALUE);
            length.put(e[1], Integer.MAX_VALUE);
        }
        //System.out.println("Number of edges " + edge.size());

        char startpoint = 'w';
        LinkedList<Character> toVisit = new LinkedList<>();
        toVisit.addLast(startpoint);
        length.put(startpoint, 0);
        while (!toVisit.isEmpty()) {
            char v = toVisit.getFirst();
            toVisit.removeFirst();
            for (char[] e : edges) {
                if (e[0] == v) {
                    if (length.get(v) + 1 < length.get(e[1])) {
                        length.put(e[1], length.get(v) + 1);
                        toVisit.addLast(e[1]);
                        previous.put(e[1], v);
                    }
                } else if (e[1] == v) {
                    if (length.get(v) + 1 < length.get(e[0])) {
                        length.put(e[0], length.get(v) + 1);
                        toVisit.addLast(e[0]);
                        previous.put(e[0], v);
                    }
                }
            }
        }
        System.out.println(length);
    }

    static void second(char[][] edges) {

        HashMap<Character, Character> previous = new HashMap<>();
        HashMap<Character, Integer> length = new HashMap<>();
        for (char[] e : edges) {
            length.put(e[0], Integer.MAX_VALUE);
            length.put(e[1], Integer.MAX_VALUE);
        }
        //System.out.println("Number of edges " + edge.size());

        HashSet<Character> visited = new HashSet<>();

        char startpoint = 'w';
        LinkedList<Character> toVisit = new LinkedList<>();
        toVisit.addLast(startpoint);
        length.put(startpoint, 0);
        while (!toVisit.isEmpty()) {
            char v = toVisit.getFirst();
            toVisit.removeFirst();
            visited.add(v);
            for (char[] e : edges) {
                if (e[0] == v && !visited.contains(e[1])) {
                    if (length.get(v) + 1 < length.get(e[1])) {
                        length.put(e[1], length.get(v) + 1);
                        toVisit.addLast(e[1]);
                        previous.put(e[1], v);
                    }
                } else if (e[1] == v && !visited.contains(e[0])) {
                    if (length.get(v) + 1 < length.get(e[0])) {
                        length.put(e[0], length.get(v) + 1);
                        toVisit.addLast(e[0]);
                        previous.put(e[0], v);
                    }
                }
            }
        }
        System.out.println(length);
    }

    //https://www.youtube.com/watch?v=tWVWeAqZ0WU
    //Dijkstra - how many steps from w into others
    public static void main(String[] args) throws FileNotFoundException {
        char[][] edges = {{'w', 'x'}, {'x', 'y'}, {'z', 'y'}, {'z', 'v'}, {'w', 'v'}};

        long aaaaaa = System.nanoTime();
        first(edges);
        //second(edges);
        System.out.println("nano " + (System.nanoTime() - aaaaaa));
    }

}