import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main68 {

    public static LinkedList<String> getToVisit(String air, String[][] routes) {
        LinkedList<String> l = new LinkedList<>();
        for (String[] route : routes) {
            if (route[0].equals(air)) l.add(route[1]);
            //     if (route[1].equals(air)) l.add(route[0]);
        }
        return l;
    }

    //https://www.youtube.com/watch?v=qz9tKlF431k
    //https://pl.wikipedia.org/wiki/Algorytm_Dijkstry
    //https://www.geeksforgeeks.org/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/

    //searching ways from start point. Dijkstra
    public static void main(String[] args) throws FileNotFoundException {

        String[] airports = {"BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN", "JFK", "LGA",
                "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD"};
        String[][] routes = {
                {"DSM", "ORD"}, {"ORD", "BGI"}, {"BGI", "LGA"}, {"SIN", "CDG"}, {"CDG", "SIN"},
                {"CDG", "BUD"}, {"DEL", "DOH"}, {"DEL", "CDG"},
                {"TLV", "DEL"}, {"EWR", "HND"}, {"HND", "ICN"}, {"HND", "JFK"}, {"ICN", "JFK"},
                {"JFK", "LGA"}, {"EYW", "LHR"}, {"LHR", "SFO"}, {"SFO", "SAN"},
                {"SFO", "DSM"}, {"SAN", "EYW"}};

        long aaaaaa = System.nanoTime();
        HashMap<String, String> poprzedniki = new HashMap<>();
        HashMap<String, Integer> dlugosci = new HashMap<>();
        for (int i = 0; i < airports.length; i++) {
            dlugosci.put(airports[i], airports[i].equals("DEL") ? 0 : Integer.MAX_VALUE);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((v1, v2) -> 1 - 1);//krawedzie wagi
        pq.add("DEL");
        while (!pq.isEmpty()) {
            String u = pq.poll();
            LinkedList<String> vi = getToVisit(u, routes);
            for (String vvv : vi) {
                if (dlugosci.get(u) + 1 < dlugosci.get(vvv)) {
                    dlugosci.put(vvv, dlugosci.get(u) + 1);
                    pq.add(vvv); //BFS
                    poprzedniki.put(vvv, u);
                }
            }
        }
        System.out.println(dlugosci);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        poprzedniki = new HashMap<>();
        dlugosci = new HashMap<>();
        for (int i = 0; i < airports.length; i++) {
            dlugosci.put(airports[i], airports[i].equals("DEL") ? 0 : Integer.MAX_VALUE);
        }
        Stack<String> sta = new Stack<>();
        sta.push("DEL");
        while (!sta.isEmpty()) {
            String u = sta.pop();
            LinkedList<String> vi = getToVisit(u, routes);
            for (String vvv : vi) {
                if (dlugosci.get(u) + 1 < dlugosci.get(vvv)) {
                    dlugosci.put(vvv, dlugosci.get(u) + 1);
                    sta.push(vvv); //DFS
                    poprzedniki.put(vvv, u);
                }
            }
        }
        System.out.println(dlugosci);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));

        aaaaaa = System.nanoTime();
        poprzedniki = new HashMap<>();
        dlugosci = new HashMap<>();
        for (int i = 0; i < airports.length; i++) {
            dlugosci.put(airports[i], airports[i].equals("DEL") ? 0 : Integer.MAX_VALUE);
        }
        LinkedList<String> arr = new LinkedList<>();
        arr.addLast("DEL");
        while (!arr.isEmpty()) {
            String u = arr.getFirst();
            arr.removeFirst();
            LinkedList<String> vi = getToVisit(u, routes);
            for (String vvv : vi) {
                if (dlugosci.get(u) + 1 < dlugosci.get(vvv)) {
                    dlugosci.put(vvv, dlugosci.get(u) + 1);
                    arr.addLast(vvv); //BFS
                    poprzedniki.put(vvv, u);
                }
            }
        }
        System.out.println(dlugosci);
        System.out.println("nano" + (System.nanoTime() - aaaaaa));
    }
}