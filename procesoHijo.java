
public class procesoHijo {

    public procesoHijo() { // PROCESO QUE GENERA UN NÚMERO ALEATORIO

    }

    public static void main(String[] args) {

        generarRandom();

    }

    public static void generarRandom() {

        int output = (int) (Math.random() * 9);
        System.out.println(output);
    }
}
