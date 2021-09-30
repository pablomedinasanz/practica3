
public class procesoHijo {

    public procesoHijo() {

    }

    public static void main(String[] args) {

        generarRandom();

    }

    public static void generarRandom() {

        int output = (int) (Math.random() * 9);
        System.out.println(output);
    }
}
