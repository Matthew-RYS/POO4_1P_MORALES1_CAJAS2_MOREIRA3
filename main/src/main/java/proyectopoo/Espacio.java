package proyectopoo;

import java.util.ArrayList;
public class Espacio {
    protected Espacios tipoEspacio;
    protected int codigoEspacio;
    protected ArrayList<Usuario> acceso;
    protected String nombre;
    protected EstadoEspacio estadoEspacio;
    protected int capacidad;
    Usuario permiso;

    public Espacio(Espacios tipoEspacio, ArrayList<Usuario> acceso, String nombre, EstadoEspacio estadoEspacio, Usuario permiso, int capacidad){
        this.tipoEspacio = tipoEspacio;
        this.acceso = acceso;
        this.nombre = nombre;
        this.estadoEspacio = estadoEspacio;
        this.permiso = permiso;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Nombre: " + String.valueOf(nombre) + "Codigo: " + this.codigoEspacio;
    }
    public int getCodigoEspacio() {
        return codigoEspacio;
    }
    public String getAcceso() {
        ArrayList<String> usuariosAcceso = new ArrayList<String>();
        for(Usuario u: acceso){
            usuariosAcceso.add(u.getNombres());
        }
        return String.join(",", usuariosAcceso);
    }
    public String getNombre() {
        return nombre;
    }
    public EstadoEspacio getEstadoEspacio() {
        return estadoEspacio;
    }
    public void setCodigoEspacio(int codigoEspacio) {
        this.codigoEspacio = codigoEspacio;
    }
    public void setAcceso(ArrayList<Usuario> acceso) {
        this.acceso = acceso;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEstadoEspacio(EstadoEspacio estadoEspacio) {
        this.estadoEspacio = estadoEspacio;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public Usuario getPermiso() {
        return permiso;
    }
    public void setPermiso(Usuario permiso) {
        this.permiso = permiso;
    }
    public Espacios getTipoEspacio() {
        return tipoEspacio;
    }
    public void setTipoEspacio(Espacios tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }   
}
