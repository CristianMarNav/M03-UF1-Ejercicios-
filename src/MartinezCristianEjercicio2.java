// Ejercicio #2 Chess Board

import java.util.Scanner;

public class MartinezCristianEjercicio2 {
    public static void main(String[]args) {
        // PASO 1: Solicitud de patrón del tablero y mensaje de bienvenida."

        // Creamos un objeto "Scanner" para leer los datos del usuario.
        Scanner input = new Scanner(System.in);

        // Mensaje de bienvenida al usuario.
        System.out.println("¡Bienvenido al juego de Ajedrez!, te damos la bienvenida en nombre de La Salle Chess Board, ¡que disfrutes!");

        // Pedimos al usuario que ingrese el patrón para el tablero.
        System.out.println("Por favor, ingresa el patrón que quieres para las casillas del tablero (ejemplo: #,X,*, etc.");
        String patron = input.nextLine(); // Guardamos el patrón ingresado por el usuario.

        // Validamos que el patrón tenga al menos dos caracteres
        while (patron.length() < 2) { // Bucle "WHILE" continuará hasta que el patrón sea válido.
            System.out.println("El patrón debe tener al menos caracteres. Por favor, ingresa otro patrón.");
            patron = input.nextLine(); // Pedimos nuevamente al usuario el patrón si no es válido.
        }
        // Mostramos el patrón ingresado.
        System.out.println("El patrón elegido para el tablero es: " + patron);

        /* PASO 2: Crear el tablero de ajedrez como una matriz de caracteres.
           Vamos a generar un tablero de ajedrez con las dimensiones que el usuario haya definido. */

        char[][] tablero = new char[8][8]; // Creamos un tablero de ajedrez de 8x8 por defecto.

        // Empezamos a llenar la matriz del tablero con el patrón que ha seleccionado el usuario.
        for (int i = 0; i < 8; i++) { // Usamos "FOR" para recorrer las filas del tablero.
            for (int j = 0; j < 8; j++) { // Usamos "FOR" para recorrer las columnas del tablero.
                // Usamos una condición "IF/ELSE" para alternar entre casillas blancas y negras.
                if ((i + j) % 2 == 0) { // Si la suma de la fila y la columna "es par", colocamos el patrón para casillas blancas.
                    tablero[i][j] = patron.charAt(0); // Aquí asignamos el primer carácter del patrón al tablero (para casillas blancas).
                } else { // Si la suma de la fila y la columna "es impar", colocamos el patrón para casillas negras.
                    tablero[i][j] = patron.charAt(1); // Aquí asignamos el segundo carácter del patrón al tablero (para las casillas negras).
                }
            }
        }

        // Mostramos el tablero de ajedrez generado.
        System.out.println("Tablero de ajedrez: ");
        for (int i = 0; i < 8; i++) { // Recorremos nuevamente las filas del tablero para mostrarlo.
            for (int j = 0; j < 8; j++) { // Recorremos las columnas para mostrar cada casilla.
                System.out.print(tablero[i][j] + " "); // Imprimir cada casilla.
            }
            System.out.println(); // Nueva linea después de cada fila para que se vea bien el formato del tablero.
        }
    }
}