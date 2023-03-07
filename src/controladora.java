import java.io.*;
import java.util.*;

public class controladora {

    private Map<String, Integer> mapa;

    public controladora(String tipoMapa, String rutaArchivo) {
        mapa = crearMapa(tipoMapa);
        agregarProductos(tipoMapa, rutaArchivo);
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

    public void agregarProductos(String tipoMapa, String rutaArchivo) {
        switch (tipoMapa) {
            case "HashMap":
                mapa = new HashMap<>();
                break;
            case "LinkedHashMap":
                mapa = new LinkedHashMap<>();
                break;
            case "TreeMap":
                mapa = new TreeMap<>();
                break;
            default:
                System.out.println("Opción no válida. Se usará HashMap por defecto.");
                mapa = new HashMap<>();
        }
        leerArchivo(rutaArchivo);
    }


    public int leerArchivo(String rutaArchivo) {
        int total = 0;
        try {
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
            String linea = lector.readLine();
            while (linea != null) {
                total++;
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


}



