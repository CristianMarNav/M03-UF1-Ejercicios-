import java.util.Scanner;

public class MartinezCristianEjercicio1{
    // "Metodo main"(metodo principal donde empieza el juego)
    public static void main(String[]args){

        /*Impresion de mensaje de bienvenida al usuario.
        Este mensaje aparecerá al inicio para que el usuario sepa que está en el juego Bomberman.
         */
        System.out.println("¡Bienvenido a B00MBERMAN!");

        // Importación de la clase Scanner para leer entrada de usuario.

        Scanner input = new Scanner(System.in);

        //Usuario introduce el valor de filas y Scanner guarda su informacióN
        System.out.println("Introduce el número de filas del campo de batalla");
        int filas = input.nextInt();
        input.nextLine(); // Limpio el buffer después de leer un número.

        System.out.println("Introduce el numero de columnas del campo de batalla");
        int columnas = input.nextInt();
        input.nextLine();//Limpio el buffer después de leer un número.

        // Imprimo al usuario el número de filas y columnas que ha introducido.
        // Aquí seguirán los próximos pasos del juego.
        System.out.println("Terreno de batalla: "+filas+" filas y "+columnas+" columnas");
        System.out.println("Atención: Riesgo de bombas en el area y tenga precaución, buena suerte");

        //Cierro la herramienta Scanner
        input.close();


















    }
}
