package proyectopoo.ReservaImplementacion.archivo;

import proyectopoo.ReservaImplementacion.Estudiante;
import proyectopoo.ReservaImplementacion.Profesor;
import proyectopoo.ReservaImplementacion.Sistema;
import proyectopoo.ReservaImplementacion.Usuario;
import proyectopoo.ReservaImplementacion.Reserva;
import proyectopoo.ReservaImplementacion.Espacio;
import proyectopoo.ReservaImplementacion.Admin;

public class Archivos {
    public static void crearArchivoUsuarios(){
        for(Usuario u: Sistema.usuarios){
            String linea = u.getCodigoUnico()+"|"+u.getCedula()+"|"+u.getNombres()+"|"+u.getApellidos()+"|"+u.getUsuario()+"|"+u.getContrasena()+"|"+u.getCorreo()+"|"+u.getRol(); 
            ManejoArchivos.EscribirArchivo("\"C:\\Users\\misae\\POO4_1P_MORALES1_CAJAS2_MOREIRA3\\main\\usuarios.txt\"", linea);
            if(u instanceof Estudiante){
                Estudiante e = (Estudiante) u;
                String linea1 = u.getCodigoUnico()+"|"+u.getCedula()+"|"+u.getNombres()+"|"+u.getApellidos()+"|"+e.getMatricula()+"|"+e.getCarrera();
                ManejoArchivos.EscribirArchivo("\"C:\\Users\\misae\\POO4_1P_MORALES1_CAJAS2_MOREIRA3\\main\\estudiantes.txt\"", linea1);
            }
            if(u instanceof Profesor){
                Profesor p = (Profesor) u;
                String linea2 = u.getCodigoUnico()+"|"+u.getCedula()+"|"+u.getNombres()+"|"+u.getApellidos()+"|"+p.getFacultad()+"|"+p.getMaterias();
                ManejoArchivos.EscribirArchivo("\"C:\\Users\\misae\\POO4_1P_MORALES1_CAJAS2_MOREIRA3\\main\\profesores.txt\"", linea2);
            }
            if(u instanceof Admin){
                Admin a = (Admin) u;
                String linea2 = u.getCodigoUnico()+"|"+u.getCedula()+"|"+u.getNombres()+"|"+u.getApellidos()+"|"+a.getCargo();
                ManejoArchivos.EscribirArchivo("\"C:\\Users\\misae\\POO4_1P_MORALES1_CAJAS2_MOREIRA3\\main\\administradores.txt\"", linea2);
            }
        }
    }
    public static void crearArchivoReservas(){
        for(Reserva r: Sistema.reservas){
            String linea = r.getCodigoReserva()+"|"+r.getUsuario().getCodigoUnico()+"|"+r.getUsuario().getCedula()+"|"+r.getFecha()+"|"+r.getEspacio().getCodigoEspacio()+"|"+r.getEspacio().getTipoEspacio()+"|"+r.getEstado()+"|"+r.getMotivo(); 
            ManejoArchivos.EscribirArchivo("\"C:\\Users\\misae\\POO4_1P_MORALES1_CAJAS2_MOREIRA3\\main\\reservas.txt\"", linea);
        }
    }
    public static void crearArchivoEspacios(){
        for(Espacio e: Sistema.espacios){
            String linea = e.getCodigoEspacio()+"|"+e.getTipoEspacio()+"|"+e.getNombre()+"|"+e.getCapacidad()+"|"+e.getEstadoEspacio()+"|"+e.getPermiso();
            ManejoArchivos.EscribirArchivo("\"C:\\Users\\misae\\POO4_1P_MORALES1_CAJAS2_MOREIRA3\\main\\espacios.txt\"", linea);
        }
    }

}
    

