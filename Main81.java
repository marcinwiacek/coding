import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Main81 {

    public static void main(String[] args) {

        HashMap<Integer, Integer[]> graph = new HashMap<>();
        graph.put(0, new Integer[]{1});
        graph.put(1, new Integer[]{2, 4, 0});
        graph.put(2, new Integer[]{1, 3});
        graph.put(3, new Integer[]{4, 2});
        graph.put(4, new Integer[]{1, 3});

        //for (int i=0;i<5;i++) {
        new Main81().podrozuj(graph, new LinkedList<>(Arrays.asList(3)), new LinkedList<>(Arrays.asList(graph.get(3))));
        //}
    }

    //https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
    void podrozuj(HashMap<Integer, Integer[]> graph, LinkedList<Integer> odwiedzone, LinkedList<Integer> tovisit) {
        System.out.println("1 " + odwiedzone + " " + tovisit);
        while (tovisit.size() != 0) {
            int w = tovisit.getLast();
            tovisit.removeLast();
            System.out.println(w);
          /*  if (odwiedzone.size()>2 &&  odwiedzone.get(0)==w ) {
                System.out.println(" cykl "+odwiedzone+ " "+w);
            }*/
            if (odwiedzone.contains(w)) {
                if (odwiedzone.size() >= 2 && odwiedzone.get(odwiedzone.size() - 2) != w) {
                    System.out.println("jest cykl");
                }
                continue;
            }
            tovisit.addAll(Arrays.asList(graph.get(w)));
            odwiedzone.addLast(w);
            System.out.println(w + " " + odwiedzone + " " + tovisit);
        }
        System.out.println(" " + odwiedzone + " " + tovisit);
    }
}