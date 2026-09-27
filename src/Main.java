//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1. Encendemos el sistema gestor
        GestorTallerBicicletas taller = new GestorTallerBicicletas();

        // 2. Creamos las bicicletas usando los datos exactos de la tabla
        BicicletaElectrica e01 = new BicicletaElectrica("BIC-E01", 2023, 22.5, 60, false);
        BicicletaElectrica e02 = new BicicletaElectrica("BIC-E02", 2022, 24.0, 45, true);
        BicicletaMontanya m01 = new BicicletaMontanya("BIC-M01", 2021, 13.5, 2);
        BicicletaMontanya m02 = new BicicletaMontanya("BIC-M02", 2020, 12.0, 1);

        // 3. Marcamos la BIC-E01 con garantía extendida
        e01.activarGarantiaExtendida();

        // 4. Registramos todas en el gestor
        taller.registrarBicicleta(e01);
        taller.registrarBicicleta(e02);
        taller.registrarBicicleta(m01);
        taller.registrarBicicleta(m02);

        // 5. Búsqueda y formato de impresión
        System.out.println("\n=== BUSQUEDA POR CODIGO: \"BIC-E01\" ===");
        Bicicleta encontrada = taller.buscarBicicleta("BIC-E01");

        if (encontrada != null) {
            // Como necesito imprimir datos que solo tienen las eléctricas (como batería),
            // verifico su tipo con "instanceof" para poder extraerlos sin errores.
            if (encontrada instanceof BicicletaElectrica) {
                BicicletaElectrica biciE = (BicicletaElectrica) encontrada;

                // Convierto los booleanos a "Si" o "No" para igualar la imagen de muestra
                String bateriaStr = biciE.isBateriaCertificada() ? "Si" : "No";
                String garantiaStr = biciE.tieneGarantiaExtendida() ? "Si" : "No";

                System.out.println("Tipo: Bicicleta Eléctrica | Código: " + biciE.getCodigoBicicleta() +
                        " | Año: " + biciE.getAnyoFabricacion() +
                        " | Peso: " + biciE.getPeso() + " kg | Autonomía: " + biciE.getAutonomia() +
                        " km | Batería certificada: " + bateriaStr);
                System.out.println("  Garantía extendida: " + garantiaStr +
                        " | Costo mantención: $" + (int)biciE.calcularCostoMantencion());
            }
        }
        System.out.println("---\n");

        // 6. Listado usando el metodo toString
        System.out.println("=== LISTADO DE BICICLETAS ===");
        for (Bicicleta b : taller.obtenerTodas()) {
            System.out.println(b.toString());
        }
    }
}
