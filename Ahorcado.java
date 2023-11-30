import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

    private static final String[] PALABRAS = {"computadora", "programacion", "java", "desarrollo", "inteligencia", "codigo", "openai", "tecnologia", "aprendizaje", "datos"};

    public static void main(String[] args) {
        String palabraSecreta = seleccionarPalabra();
        String palabraAdivinada = "_".repeat(palabraSecreta.length());
        int intentos = 7;
        StringBuilder letrasUsadas = new StringBuilder();

        Scanner scanner = new Scanner(System.in);

        while (intentos > 0 && !palabraAdivinada.equals(palabraSecreta)) {
            System.out.println("Palabra: " + palabraAdivinada);
            System.out.println("Intentos restantes: " + intentos);
            System.out.println("Letras usadas: " + letrasUsadas.toString());
            System.out.print("Ingresa una letra: ");

            char letra = scanner.next().charAt(0);

            if (letrasUsadas.indexOf(String.valueOf(letra)) != -1) {
                System.out.println("Ya has usado esa letra. ¡Intenta con otra!");
                continue;
            }

            letrasUsadas.append(letra).append(" ");

            palabraAdivinada = reemplazarGuion(palabraSecreta, palabraAdivinada, letra);

            if (palabraSecreta.indexOf(letra) == -1) {
                intentos--;
                System.out.println("Letra incorrecta. ¡Te quedan " + intentos + " intentos!");
            }
        }

        if (palabraAdivinada.equals(palabraSecreta)) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("¡Has agotado tus intentos! La palabra era: " + palabraSecreta);
        }
    }

    private static String seleccionarPalabra() {
        Random rand = new Random();
        return PALABRAS[rand.nextInt(PALABRAS.length)];
    }

    private static String reemplazarGuion(String palabraSecreta, String palabraAdivinada, char letra) {
        StringBuilder nuevaPalabra = new StringBuilder();

        for (int i = 0; i < palabraSecreta.length(); i++) {
            char caracter = palabraSecreta.charAt(i);
            char adivinado = palabraAdivinada.charAt(i);

            if (caracter == letra) {
                nuevaPalabra.append(caracter);
            } else {
                nuevaPalabra.append(adivinado);
            }
        }
        return nuevaPalabra.toString();
    }
}
