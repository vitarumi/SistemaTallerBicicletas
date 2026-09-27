public abstract class Bicicleta {

    private String codigoBicicleta;
    private int anyoFabricacion;
    private double peso;

    public Bicicleta() {
    }

    public Bicicleta(String codigoBicicleta, int anyoFabricacion, double peso) {
        setCodigoBicicleta(codigoBicicleta);
        setAnyoFabricacion(anyoFabricacion);
        setPeso(peso);
    }

    public String getCodigoBicicleta() {
        return codigoBicicleta;
    }

    public void setCodigoBicicleta(String codigoBicicleta) {
        if (codigoBicicleta == null || codigoBicicleta.isBlank()) {
            throw new IllegalArgumentException("El código no puede ser nulo ni vacío");
        }
        this.codigoBicicleta = codigoBicicleta;
    }

    public int getAnyoFabricacion() {
        return anyoFabricacion;
    }

    public void setAnyoFabricacion(int anyoFabricacion) {
        if (anyoFabricacion < 2000 || anyoFabricacion > 2026) {
            throw new IllegalArgumentException("El año debe estar entre 2000 y 2026");
        }
        this.anyoFabricacion = anyoFabricacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero");
        }
        this.peso = peso;
    }

    public abstract double calcularCostoMantencion();

    @Override
    public String toString() {
        return "Código: " + codigoBicicleta + " | Año: " + anyoFabricacion;
    }
}


