import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class proceso {

    public static void main(String[] args) {

        ProcessBuilder procesoHijo = new ProcessBuilder();
        procesoHijo.command("powershell.exe", "/c", "java .src\\programaRandom.java");
        try {

            Process p = procesoHijo.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
