import java.util.Scanner;

public class programaRandom {

    public programaRandom() {

    }

    public static void main(String[] args) {

        generarRandom();

    }

    public static void leeEntrada() {
        Scanner sc = new Scanner(System.in);
        String inPut = sc.nextLine();

        for (int i = 0; i < inPut.length(); i++) {
            generarRandom();
        }

        sc.close();

    }

    public static void generarRandom() {

        int outPut = (int) (Math.random() * 9);
        System.out.println(outPut);
    }
}
