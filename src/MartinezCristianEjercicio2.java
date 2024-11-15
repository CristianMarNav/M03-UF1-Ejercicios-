// Ejercicio #2 Chess Board

import java.util.Scanner;

public class MartinezCristianEjercicio2 {
    public static void main(String[]args) {

        // Creamos un objeto "Scanner" para leer los datos del usuario.
        Scanner input = new Scanner(System.in);

        // Mensaje de bienvenida al usuario.
        System.out.println("¡Bienvenido al juego de Ajedrez!, te damos la bienvenida en nombre de La Salle Chess Board, ¡que disfrutes!");

        // Pedimos al usuario que ingrese el patrón para el tablero.
        System.out.println("Por favor, ingresa el patrón que quieres para las casillas del tablero (ejemplo: #,X,*, etc.");
        String patron = input.nextLine(); // Guardamos el patrón ingresado por el usuario.

        // Mostramos el patrón ingresado.
        System.out.println("El patrón elegido para el tablero es: "+patron);







    }
}
