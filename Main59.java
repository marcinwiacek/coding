import java.io.FileNotFoundException;

public class Main59 {

    //https://www.youtube.com/watch?v=7HgsS8bRvjo

    static boolean is_unival(Node n) {
        if (n == null) return true;
        if (n.left != null && n.left.value != n.value) return false;
        if (n.right != null && n.right.value != n.value) return false;
        return is_unival(n.left) && is_unival(n.right);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(2);
        root.right.right.right = new Node(2);
        root.right.right.left = new Node(2);
        System.out.println(is_unival(root.right.right));
    }

    static class Node {
        int value;
        Node left = null;
        Node right = null;

        Node(int value) {
            this.value = value;
        }
    }


}