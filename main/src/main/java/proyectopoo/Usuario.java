package proyectopoo;
<<<<<<< HEAD
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
=======

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
>>>>>>> 3a1ce2f76f71f8a905dadcff8d08b69eead91658
    }
    public String getCodigoUnico() {
        return codigoUnico;
    }
    public String getCedula() {
        return cedula;
    }
<<<<<<< HEAD
    public String getNombre() {
        return nombre;
=======
    public String getNombres() {
        return nombres;
>>>>>>> 3a1ce2f76f71f8a905dadcff8d08b69eead91658
    }
    public String getApellidos() {
        return apellidos;
    }
<<<<<<< HEAD
    public String getContraseña() {
        return contraseña;
=======
    public String getUsusario() {
        return ususario;
    }
    public String getContrasena() {
        return contrasena;
>>>>>>> 3a1ce2f76f71f8a905dadcff8d08b69eead91658
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
<<<<<<< HEAD
    public void setNombre(String nombre) {
        this.nombre = nombre;
=======
    public void setNombres(String nombres) {
        this.nombres = nombres;
>>>>>>> 3a1ce2f76f71f8a905dadcff8d08b69eead91658
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
<<<<<<< HEAD
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
=======
    public void setUsusario(String ususario) {
        this.ususario = ususario;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
>>>>>>> 3a1ce2f76f71f8a905dadcff8d08b69eead91658
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 3a1ce2f76f71f8a905dadcff8d08b69eead91658
