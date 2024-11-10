package proyectopoo;
import java.util.UUID;

public class Usuario {
    protected String codigoUnico;
    protected String cedula;
    protected String nombre;
    protected String apellidos;
    protected String contraseña;
    protected String correo;
    protected String rol;
    Usuario(){   
    }
    Usuario(String cedula, String nombre, String apellidos, String contraseña, String correo, String rol){
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.correo = correo;
        this.rol = rol;
        this.codigoUnico = UUID.randomUUID().toString();
    }
    public String getCodigoUnico() {
        return codigoUnico;
    }
    public String getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getContraseña() {
        return contraseña;
    }
    public String getCorreo() {
        return correo;
    }
    public String getRol() {
        return rol;
    }
    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
}
