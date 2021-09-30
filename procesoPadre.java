import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class procesoPadre {
    // PROCESO PADRE QUE PEDIRÁ PALABRAS POR TECLADO Y LLAMARÁ
    // AL PROCESO HIJO TANTAS VECES COMO CARÁCTERES TENGA LA PALABRA INTRODUCDA

    private static String muestra;

    public static void main(String[] args) {

        // instrucciones
        System.out.println(
                "Este programa genera tantos números aleatorios como carácteres tenga la palabra que introduzca.");
        System.out.println("El programa finalizará cuando introduzca la palabra 'fin'.");

        // pide palabra por teclado
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca una palabra: ");
        String input = sc.nextLine();

        // mientras la palabra no valga "fin" ejecuta el proceso hijo y pide una nueva
        // palabra
        while (!"fin".equalsIgnoreCase(input)) {

            System.out.println("Se van a imprimir " + input.length() + " números.\n");

            for (int i = 0; i < input.length(); i++) {

                creaciónDeProcesoHijo();
            }
            System.out.println("Introduzca una palabra: ");
            input = sc.nextLine();
        }

        System.out.println("FIN DEL PROGRAMA");

        sc.close();

    }

    // método que crea el proceso hijo que genera un número aleatorio
    public static void creaciónDeProcesoHijo() {

        ProcessBuilder procesoHijo = new ProcessBuilder();
        procesoHijo.command("powershell.exe", "/c", "java src\\procesoHijo.java");
        try {

            Process p = procesoHijo.start();

            InputStreamReader reader = new InputStreamReader(p.getInputStream());
            BufferedReader bf = new BufferedReader(reader);

            muestra = bf.readLine();
            System.out.println("Número random:");
            System.out.println(muestra);

            int exitCode = p.waitFor();
            System.out.println("Exited with error code: " + exitCode + "\n");

        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
