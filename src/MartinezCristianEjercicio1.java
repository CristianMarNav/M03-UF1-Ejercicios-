import java.util.Random;
import java.util.Scanner;

public class MartinezCristianEjercicio1{  // "Metodo main"(metodo principal donde empieza el juego).
    public static void main(String[] args){

        /*Impresion de mensaje de bienvenida al usuario.
        Este mensaje aparecerá al inicio para que el usuario sepa que está en el juego Bomberman.*/

        System.out.println("¡Bienvenido a B00MBERMAN!");

        // Importamos la clase "SCANNER" para leer entrada de usuario.

        Scanner input = new Scanner(System.in);

        //Usuario introduce el valor de filas y Scanner guarda su información.

        System.out.println("Introduce el número de filas del campo de batalla");
        int filas = input.nextInt();
        input.nextLine(); // Limpio el buffer después de leer un número.

        System.out.println("Introduce el numero de columnas del campo de batalla");
        int columnas = input.nextInt();
        input.nextLine();// Limpio el buffer después de leer un número.

        // Imprimo y muestro al usuario el número de filas y columnas que ha introducido.

        System.out.println("Terreno de batalla: " + filas + " filas y " + columnas + " columnas");
        System.out.println("¡Atención: Riesgo de bombas en el área!");
        System.out.println("¡Y recuerde!: Tenga mucha precaución y buena suerte...");

        // Ahora creamos una matriz para representar el terreno de juego y batalla (usamos char[][]).

        char[][] terreno = new char[filas][columnas];

        // Con "FOR" podremos inicializar cada celda del terreno con espacios vacios.

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                terreno[i][j] = ' '; // Uso (' ') para representar un espacio vacio.
            }
        }

        // Importamos la clase "RANDOM" para la colocación de las bombas aleatoriamente.

        Random rand = new Random();
        int numBombas = 6; // Numero de bombas a colocar (valor que se puede cambiar).

        for (int i = 0; i < numBombas; i++) {
            int fila = rand.nextInt(filas); // Generamos una fila aleatoria.
            int columna = rand.nextInt(columnas); // Generamos una columna aleatoria.
            terreno[fila][columna] = 'X'; // "X" representa la bomba.
        }

        // Solicitamos la posición inicial al jugador que sera 'P'.

        System.out.println("Introduce la fila de inicio del jugador:");
        int filaJugador = input.nextInt();
        input.nextLine(); // Limpio el buffer después de leer un número.

        System.out.println("Introduce la columna de inicio del jugador:");
        int columnaJugador = input.nextInt();
        input.nextLine(); // Limpio el buffer después de leer un número.

        terreno[filaJugador][columnaJugador] = 'P'; /* Coloca al jugador en las coordenadas especificadas por el usuario
                                                       en el campo de batalla, representando su posicion con la letra 'P'
                                                       en la matriz */

        // Ahora vamos a imprimir y mostrar al usuario el terreno con las bombas colocadas
        System.out.println("¡ULTIMO AVISO!¡PELIGRO!¡SE B00MBAS EN EL CMAPO DE BATALLA");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(terreno[i][j] + " ");// Imprime cada celda
            }
            System.out.println(); // Salto de linea
        }
        // Función que mueve al jugador
        String movimientoJugador; // Variable que almacena la direccion del movimiento: arriba, abajo, izquierda,derecha.
        int pasos = 0; // Contador de pasos.
        boolean juegoActivo = true; // Condicion booleana que controla el estado del juego.

        switch (movimientoJugador){

            case "arriba":
                if (filaJugador>0) filaJugador--; // Mover arriba.
                break;

            case "abajo":
                if (filaJugador<filas-1) filaJugador++; // Mover abajo.
                break;

            case "izquierda":
                if (columnaJugador>0) columnaJugador--; // Mover izquierda.
                break;

            case "derecha":
                if (columnaJugador<columnas-1) columnaJugador++; // Mover derecha.
                break;

            default: // Si el usuario introduce un movimiento no válido, muestra un mensaje de error.
                System.out.println("Movimiento no válido"); // Si el movimiento no es válido, muestra un mensaje.
                continue; // Vuelve al inicio del bucle para pedir un nuevo movimiento.

        }
    }
}



















