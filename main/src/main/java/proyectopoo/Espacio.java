package proyectopoo;

import java.util.ArrayList;
import java.util.Date;
public class Espacio {
    protected String tipo;
    protected String codigoEspacio;
    protected ArrayList<Usuario> acceso;
    protected Espacios nombre;
    protected EstadoEspacio estadoEspacio;
    Usuario permiso;
    public void consultarDisponibilidad(Date fecha){

    }
    public String getTipo() {
        return tipo;
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
    public Espacios getNombre() {
        return nombre;
    }
    public EstadoEspacio getEstadoEspacio() {
        return estadoEspacio;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setCodigoEspacio(String codigoEspacio) {
        this.codigoEspacio = codigoEspacio;
    }
    public void setAcceso(ArrayList<Usuario> acceso) {
        this.acceso = acceso;
    }
    public void setNombre(Espacios nombre) {
        this.nombre = nombre;
    }
    public void setEstadoEspacio(EstadoEspacio estadoEspacio) {
        this.estadoEspacio = estadoEspacio;
    }


    
}
