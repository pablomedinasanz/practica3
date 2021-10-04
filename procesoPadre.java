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
                "Este programa genera tantos números aleatorios como letras tenga la palabra que introduzca.");
        System.out.println("El programa finalizará cuando introduzca la palabra 'fin'.");

        // pide palabra por teclado
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca una palabra: ");
        String input = sc.nextLine();

        // guarda si el input está formado o no por letras
        boolean soloTexto = contieneSoloLetras(input);

        // si el input no vale "fin" se ejecuta el while
        while (!"fin".equalsIgnoreCase(input)) {
            
            // si el input no vale "fin" y está formado solo por letras se ejecuta el while
            while (soloTexto == true && !"fin".equalsIgnoreCase(input)) {

                // muestra por teclado cuántos números se van a imprirmir
                System.out.println("Se van a imprimir " + input.length() + " números.");

                //array donde guardaremos los tiempos de ejecucción
                double[] arrayEjecuccion = new double[input.length()];

                // bucle que generará tantos números randoms como caracteres tenga la palabra
                // ejecutando el proceso hijo
                for (int i = 0; i < input.length(); i++) {
                    
                    //medimos la hora justo antes de ejecutar el proceso hijo
                    double inicio = (double)System.currentTimeMillis();

                    //LLAMADA AL MÉTODO QUE EJECUTA EL PROCESO HIJO
                    creaciónDeProcesoHijo();

                    //medimos la hora justo después de ejecutar el proceso hijo
                    double fin = (double)System.currentTimeMillis();
                    // la resta de ambas se guarda en el array 
                    arrayEjecuccion[i] = (fin - inicio) / 1000;
                    
                }

                // se imprime el tiempo de ejecución de cada proceso hijo ejecutado y guardado en el array 
                System.out.println("\n" + "Tiempos de ejecución: ");
                for (int j = 0; j < arrayEjecuccion.length; j++) {
                    System.out.print("Número " + (j + 1) + " : ");
                    System.out.println(arrayEjecuccion[j] + " segundos.");
                }

                // se pide una nueva palabra
                System.out.println("\n" + "\n" + "Introduzca una palabra: ");
                input = sc.nextLine();
                soloTexto = contieneSoloLetras(input);

            }
            //si el input no son letras o es fin:
            // si es fin se acaba y sale del while
            if (input.equalsIgnoreCase("fin")) {

            // si no tiene letras da otra oportunidad para escribir una palabra
            } else {

                System.out.println("Has introducido algún carácter inválido, las palabras está formadas por LETRAS");
                System.out.println("(recuerda escribir sin espacios ni signos de puntuación)");
                System.out.println("Vuelve a introducir una palabra, anda: ");
                input = sc.nextLine();
                soloTexto = contieneSoloLetras(input);
            }
        }
        //si el input vale "fin" se acaba el programa
        System.out.println("FIN DEL PROGRAMA");

        sc.close();
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
            System.out.print(muestra);

            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static boolean contieneSoloLetras(String input) {
        for (int i = 0; i < input.length(); i++) {
            char caracter = input.charAt(i);
            // Si no está entre a y z, ni entre A y Z, devuelve falso
            if (!((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z'))) {
                return false;
            }
        }
        return true;
    }
}
