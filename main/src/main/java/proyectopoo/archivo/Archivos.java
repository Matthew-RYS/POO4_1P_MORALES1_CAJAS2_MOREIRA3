package proyectopoo.archivo;

import proyectopoo.Estudiante;
import proyectopoo.Profesor;
import proyectopoo.Sistema;
import proyectopoo.Usuario;
import proyectopoo.Reserva;
import proyectopoo.Espacio;

public class Archivos {
    public static void crearArchivos(){
        for(Usuario u: Sistema.usuarios){
            String linea = u.getCodigoUnico()+"|"+u.getCedula()+"|"+u.getNombres()+"|"+u.getApellidos()+"|"+u.getUsuario()+"|"+u.getContrasena()+"|"+u.getCorreo()+"|"+u.getRol(); 
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
        for(Reserva r: Sistema.reservas){
            String linea = r.getCodigoReserva()+"|"+r.getUsuario().getCodigoUnico()+"|"+r.getUsuario().getCedula()+"|"+r.getFecha()+"|"+r.getEspacio().getCodigoEspacio()+"|"+r.getEspacio().getTipoEspacio()+"|"+r.getEstado()+"|"+r.getMotivo(); 
            ManejoArchivos.EscribirArchivo("Reservas.txt", linea);
        }
        for(Espacio e: Sistema.espacios){
            String linea = e.getCodigoEspacio()+"|"+e.getTipoEspacio()+"|"+e.getNombre()+"|"+e.getCapacidad()+"|"+e.getEstadoEspacio()+"|"+e.getPermiso().getRol();
            ManejoArchivos.EscribirArchivo("Espacios.txt", linea);
        }
    }

}