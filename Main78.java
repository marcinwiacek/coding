import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main78 {

    public static void main(String[] args) throws FileNotFoundException {
        int[] a = {-21, -67, -37, -18, 4, -65};
        Arrays.fill(a, Integer.MIN_VALUE);
        for (int i : a) {
            System.out.println(i);
        }

        int a1 = 360 / 12 * 3;
        int a2 = 360 / 60 * 0;
        System.out.println(Math.min(Math.abs(a1 - a2), 360 - Math.abs(a1 - a2)));

//System.out.println(Math.addExact(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(Math.floor(-15 / 6));

        String s = "Abc";
        System.out.println(s.charAt(1) - 'a');
        System.out.println(Character.toChars(65));
        s = s + (char) 65 + (char) (s.charAt(0) - 'a');
        System.out.println(s);


/*
        File myObj = new File("filename.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
        */
    }
}