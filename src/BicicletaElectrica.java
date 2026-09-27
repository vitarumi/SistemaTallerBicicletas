public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {

    // Estos son los atributos exclusivos que solo tienen mis bicicletas eléctricas
    private int autonomia;
    private boolean bateriaCertificada;
    private boolean garantiaActiva;

    // En mi constructor pido todos los datos necesarios para armar la bici completa
    public BicicletaElectrica(String codigoBicicleta, int anyoFabricacion, double peso, int autonomia, boolean bateriaCertificada) {

        // 1. Con "super()" le envío los datos básicos a mi clase padre (Bicicleta).
        // Ella se encarga de revisarlos con los "if" que ya programé allá.
        super(codigoBicicleta, anyoFabricacion, peso);

        // 2. En lugar de meter el dato a la fuerza con un "=", llamo a mi propio metodo "set".
        // Lo hago así para que la información pase por el "guardia de seguridad" desde el primer segundo.
        setAutonomia(autonomia);
        setBateriaCertificada(bateriaCertificada);

        // Cuando recién creo la bicicleta eléctrica, asumo que la garantía empieza desactivada (false)
        this.garantiaActiva = false;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    // Nota personal: en Java, los "getters" de las variables booleanas (true/false)
    // se escriben con "is" en lugar de "get" (ejemplo: ¿es certificada?)
    public boolean isBateriaCertificada() {
        return bateriaCertificada;
    }

    public void setBateriaCertificada(boolean bateriaCertificada) {
        this.bateriaCertificada = bateriaCertificada;
    }


    // Mi metodo especializado para calcular cuánto cuesta arreglar esta bici electrica
    @Override
    public double calcularCostoMantencion() {
        double costoBase = 45000; // Costo inicial de la eléctrica

        // Mi "if" revisa si la batería NO está certificada (es igual a false)
        if (this.bateriaCertificada == false) {
            // Si es falso, calculo el 25% extra y se lo sumo al costo base
            double recargo = costoBase * 0.25;
            costoBase = costoBase + recargo;
        }

        return costoBase;
    }


    @Override
    public boolean tieneGarantiaExtendida() {
        return this.garantiaActiva;
    }

    @Override
    public void activarGarantiaExtendida() {
        this.garantiaActiva = true;
    }

}