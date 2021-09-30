import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class proceso {

    public static void main(String[] args) {

        ProcessBuilder procesoHijo = new ProcessBuilder();
        procesoHijo.command("powershell.exe", "/c", "java src\\programaRandom.java");
        try {

            Process p = procesoHijo.start();

            InputStreamReader reader = new InputStreamReader(p.getInputStream());
            BufferedReader bf = new BufferedReader(reader);

            String muestra = bf.readLine();
            System.out.println(muestra);

            // String line;
            // while ((line = reader.readLine()) != null) {

            // System.out.println(line);
            // }

            // int exitCode = p.waitFor();
            // System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
