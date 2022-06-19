public class Main99 {


    public static void main(String[] args) {
        int[] arr = {6, -1, -3, 4, -2, 2, 4, 6, -12, -7};

        int ile = 0;
        boolean n = true;
        int suma = 0;
        int pierwszy = -1;
        for (int i = 0; i < 10; i++) {
            if (n) {
                suma = arr[i];
                n = false;
                pierwszy = i;
            } else if (suma + arr[i] == 0) {
                ile++;
                n = true;
            } else if ((suma < 0 && suma + arr[i] > 0) || (suma > 0 && suma + arr[i] < 0)) {
                suma -= arr[pierwszy];
                pierwszy++;
            } else {
                suma += arr[i];
            }
            System.out.println(pierwszy + " " + suma);
        }
        System.out.println(ile);
    }
}