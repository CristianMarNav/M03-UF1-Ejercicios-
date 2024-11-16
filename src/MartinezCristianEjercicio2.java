// Ejercicio #2 Chess Board

import java.util.Scanner;

public class MartinezCristianEjercicio2 {
    public static void main(String[] args) {

        // Definimos las constantes para los colores.
        final String ANSI_RED = "\u001B[31m"; // Peligro y advertencias.
        final String ANSI_CYAN = "\u001B[36m"; // Solicitud de entrada.
        final String ANSI_WHITE = "\u001B[37m"; // Información estándar.
        final String ANSI_YELLOW = "\u001B[33m"; // Errores y advertencias menores
        final String ANSI_GREEN = "\u001B[32m"; // Mensaje final al usuario.
        final String ANSI_RESET = "\u001B[0m"; // Para resetear el color al valor por defecto.

        // PASO 1: Solicitud de patrón del tablero y mensaje de bienvenida."

        // Creamos un objeto "Scanner" para leer los datos del usuario.
        Scanner input = new Scanner(System.in);

        // Mensaje de bienvenida al usuario.
        System.out.println(ANSI_CYAN +"¡Bienvenido al juego del Ajedrez!, te damos la bienvenida en nombre de La Salle Chess Board, ¡que disfrutes!");

        // Pedimos al usuario que ingrese el patrón para el tablero.
        System.out.println(ANSI_WHITE +"Por favor, ingresa el patrón que quieres para las casillas del tablero (ejemplo: #,X,*, etc.");
        String patron = input.nextLine(); // Guardamos el patrón ingresado por el usuario.

        // Validamos que el patrón tenga solo un carácter.
        while (patron.length() != 1) { // Bucle "WHILE" continuará hasta que el patrón sea válido.
            System.out.println(ANSI_RED + "El patrón debe ser un solo carácter. Por favor, ingresa otro patrón.");
            patron = input.nextLine(); // Pedimos nuevamente al usuario el patrón si no es válido.
        }

        // Mostramos el patrón ingresado.
        System.out.println(ANSI_WHITE + "El patrón elegido para el tablero es: " + patron);

        // PASO 3: Solicitar el tamaño de la casilla al usuario
        int tamanoCasilla = 0; // Inicializamos una variable para almacenar el tamaño de la casilla.
        while (tamanoCasilla < 1 || tamanoCasilla > 15) { // Con "WHILE" comenzamos un bucle que pedirá el tamaño hasta que el valor sea entre 1 y 15.
            System.out.println(ANSI_WHITE + "Por favor, ingresa el tamaño de las casillas entre 1 y 15."); // Mostramos un mensaje al usuario pidiendo el tamaño de la casilla.
            tamanoCasilla = input.nextInt(); // Leemos el valor ingresado por el usuario y lo guardamos.
            input.nextLine(); // Limpio el buffer después de leer un número.

            // Si el valor ingresado no está entre 1 y 15, mostramos un mensaje de error y le pedimos que ingrese el valor nuevamente.
            if (tamanoCasilla < 1 || tamanoCasilla > 15) {
                System.out.println(ANSI_RED + "¡Error! El tamaño debe estar entre 1 y 15. Inténtalo nuevamente." + ANSI_RESET);
            }
        }

        /* PASO 2: Crear el tablero de ajedrez como una matriz de caracteres.
           Vamos a generar un tablero de ajedrez con las dimensiones que el usuario haya definido. */

        char[][] tablero = new char[8][8]; // Creamos un tablero de ajedrez de 8x8 por defecto.

        // Empezamos a llenar la matriz del tablero con el patrón que ha seleccionado el usuario.
        for (int i = 0; i < 8; i++) { // Usamos "FOR" para recorrer las filas del tablero.
            for (int j = 0; j < 8; j++) { // Usamos "FOR" para recorrer las columnas del tablero.
                // Usamos una condición "IF/ELSE" para alternar entre casillas blancas y negras.
                if ((i + j) % 2 == 0) { // Si la suma de la fila y la columna "es par", colocamos el patrón para casillas blancas.
                    tablero[i][j] = ' '; // Aquí asignamos un espacio vacío, sin patrón.
                } else { // Si la suma de la fila y la columna "es impar", colocamos el patrón para casillas negras.
                    tablero[i][j] = patron.charAt(0); // Aquí asignamos el segundo carácter del patrón al tablero (para las casillas negras).
                }
            }
        }

        // PASO 4: Mostramos visualmente la representación del tablero de ajedrez ajustado por el tamaño de la casilla.
        System.out.println("Tablero de ajedrez: ");
        for (int i = 0; i < 8; i++) { // Recorremos las filas del tablero para mostrarlo.
            for (int t = 0; t < tamanoCasilla; t++) { // Repetimos cada fila según el tamaño de la casilla.
                for (int j = 0; j < 8; j++) { // Recorremos las columnas para mostrar cada casilla.
                    // Repetimos el patrón dentro de la casilla en la dirección horizontal.
                    for (int k = 0; k < tamanoCasilla; k++) { // Repetimos el patrón horizontalmente.
                        System.out.print(tablero[i][j] + " "); // Imprimimos el patrón de la casilla sin espacio extra.
                    }
                }
                System.out.println(); // Nueva línea después de imprimir toda una fila (sin separaciones).
            }
        }
        // Imprimimos mensaje de agradecimiento y felicitación final al usuario.
        System.out.println(ANSI_GREEN + "¡Gracias por confiar en La Salle Chess Board!" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "¡Felicidades! Has creado tu propio tablero de ajedrez." + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Esperamos que disfrutes de tu partida y sigas desarrollando tus habilidades." + ANSI_RESET);
        System.out.println(ANSI_GREEN + "¡Que tengas un excelente día y buena suerte en tu juego!" + ANSI_RESET);
    }
}