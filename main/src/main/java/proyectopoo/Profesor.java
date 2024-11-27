package proyectopoo;
import java.util.Date;
import java.util.ArrayList;;

public class Profesor extends Usuario{
    private String facultad;
    private ArrayList<String> materias;

    public Profesor(String codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, Rol rol, String facultad, ArrayList<String> materias){
        super(codigoUnico, cedula, nombres, apellidos, ususario, contrasena, correo, rol);
        this.facultad=facultad;
        this.materias=materias;
    }
    
    @Override
    public Reserva gestionarReserva(Date fecha, int codigo, String materia){
        Reserva r = new Reserva(fecha, codigo, materia, Estado.APROBADO, this.codigoUnico);
        r.enviarCorreo(materia);
        Sistema.reservas.add(r);
        return r;
    }
    @Override
    public void consultarReserva(Date fecha){
        for(Reserva i:Sistema.reservas){
            if(i.getFecha().equals(fecha)){
                System.out.println(i.toString());
                break;
            }
        }
    }
    public String getFacultad(){
        return facultad;
    }
    public String getMaterias(){
        return String.join(" ", materias);
    }
    public void setFacultad(String facultad){
        this.facultad = facultad;
    }
    public void setMaterias(ArrayList<String> materias){
        this.materias = materias;
    }

    
}
