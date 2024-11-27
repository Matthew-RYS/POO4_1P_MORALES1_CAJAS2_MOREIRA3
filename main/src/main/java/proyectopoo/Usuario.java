package proyectopoo;

import java.util.ArrayList;
import java.util.Date;
import proyectopoo.archivo.ManejoArchivos;
public abstract class Usuario{
    protected String codigoUnico;
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String ususario;
    protected String contrasena;
    protected String correo;
    protected String rol;

    public Usuario(String codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, String rol){
        this.codigoUnico = codigoUnico;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ususario = ususario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.rol = rol;
    }
    private boolean logIn(String usuario, String contrasena){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("Usuario.txt");
        for(String linea: lineas){
            String[] palabras = linea.split("|");
            if(palabras[4].equals(usuario) && palabras[5].equals(contrasena)){
                return true;
            }
        }
        return false;
    }
    public abstract void gestionarReserva(Date fecha, Espacio espacio, String motivo);
    public abstract void consultarReserva(Date fecha);
    public void enviarCorreo(){
    }
    public String getCodigoUnico() {
        return codigoUnico;
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
    public String getUsusario() {
        return ususario;
    }
    public String getContrasena() {
        return contrasena;
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
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setUsusario(String ususario) {
        this.ususario = ususario;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
}
