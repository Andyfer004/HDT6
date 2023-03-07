import java.util.*;

public class MapFactory {

    public static Map<String, Integer> crearMapa(String tipo) {
        if (tipo.equalsIgnoreCase("HashMap")) {
            return new HashMap<>();
        } else if (tipo.equalsIgnoreCase("LinkedHashMap")) {
            return new LinkedHashMap<>();
        } else if (tipo.equalsIgnoreCase("TreeMap")) {
            return new TreeMap<>();
        } else {
            throw new IllegalArgumentException("Tipo de mapa no válido");
        }
    }
}


