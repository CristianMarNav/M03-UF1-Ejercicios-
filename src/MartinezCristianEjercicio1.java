import java.util.ArrayList;
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

        // Ahora creamos una matriz para representar el terreno de juego y batalla (usamos int[][]).

        int[][] terreno = new int[filas][columnas];

        // Inicializamos con la clase "RANDOM" la matriz con valores aleatorios entre 1 y 9.
        Random rand = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                terreno[i][j] = rand.nextInt(9)+1; // Número aleatoria que sera entre 1 y 9.
            }
        }

        // Lista Array para almacenar los valores de las explosiones.
        ArrayList<Integer> rankingExplosiones = new ArrayList<>();

        // Colocamos bombas aleatoria en el terreno.

        int numBombas = 6;
        for (int i = 0; i < numBombas; i++) {
            int fila = rand.nextInt(filas); // Generamos una fila aleatoria.
            int columna = rand.nextInt(columnas); // Generamos una columna aleatoria.
            terreno[fila][columna] = 0; // "0" representa la bomba.
        }

        // Solicitamos la posición inicial al jugador que sera 'P'.

        System.out.println("Introduce la fila de inicio del jugador:");
        int filaJugador = input.nextInt();
        input.nextLine(); // Limpio el buffer después de leer un número.

        System.out.println("Introduce la columna de inicio del jugador:");
        int columnaJugador = input.nextInt();
        input.nextLine(); // Limpio el buffer después de leer un número.

        // Mostramos el terreno inicial con las bombas y el jugador.

        terreno[filaJugador][columnaJugador] = -1; // El jugador quedara representado por "-1".

        // Ahora mostramos el terreno inicial.

        System.out.println("¡ULTIMO AVISO!¡PELIGRO!¡B00MBAS EN EL CAMPO DE BATALLA");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (terreno[i][j] == -1) {
                    System.out.print("P "); // Mostrar el jugador como 'P'
                } else if (terreno[i][j] == 0) {
                    System.out.print("X "); // Mostrar la bomba como 'X'.
                } else {
                    System.out.print(terreno[i][j] + " "); // Mostrar valores del terreno de juego.
                }
            }
            System.out.println(); // Salto de línea para la siguiente fila.
        }
          // Menú de opciones para el jugador.
        boolean continuar = true;

        while (continuar) {

            mostrarMenu(); // Llamada al metodo mostrar menú.
            int opcion = input.nextInt();
            input.nextLine(); // Limpio el buffer después de leer un número.

            switch (opcion){
                case 0:
                    System.out.println("¡Hasta pornto!¡GAME 0VER!");
                    continuar = false; // Termina el juego.
                    break;

                case 1: // Mostrar matriz.
                    System.out.println("Terreno del campo de batalla");
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < columnas; j++) {
                            if (terreno[i][j] == -1) {
                                System.out.print("P "); // Mostrar jugador como 'P'.
                            } else if (terreno[i][j] == 0) {
                                System.out.print("X "); // Mostrar bomba como 'X'.
                            } else {
                                System.out.print(terreno[i][j] + " "); // Mostrar valores del terreno de juego.
                            }
                        }
                        System.out.println(); // Salto de línea para la siguiente fila.
                    }
                    break;

                case 2: // Colocar Bomba.
                    System.out.println("Introduce las coordenadas (fila/columna) para colocar la bomba");

                    int filaBomba = input.nextInt();
                    input.nextLine(); // Limpio el buffer después de leer un número.
                    int columnaBomba = input.nextInt();
                    input.nextLine(); // Limpio el buffer después de leer un número.

                    if (filaBomba >= 0 && filaBomba < filas && columnaBomba >= 0 && columnaBomba < columnas) {
                        // Calcular la explosión (suma de la fija y columna.
                        int explosion = 0;

                        // Sumar los valores en la fila.
                        for (int i = 0; i < columnas; i++) {
                            if (terreno[filaBomba][i] != 0) { // No contar la bomba.
                                explosion += terreno[filaBomba][i];
                            }
                        }
                        // Sumar los valores en la columna.
                        for (int i = 0; i < filas; i++) {
                            if (terreno[i][columnaBomba] != 0) { // No contar la bomba.
                                explosion += terreno[i][columnaBomba];
                            }
                        }

                        System.out.println("Valor explosión " + explosion);
                        // Colocar la bomba.
                        terreno[filaBomba][columnaBomba] = '0'; // Cambiar a 0 si la bomba ha explotado.
                        // Guardamos el valor de la explosión en el ranking.
                        rankingExplosiones.add(explosion);

                    } else {
                        System.out.println("Coordenadas no válidas, fuera de rango");
                    }
                    break;

                case 3: // Ranking.
                    System.out.println("Ranking de explosiones");
                    for (int i = 0; i < rankingExplosiones.size(); i++) {
                        System.out.println("Explosión "+(i+1)+": "+rankingExplosiones.get(i));
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
        System.out.println("[3] Ranking de explosiones");
    }
}


















