package proyectopoo;
import java.util.ArrayList;
import proyectopoo.archivo.ManejoArchivos;


public class Sistema {
    public static ArrayList<Usuario> usuarios;
    public static ArrayList<Espacio> espacios;
    public static ArrayList<Reserva> reservas;
    public static ArrayList<Estudiante> estudiantes;
    public static ArrayList<Profesor> profesores;
    public boolean logIn(String usuario, String contrasena){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("Usuario.txt");
        for(String linea: lineas){
            String[] palabras = linea.split("|");
            if(palabras[4].equals(usuario) && palabras[5].equals(contrasena)){
                return true;
            }
        }
        return false;
    }
    public static void mostrarMenuEstudiante(){
        
    }


    public static void main(String[] args) {
    }

}
