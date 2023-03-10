import java.util.*;

public class HashMap1 {

    // Método para agregar elementos al mapa
    public static void agregarElementos() {
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Manzanas", 5);
        mapa.put("Naranjas", 8);
        mapa.put("Plátanos", 12);
    }

    // Método para imprimir los elementos del mapa
    public static void imprimirElementos(Map<String, Integer> mapa) {
        System.out.println("Elementos del mapa:");
        for (String clave : mapa.keySet()) {
            System.out.println(clave + ": " + mapa.get(clave));
        }
    }
}


