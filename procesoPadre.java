import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class procesoPadre {

    private static String muestra;

    public static void main(String[] args) {

        System.out.println(
                "Este programa genera tantos números aleatorios como carácteres tenga la palabra que introduzca.");
        System.out.println("El programa finalizará cuando introduzca la palabra 'fin'. ");
        System.out.println("Introduzca una palabra: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {

            creaciónDeProcesoHijo();
        }

        sc.close();

    }

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
