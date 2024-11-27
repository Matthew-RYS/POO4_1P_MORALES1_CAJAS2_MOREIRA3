package proyectopoo;

import java.util.ArrayList;
import java.util.Date;
public class Espacio {
    protected Espacios tipoEspacio;
    protected String codigoEspacio;
    protected ArrayList<Usuario> acceso;
    protected String nombre;
    protected EstadoEspacio estadoEspacio;
    protected int capacidad;
    Usuario permiso;

    public Espacio(Espacios tipoEspacio, String codigoEspacio, ArrayList<Usuario> acceso, String nombre, EstadoEspacio estadoEspacio, Usuario permiso, int capacidad){
        this.tipoEspacio = tipoEspacio;
        this.codigoEspacio = codigoEspacio;
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

    public Espacios getTipo() {
        return tipoEspacio;
    }
    public String getCodigoEspacio() {
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
    public void setTipo(Espacios tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }
    public void setCodigoEspacio(String codigoEspacio) {
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


    
}
