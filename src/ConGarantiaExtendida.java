public interface ConGarantiaExtendida {
    // Solo declaramos los nombres de las acciones, sin código por dentro.
    // Las clases que firmen este contrato estarán obligadas a darles vida.
    boolean tieneGarantiaExtendida();

    void activarGarantiaExtendida();
}