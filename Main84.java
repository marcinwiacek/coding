public class Main84 {
    //https://practice.geeksforgeeks.org/problems/minimum-shift-for-longest-common-prefix0759/1
    public static void main(String[] args) {
        //String str1 = "geeks";
        //String str2 = "dgeek";

        String str1 = "practicegeeks";
        String str2 = "coderpractice";


        for (int i = str1.length(); i >= 0; i--) {
            System.out.println(i + " " + str1.substring(0, i));
            if (str2.contains(str1.substring(0, i))) {
                System.out.println("jest 0 " + i + " " + str1.substring(0, i));
                break;
            }
        }
    }
}