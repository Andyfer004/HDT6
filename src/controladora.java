import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Arrays;

public class controladora {


    private Map<String, Integer> mapa;

    public controladora(String tipoMapa, String rutaArchivo) {
        mapa = crearMapa(tipoMapa);
        leerArchivo(rutaArchivo);

    }

    private Map<String, Integer> crearMapa(String tipoMapa) {
        switch (tipoMapa) {
            case "LinkedHashMap":
                return new LinkedHashMap<>();
            case "TreeMap":
                return new TreeMap<>();
            default:
                return new HashMap<>();
        }
    }

    public static void agregarLineaArchivo() {
        // Definir las categorías permitidas
        String[] categoriasPermitidas = {"Muebles de terraza", "Sillones de masaje", "Bebidas", "Condimentos", "Frutas", "Carnes", "Lácteos"};

        // Pedir al usuario que ingrese la categoría
        System.out.println("Ingrese la categoría del producto:");
        Scanner scanner = new Scanner(System.in);
        String categoria = scanner.nextLine();

        // Verificar que la categoría sea válida
        boolean categoriaValida = false;
        for (String categoriaPermitida : categoriasPermitidas) {
            if (categoriaPermitida.equals(categoria)) {
                categoriaValida = true;
                break;
            }
        }
        if (!categoriaValida) {
            System.out.println("La categoría ingresada no es válida.");
            return;
        }

        // Pedir al usuario que ingrese el producto
        System.out.println("Ingrese el producto:");
        String producto = scanner.nextLine();

        // Escribir la línea en el archivo
        try {
            FileWriter fw = new FileWriter("/Users/andyfer004/IdeaProjects/HDT6/src/ListadoProducto (2).txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(categoria + " | " + producto);
            bw.newLine();

            // Cerrar el archivo
            bw.close();
            fw.close();
            System.out.println("La línea se ha agregado al archivo.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void buscarCategoriaProducto() {
        // Definir las categorías permitidas
        String[] categoriasPermitidas = {"Muebles de terraza", "Sillones de masaje", "Bebidas", "Condimentos", "Frutas", "Carnes", "Lácteos"};

        // Pedir al usuario que ingrese el nombre del producto
        System.out.println("Ingrese el nombre del producto:");
        Scanner scanner = new Scanner(System.in);
        String producto = scanner.nextLine();

        // Leer el archivo y buscar el producto
        try {
            File archivo = new File("/Users/andyfer004/IdeaProjects/HDT6/src/ListadoProducto (2).txt");
            Scanner scannerArchivo = new Scanner(archivo);

            boolean encontrado = false;
            while (scannerArchivo.hasNextLine()) {
                String linea = scannerArchivo.nextLine();
                String[] partes = linea.split(" \\| ");
                if (partes.length == 2 && partes[1].equals(producto)) {
                    // Verificar que la categoría sea válida
                    String categoria = partes[0];
                    boolean categoriaValida = false;
                    for (String categoriaPermitida : categoriasPermitidas) {
                        if (categoriaPermitida.equals(categoria)) {
                            categoriaValida = true;
                            break;
                        }
                    }
                    if (categoriaValida) {
                        encontrado = true;
                        System.out.println("La categoría del producto es: " + categoria);
                        break;
                    }
                }
            }

            if (!encontrado) {
                System.out.println("El producto no se encuentra en el archivo o la categoría no es válida.");
            }

            scannerArchivo.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void mostrarProductosColeccion() {
        // Definir las categorías permitidas
        String[] categoriasPermitidas = {"Muebles de terraza", "Sillones de masaje", "Bebidas", "Condimentos", "Frutas", "Carnes", "Lácteos"};

        // Crear un mapa para almacenar los productos y sus cantidades
        Map<String, Integer> productosColeccion = new HashMap<>();

        // Leer el archivo y construir el mapa
        try (Scanner scannerArchivo = new Scanner(new File("/Users/andyfer004/IdeaProjects/HDT6/src/ListadoProducto (2).txt"))) {
            while (scannerArchivo.hasNextLine()) {
                String linea = scannerArchivo.nextLine();
                String[] partes = linea.split("\\|");
                if (partes.length == 2) {
                    String categoria = partes[0];
                    String producto = partes[1].trim();

                    // Verificar que la categoría sea válida
                    if (Arrays.asList(categoriasPermitidas).contains(categoria)) {
                        // Actualizar la cantidad del producto en el mapa
                        productosColeccion.merge(producto, 1, Integer::sum);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Mostrar la información de la colección
        if (productosColeccion.isEmpty()) {
            System.out.println("La colección está vacía.");
        } else {
            System.out.println("Productos en la colección:");
            for (Map.Entry<String, Integer> entry : productosColeccion.entrySet()) {
                String producto = entry.getKey();
                int cantidad = entry.getValue();
                // Buscar la categoría del producto
                String categoria = "";
                try (Scanner scannerArchivo = new Scanner(new File("/Users/andyfer004/IdeaProjects/HDT6/src/ListadoProducto (2).txt"))) {
                    while (scannerArchivo.hasNextLine()) {
                        String linea = scannerArchivo.nextLine();
                        String[] partes = linea.split("\\|");
                        if (partes.length == 2) {
                            if (producto.equals(partes[1].trim())) {
                                categoria = partes[0];
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e.getMessage());
                    return;
                }
                System.out.println("Categoría: " + categoria + " | Producto: " + producto + " | Cantidad: " + cantidad);
            }
        }
    }













    public int leerArchivo(String rutaArchivo) {
        int total = 0;
        try {
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
            String linea = lector.readLine();
            while (linea != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 2) {
                    String clave = partes[0].trim();
                    int valor = Integer.parseInt(partes[1].trim());
                    mapa.put(clave, valor);
                    total++;
                }
                linea = lector.readLine();
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
        return total;
    }

    public Map<String, Integer> getMapa() {
        return mapa;
    }

    public void agregarProducto(String clave, int valor) {
        mapa.put(clave, valor);
        System.out.println("El producto " + clave + " con valor " + valor + " ha sido agregado.");
    }

    public static void printTextFile(String filePath) {
        File file = new File(filePath);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




        public void eliminarProducto(String clave) {
        if (mapa.containsKey(clave)) {
            mapa.remove(clave);
            System.out.println("El producto con clave " + clave + " ha sido eliminado.");
        } else {
            System.out.println("No se encontró el producto con clave " + clave);
        }
    }

    public Integer buscarProducto(String clave) {
        return mapa.get(clave);
    }

}







