package proyectopoo.ReservaImplementacion;
public enum Cargo {
    ANALISTA("ANALISTA"),
    INGENIERO_DE_DATOS("INGENIERO DE DATOS"),
    TECNICO_DE_INFRAESTRUCTURA("TÉCNICO DE INFRAESTRUCTURA");

    private final String descripcion;

    // Constructor del enum
    Cargo(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para obtener la descripción
    public String getDescripcion() {
        return descripcion;
    }

    // Método para obtener un enum a partir de su descripción
    public static Cargo fromDescripcion(String descripcion) {
        for (Cargo cargo : Cargo.values()) {
            if (cargo.getDescripcion().equalsIgnoreCase(descripcion.trim())) {
                return cargo;
            }
        }
        throw new IllegalArgumentException("Cargo no válido: " + descripcion);
    }
}