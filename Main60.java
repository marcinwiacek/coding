import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Main60 {

    //https://www.youtube.com/watch?v=bGC2fNALbNU
    private static void helper(String input, char[] subset, int i) {
        if (i == input.length()) {
            for (char ii : subset) {
                //dont forget to display empty
                if (ii != ' ') System.out.print(ii);
            }
            System.out.print(", ");
            return;
        }
        subset[i] = ' ';
        helper(input, subset, i + 1);
        subset[i] = input.charAt(i);
        helper(input, subset, i + 1);
    }

    private static String[] generate(String input, int position) {
        if (position == input.length()) return new String[]{""};
        String[] sub = generate(input, position + 1);
        String[] sub2 = new String[sub.length * 2];
        for (int i = 0; i < sub.length; i++) {
            sub2[i * 2] = sub[i];
            sub2[i * 2 + 1] = input.charAt(position) + sub[i];
        }
        return sub2;
    }

    //https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
    public static void main(String[] args) throws FileNotFoundException {
        String input = "1234";

        long[] aaaaaa = new long[11];
        long bbbbbb;

        for (int loop = 0; loop < 100000; loop++) {
            bbbbbb = System.nanoTime();
            for (int i = 0; i < (1 << input.length()); i++) {
                System.out.print("'");
                for (int j = 0; j < input.length(); j++) {
                    //System.out.println("hej"+   i+" "+j);
                    if ((i & (1 << j)) > 0) {
                        System.out.print(input.charAt(j));
                    }
                }
                System.out.print("', ");
            }
            System.out.println();
            aaaaaa[0] += (System.nanoTime() - bbbbbb);
            System.out.println("nano0 " + aaaaaa[0]);

            bbbbbb = System.nanoTime();
            for (String s : generate(input, 0)) {
                System.out.print(s + ", ");
            }
            System.out.println();
            //System.out.println(Arrays.asList(generate(input, 0)));
            System.out.println();
            aaaaaa[1] += (System.nanoTime() - bbbbbb);
            System.out.println("nano1 " + aaaaaa[1]);

            bbbbbb = System.nanoTime();
            char[] subset = new char[input.length()];
            helper(input, subset, 0);
            System.out.println();
            aaaaaa[2] += (System.nanoTime() - bbbbbb);
            System.out.println("nano2 " + aaaaaa[2]);

            bbbbbb = System.nanoTime();
            LinkedList<to> llll = new LinkedList<>();
            LinkedList<String> res3 = new LinkedList<>();
            llll.addFirst(new to(input, ""));
            while (!llll.isEmpty()) {
                to s = llll.getFirst();
                llll.removeFirst();
                if (s.toprocess.isEmpty()) {
                    res3.addLast(s.result);
                    continue;
                }
                llll.addFirst(new to(s.toprocess.substring(1), s.result));
                llll.addFirst(new to(s.toprocess.substring(1), s.result + s.toprocess.charAt(0)));
            }
            System.out.println(res3);
            System.out.println();
            aaaaaa[3] += (System.nanoTime() - bbbbbb);
            System.out.println("nano3 " + aaaaaa[3]);

            bbbbbb = System.nanoTime();
            Stack<to> ll = new Stack<>();
            LinkedList<String> res2 = new LinkedList<>();
            ll.push(new to(input, ""));
            while (!ll.isEmpty()) {
                to s = ll.pop();
                if (s.toprocess.isEmpty()) {
                    //   System.out.print(s.result+" ");
                    res2.addLast(s.result);
                    continue;
                }
                ll.push(new to(s.toprocess.substring(1), s.result));
                ll.push(new to(s.toprocess.substring(1), s.result + s.toprocess.charAt(0)));
            }
            System.out.println(res2);
            System.out.println();
            aaaaaa[4] += (System.nanoTime() - bbbbbb);
            System.out.println("nano4 " + aaaaaa[4]);

            bbbbbb = System.nanoTime();
            LinkedList<to> l = new LinkedList<>();
            LinkedList<String> res = new LinkedList<>();
            l.addLast(new to(input, ""));
            while (!l.isEmpty()) {
                to s = l.pop();
                if (s.toprocess.isEmpty()) {
                    res.addLast(s.result);
                    continue;
                }
                l.addLast(new to(s.toprocess.substring(1), s.result));
                l.addLast(new to(s.toprocess.substring(1), s.result + s.toprocess.charAt(0)));
            }
            System.out.println(res);
            aaaaaa[5] += (System.nanoTime() - bbbbbb);
            System.out.println("nano5 " + aaaaaa[5]);

            bbbbbb = System.nanoTime();
            LinkedList<to> l3 = new LinkedList<>();
            LinkedList<String> res4 = new LinkedList<>();
            l3.addLast(new to(input, ""));
            while (!l3.isEmpty()) {
                to s = l3.pop();
                if (s.toprocess.length() == 1) {
                    res4.addLast(s.result);
                    res4.addLast(s.result + s.toprocess.charAt(0));
                    continue;
                }
                l3.addLast(new to(s.toprocess.substring(1), s.result));
                l3.addLast(new to(s.toprocess.substring(1), s.result + s.toprocess.charAt(0)));
            }
            System.out.println(res4);
            aaaaaa[6] += (System.nanoTime() - bbbbbb);
            System.out.println("nano6 " + aaaaaa[6]);

            bbbbbb = System.nanoTime();
            LinkedList<to> l4 = new LinkedList<>();
            LinkedList<String> res5 = new LinkedList<>();
            l4.addLast(new to(input, ""));
            to s;
            while (!l4.isEmpty()) {
                s = l4.pop();
                if (s.toprocess.length() == 1) {
                    res5.addLast(s.result);
                    res5.addLast(s.result + s.toprocess.charAt(0));
                    continue;
                }
                l4.addLast(new to(s.toprocess.substring(1), s.result));
                l4.addLast(new to(s.toprocess.substring(1), s.result + s.toprocess.charAt(0)));
            }
            System.out.println(res5);
            aaaaaa[7] += (System.nanoTime() - bbbbbb);
            System.out.println("nano7 " + aaaaaa[7]);

            bbbbbb = System.nanoTime();
            HashMap<Integer, to> l44 = new HashMap<>((int) Math.pow(2, input.length()), 1);
            LinkedList<String> res55 = new LinkedList<>();
            int index = 0;
            l44.put(index++, new to(input, ""));
            for (int i = 0; i < Math.pow(2, input.length()) - 1; i++) {
                s = l44.get(i);
                if (s.toprocess.length() == 1) {
                    res55.addLast(s.result);
                    res55.addLast(s.result + s.toprocess.charAt(0));
                    continue;
                }
                l44.put(index++, new to(s.toprocess.substring(1), s.result));
                l44.put(index++, new to(s.toprocess.substring(1), s.result + s.toprocess.charAt(0)));
            }
            System.out.println(res55);
            aaaaaa[8] += (System.nanoTime() - bbbbbb);
            System.out.println("nano8 " + aaaaaa[8]);

            bbbbbb = System.nanoTime();
            to[] l445 = new to[(int) Math.pow(2, input.length())];
            LinkedList<String> res555 = new LinkedList<>();
            int index5 = 0;
            l445[index5++] = new to(input, "");
            for (int i = 0; i < Math.pow(2, input.length()) - 1; i++) {
                if (l445[i].toprocess.length() == 1) {
                    res555.addLast(l445[i].result);
                    res555.addLast(l445[i].result + l445[i].toprocess.charAt(0));
                    continue;
                }
                l445[index5++] = new to(l445[i].toprocess.substring(1), l445[i].result);
                l445[index5++] = new to(l445[i].toprocess.substring(1), l445[i].result + l445[i].toprocess.charAt(0));
            }
            System.out.println(res555);
            aaaaaa[9] += (System.nanoTime() - bbbbbb);
            System.out.println("nano9 " + aaaaaa[9]);

            bbbbbb = System.nanoTime();
            String[][] l4456 = new String[(int) Math.pow(2, input.length())][2];
            LinkedList<String> res5556 = new LinkedList<>();
            int index56 = 0;
            l4456[index56][0] = input;
            l4456[index56++][1] = "";
            for (int i = 0; i < Math.pow(2, input.length()) - 1; i++) {
                if (l4456[i][0].length() == 1) {
                    res5556.addLast(l4456[i][1]);
                    res5556.addLast(l4456[i][1] + l4456[i][0].charAt(0));
                    continue;
                }
                l4456[index56][0] = l4456[i][0].substring(1);
                l4456[index56++][1] = l4456[i][1];
                l4456[index56][0] = l4456[i][0].substring(1);
                l4456[index56++][1] = l4456[i][1] + l4456[i][0].charAt(0);
            }
            System.out.println(res5556);
            aaaaaa[10] += (System.nanoTime() - bbbbbb);
            System.out.println("nano10 " + aaaaaa[10]);

        /* errors
        aaaaaa = System.nanoTime();
        String[] res6 = new String[(int) Math.pow(2, input.length())];
        System.out.println("len is " + (int) Math.pow(2, input.length()));
        for (int i = 0; i < res6.length; i++) {
            res6[i] = "";
        }
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length() + 1; j++) {
                res6[i + j] = res6[i + j] + input.charAt(i);

            }
        }
        for (int i = 0; i < res6.length; i++) {
            System.out.print("'" + res6[i] + "' ");
        }
        System.out.println();
        System.out.println("nano9 " + (System.nanoTime() - aaaaaa));
         */
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(aaaaaa[i] + " ");
        }
        System.out.println();
    }

    static class to {
        String toprocess;
        String result;

        to(String toprocess, String result) {
            this.toprocess = toprocess;
            this.result = result;
        }
    }


}