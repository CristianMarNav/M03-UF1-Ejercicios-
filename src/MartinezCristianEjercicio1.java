import java.util.Random;
import java.util.Scanner;

public class MartinezCristianEjercicio1 {  // "Metodo main"(metodo principal donde empieza el juego).
    public static void main(String[] args) {

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

        System.out.println("¡ULTIMO AVISO!¡PELIGRO!¡B00MBAS EN EL CAMPO DE BATALLA");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(terreno[i][j] + " ");// Imprime cada celda
            }
            System.out.println(); // Salto de linea
        }
          // Menú de opciones para el jugador
        boolean continuar = true;

        while (continuar) {

            mostrarMenu(); // Llamada al metodo mostrar menú
            int opcion = input.nextInt();
            input.nextLine(); // Limpio el buffer después de leer un número.

            switch (opcion){
                case 0:
                    System.out.println("¡Hasta pornto!¡GAME 0VER!");
                    continuar = false; // Termina el juego
                    break;

                case 1: // Mostrar matriz
                    System.out.println("Terreno del campo de batalla");
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            System.out.print(terreno[i][j] + " "); // Imprime cada celda.
                        }
                        System.out.println(); // Salto de linea.
                    }
                    break;

                case 2: // Colocar Bomba
                    System.out.println("Introduce las coordenadas (fila/columna) para colocar la bomba");

                    int filaBomba = input.nextInt();
                    input.nextLine(); // Limpio el buffer después de leer un número.
                    int columnaBomba = input.nextInt();
                    input.nextLine(); // Limpio el buffer después de leer un número.

                    if (filaBomba >= 0 && filaBomba < filas && columnaBomba >= 0 && columnaBomba < columnas) {
                        // Calcular la explosión (suma de la fija y columna
                        int explosion = 0;

                        for (int i=0; i < columnas; i++) {
                            explosion = explosion + (terreno[filaBomba][i] - '0'); // Sumar valores en la fila.
                        } for (int i = 0; i < filas; i++) {
                            explosion = explosion + (terreno[i][columnaBomba] - '0'); // Sumar valores en la columna.
                        }
                        System.out.println("Valor explosión "+explosion);
                        // Colocar la bomba
                        terreno[filaBomba][columnaBomba] = '0'; // Cambiar a 0 si la bomba ha explotado.
                    } else {
                        System.out.println("Coordenadas no válidas, fuera de rango");
                    }
                    break;

                default:
                    System.out.println("Opción no valida, por favor, elige una opción del menu que sea válida");
        }
    }
}

// Método para mostrar el menú de opciones

    public static void mostrarMenu() {

        System.out.println("[0] Salir");
        System.out.println("[1] Mostrar matriz");
        System.out.println("[2] Poner bomba");

    }
}


















