import java.util.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Map<String, Integer> mapa;

        controladora controladora = new controladora("HashMap", "/Users/andyfer004/IdeaProjects/HDT6/src/ListadoProducto (2).txt");

        // Menú de selección de tipo de mapa
        System.out.println("Selecciona el tipo de mapa que quieres usar:");
        System.out.println("1. HashMap");
        System.out.println("2. LinkedHashMap");
        System.out.println("3. TreeMap");

        // Leer la opción seleccionada por el usuario
        int opcion = entrada.nextInt();
        // Seleccionar el tipo de mapa adecuado según la opción
        switch(opcion) {
            case 1:
                mapa = new HashMap<>();
                break;
            case 2:
                mapa = new LinkedHashMap<>();
                break;
            case 3:
                mapa = new TreeMap<>();
                break;
            default:
                System.out.println("Opción no válida. Se usará HashMap por defecto.");
                mapa = new HashMap<>();
        }

        // Menú de opciones para el mapa seleccionado
        boolean seguir = true;
        while (seguir) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Agregar un producto");
            System.out.println("2. Para ingresar el nombre del producto para mostrarte la categoria");
            System.out.println("3. Mostrar categoria, producto y el numero de existencias en la coleccion");
            System.out.println("4. Imprimir todos los productos");
            System.out.println("5. Imprimir productos por categoría");
            System.out.println("6. Salir");

            // Leer la opción seleccionada por el usuario
            int opcionMenu = entrada.nextInt();

            // Ejecutar la opción seleccionada
            switch (opcionMenu) {
                case 1:
                    controladora.agregarLineaArchivo();

                    break;
                case 2:
                    controladora.buscarCategoriaProducto( );
                    break;
                case 3:
                    controladora.mostrarProductosColeccion();
                    break;
                case 4:
                    controladora.printTextFile("/Users/andyfer004/IdeaProjects/HDT6/src/ListadoProducto (2).txt");
                    break;
                case 5:
                    controladora.printTextFile("/Users/andyfer004/IdeaProjects/HDT6/src/ListadoProducto (2).txt");
                    break;
                case 6:
                    controladora.printTextFile("/Users/andyfer004/IdeaProjects/HDT6/src/ListadoProducto (2).txt");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}






