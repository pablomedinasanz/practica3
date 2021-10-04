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

        boolean soloTexto = contieneSoloLetras(input);
        while (soloTexto == true) {

            while (!"fin".equalsIgnoreCase(input) && soloTexto == true) {
                // muestra por teclado cuántos números se van a imprirmir
                System.out.println("Se van a imprimir " + input.length() + " números.");

                // bucle que generará tantos números randoms como caracteres tenga la palabra
                // ejecutando el proceso hijo
                for (int i = 0; i < input.length(); i++) {

                    creaciónDeProcesoHijo();

                }
                // vuelve a pedir una palabra
                System.out.println("\n" + "\n" + "Introduzca una palabra: ");
                input = sc.nextLine();
            }

            System.out.println("FIN DEL PROGRAMA");

            sc.close();

        }
        System.out.println("Ha introducido caracteres inválidos");
        System.out.println("Introduzca una palabra, por favor: ");
        input = sc.nextLine();

        soloTexto = contieneSoloLetras(input);

        // mientras la palabra no valga "fin" ejecuta el proceso hijo y pide una nueva
        // palabra

    }

    // método que crea el proceso hijo que genera un número aleatorio
    public static void creaciónDeProcesoHijo() {

        // se crea el proceso listo
        ProcessBuilder procesoHijo = new ProcessBuilder();
        procesoHijo.command("powershell.exe", "/c", "java src\\procesoHijo.java"); // se ejecutará a través de la
                                                                                   // powershell el programa hijo
        try {

            // se inicia el proceso y se va guardando en un buffer
            Process p = procesoHijo.start();

            InputStreamReader reader = new InputStreamReader(p.getInputStream());
            BufferedReader bf = new BufferedReader(reader);
            // se lee el buffer y se imprime
            muestra = bf.readLine();
            // System.out.println("Número random:");
            System.out.print(muestra);

            int exitCode = p.waitFor();
            // System.out.println("Exited with error code: " + exitCode + "\n");

        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static boolean contieneSoloLetras(String input) {
        for (int x = 0; x < input.length(); x++) {
            char c = input.charAt(x);
            // Si no está entre a y z, ni entre A y Z, devuelve falso
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        return true;
    }
}
