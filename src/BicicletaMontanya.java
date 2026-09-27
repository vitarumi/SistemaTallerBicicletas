public class BicicletaMontanya extends Bicicleta {

    private int cantidadSuspension;

    // Mi constructor recibe todos los datos (los del padre + los de la hija)
    public BicicletaMontanya(String codigoBicicleta, int anyoFabricacion, double peso, int cantidadSuspension) {
        // super() pasa los tres primeros datos al constructor de la clase padre
        super(codigoBicicleta, anyoFabricacion, peso);

        // Hago que delegue el atributo propio a su propio setter
        setCantidadSuspension(cantidadSuspension);
    }

    public int getCantidadSuspension() {
        return cantidadSuspension;
    }

    public void setCantidadSuspension(int cantidadSuspension) {
        this.cantidadSuspension = cantidadSuspension;
    }


    // Mi metodo especializado para calcular cuánto cuesta arreglar esta bici de montaña
    @Override
    public double calcularCostoMantencion() {
        double costoBase = 30000; // El costo inicial por defecto

        // Mi "if" revisa si la bici tiene más de 1 suspensión
        if (this.cantidadSuspension > 1) {
            // Si es verdad, calculo el 15% extra y se lo sumo al costo base
            double recargo = costoBase * 0.15;
            costoBase = costoBase + recargo;
        }

        return costoBase; // Retorno el valor final calculado
    }



}
