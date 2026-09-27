import java.util.ArrayList;

public class GestorTallerBicicletas {

    // Mi colección donde guardaré todas las bicicletas registradas
    private ArrayList<Bicicleta> inventario;

    public GestorTallerBicicletas() {
        // Inicializo la lista vacía al crear el gestor
        this.inventario = new ArrayList<>();
    }

    // Operación 1: Registrar bicicleta e informar por consola
    public void registrarBicicleta(Bicicleta bici) {
        inventario.add(bici);
        // "getClass().getSimpleName()" obtiene el nombre automático (ej. "BicicletaElectrica")
        String tipo = bici.getClass().getSimpleName();
        System.out.println(bici.getCodigoBicicleta() + " (" + tipo + ") registrada correctamente.");
    }

    // Operación 2: Buscar y retornar bicicleta por código
    public Bicicleta buscarBicicleta(String codigoBusqueda) {
        // Mi ciclo "for" revisa cada bicicleta dentro del inventario
        for (Bicicleta bici : inventario) {
            if (bici.getCodigoBicicleta().equals(codigoBusqueda)) {
                return bici; // Si el código coincide, la devuelve y termina la búsqueda
            }
        }
        return null; // Si termina de buscar y no la encuentra, retorna nulo
    }

    // Metodo auxiliar para poder listar todas las bicicletas desde el Main
    public ArrayList<Bicicleta> obtenerTodas() {
        return inventario;
    }
}
