import java.io.IOException;
import java.util.Scanner;

public class programaRandom {
    public static void main(String[] args) {


        ProcessBuilder procesoHijo = new ProcessBuilder("Java");
        try {
            Process processSon = procesoHijo.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void leeEntrada() {
        Scanner sc = new Scanner(System.in);
        String inPut = sc.nextLine();

        for (int i = 0; i < inPut.length(); i++) {
            generarRandom();
        }

    }

    public static void generarRandom() {

        int outPut = (int) (Math.random() * 9);
        System.out.println(outPut);
    }
}