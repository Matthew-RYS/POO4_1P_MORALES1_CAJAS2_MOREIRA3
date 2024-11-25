package proyectopoo;
import java.util.ArrayList;
import proyectopoo.archivo.ManejoArchivos;

public class Sistema {
    public static ArrayList<Usuario> usuarios;
    public static ArrayList<Espacio> espacios;
    public static ArrayList<Estudiante> estudiantes;
    public static ArrayList<Profesor> profesores;
    public static void creacionArchivos(){
        ArrayList<Usuario> usuarios = Sistema.usuarios;
        for(Usuario u: usuarios){
            String linea = u.getCodigoUnico()+"|"+u.getCedula()+"|"+u.getNombres()+"|"+u.getApellidos()+"|"+u.getUsusario()+"|"+u.getContrasena()+"|"+u.getCorreo()+"|"+u.getRol(); 
            ManejoArchivos.EscribirArchivo("Usuarios.txt", linea);
            if(u instanceof Estudiante){
                Estudiante e = (Estudiante) u;
                String linea1 = u.getCodigoUnico()+"|"+u.getCedula()+"|"+u.getNombres()+"|"+u.getApellidos()+"|"+e.getMatricula()+"|"+e.getCarrera();
                ManejoArchivos.EscribirArchivo("Estudiantes.txt", linea1);
            }
            if(u instanceof Profesor){
                Profesor p = (Profesor) u;
                String linea2 = u.getCodigoUnico()+"|"+u.getCedula()+"|"+u.getNombres()+"|"+u.getApellidos()+"|"+p.getFacultad()+"|"+p.getMaterias();
                ManejoArchivos.EscribirArchivo("Estudiantes.txt", linea2);
            }
        }
    }
}
