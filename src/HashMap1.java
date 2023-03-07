import java.util.*;

public class HashMap1 {

    public static void main(String[] args) {
        Map<String, Integer> mapa = new HashMap<>();

        // Agregar elementos al mapa
        mapa.put("Manzanas", 5);
        mapa.put("Naranjas", 8);
        mapa.put("Plátanos", 12);

        // Imprimir los elementos del mapa
        System.out.println("Elementos del mapa:");
        for (String clave : mapa.keySet()) {
            System.out.println(clave + ": " + mapa.get(clave));
        }
    }
}

