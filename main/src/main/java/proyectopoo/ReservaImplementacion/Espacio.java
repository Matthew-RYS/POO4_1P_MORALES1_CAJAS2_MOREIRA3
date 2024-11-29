package proyectopoo.ReservaImplementacion;
import java.util.Random;
public class Espacio {
    protected Espacios tipoEspacio;
    protected int codigoEspacio;
    protected String nombre;
    protected EstadoEspacio estadoEspacio;
    protected int capacidad;
    Rol permiso;

    public Espacio(String codigoEspacio, String tipoEspacio, String nombre, String capacidad, String estadoEspacio, String permiso){
        this.codigoEspacio = Integer.parseInt(codigoEspacio.trim());
        this.tipoEspacio = Espacios.valueOf(tipoEspacio);
        this.nombre = nombre;
        this.capacidad = Integer.parseInt(capacidad);
        this.estadoEspacio = EstadoEspacio.valueOf(estadoEspacio);
        this.permiso = Rol.valueOf(permiso);
    }

    public Espacio(int codigoEspacio, String nombre, EstadoEspacio estadoEspacio){
        this.codigoEspacio = generarCodigo();
        this.codigoEspacio = codigoEspacio;
        this.nombre = nombre;
        this.estadoEspacio = estadoEspacio;
        if(tipoEspacio.equals(Espacios.CANCHA)){
        }
        else if(tipoEspacio.equals(Espacios.AUDITORIO)||tipoEspacio.equals(Espacios.LABORATORIO)){
            this.permiso = Rol.PROFESOR;
        }
        else if(tipoEspacio.equals(Espacios.AULA)){
            this.permiso = Rol.AMBOS;
        }
    }

    public Espacio(int codigoEspacio, String nombre, EstadoEspacio estadoEspacio,int capacidad){
        this(codigoEspacio,nombre,estadoEspacio);
        if(capacidad!=0){
            this.estadoEspacio=EstadoEspacio.DISPONIBLE;
        }
        else if(capacidad==0){
            this.estadoEspacio=EstadoEspacio.RESERVADO;
        }
    }

    private int generarCodigo(){
        Random rd= new Random();
        int codigo=rd.nextInt(9000)+1000;
        return codigo;
        
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Codigo: " + String.valueOf(this.codigoEspacio);
    }
    public int getCodigoEspacio() {
        return codigoEspacio;
    }
    public String getNombre() {
        return nombre;
    }
    public EstadoEspacio getEstadoEspacio() {
        return estadoEspacio;
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
    public Rol getPermiso() {
        return permiso;
    }
    public void setPermiso(Rol permiso) {
        this.permiso = permiso;
    }
    public Espacios getTipoEspacio() {
        return tipoEspacio;
    }
    public void setTipoEspacio(Espacios tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }   
    public void mostrarEspaciosDisponibles(){
        if(this.estadoEspacio.equals(EstadoEspacio.DISPONIBLE)){
            System.err.println(toString());
        }
    }
}
