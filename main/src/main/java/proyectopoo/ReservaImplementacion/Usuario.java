package proyectopoo.ReservaImplementacion;
import java.util.Date;


public abstract class Usuario{
    protected String codigoUnico;
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String contrasena;
    protected String correo;
    protected Rol rol;

    public Usuario(String codigoUnico){
        this.codigoUnico=codigoUnico;
    }
    public Usuario(String codigoUnico, String cedula, String nombres, String apellidos, String usuario, String contrasena, String correo, Rol rol){
        this.codigoUnico = codigoUnico;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.rol = rol;
    }

    public abstract void gestionarReserva();
    public void consultarReserva(){
    }
    public String getCodigoUnico() {
        return codigoUnico;
    }
    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
    public String getCedula() {
        return cedula;
    }
    public String getNombres() {
        return nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public String getCorreo() {
        return correo;
    }
    public Rol getRol() {
        return rol;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setUsusario(String ususario) {
        this.usuario = ususario;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
 