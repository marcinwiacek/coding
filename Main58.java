import java.io.FileNotFoundException;

public class Main58 {

    //https://www.youtube.com/watch?v=QGVCnjXmrNg problem 1

    static void showAll(Node n, String s) {
        if (n.word) {
            System.out.print(s + ", ");
        }
        for (int i = 0; i < 256; i++) {
            if (n.children[i] != null) showAll(n.children[i], s + (char) i);
        }
    }

    //https://www.youtube.com/watch?v=QGVCnjXmrNg
    //words starting with do
    public static void main(String[] args) throws FileNotFoundException {
        String[] words = {"dog", "dark", "cat", "dooo", "dodge", "dooooooo", "ala", "qwerty", "test", "cos",
                "adog", "bdark", "ccat", "ddooo", "edodge", "fdooooooo", "gala", "hqwerty", "itest", "jcos"};

        long aaaaaa = System.nanoTime();
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith("do")) System.out.print(words[i] + ", ");
        }
        System.out.println();
        System.out.println("nano " + (System.nanoTime() - aaaaaa));
        System.out.println();
        System.out.println();

        //solution from https://www.youtube.com/watch?v=QGVCnjXmrNg
        aaaaaa = System.nanoTime();
        Node nodes = new Node();
        for (int i = 0; i < words.length; i++) {
            Node x = nodes;
            for (int j = 0; j < words[i].length(); j++) {
                if (x.children[words[i].charAt(j)] == null) {
                    x.children[words[i].charAt(j)] = new Node();
                }
                x = x.children[words[i].charAt(j)];
                if (j == words[i].length() - 1) x.word = true;
            }
        }
        System.out.println("nano creating " + (System.nanoTime() - aaaaaa));
        String to = "do";
        Node x = nodes;
        Boolean found = true;
        for (int j = 0; j < to.length(); j++) {
            if (x.children[to.charAt(j)] == null) {
                found = false;
                break;
            }
            x = x.children[to.charAt(j)];
        }
        if (found) {
            showAll(x, to);
        }
        System.out.println();
        System.out.println("nano2 " + (System.nanoTime() - aaaaaa));
    }

    static public class Node {
        Node[] children = new Node[256];
        Boolean word = false;
    }


}