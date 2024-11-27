package proyectopoo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Estudiante extends Usuario{
    private String matricula;
    private String carrera;
    protected ArrayList<Reserva> reservasRealizadas;

    public Estudiante(String codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, Rol rol, String matricula, String carrera){
        super(codigoUnico, cedula, nombres, apellidos, ususario, contrasena, correo, rol);
        this.matricula=matricula;
        this.carrera=carrera;
    }


    @Override
    public Reserva gestionarReserva(Date fecha, Espacio espacio, String motivo){
        Reserva r = new Reserva(fecha, espacio, motivo, Estado.PENDIENTE);
        r.enviarCorreo();
        Sistema.reservas.add(r);
        return r;
    }
    @Override
    public void consultarReserva(Date fecha){
        for(Reserva i:Sistema.reservas){
            if(i.getFecha().equals(fecha)){
                System.out.println(i.toString());
            }
        }
    }
    public String getMatricula(){
        return matricula;
    }
    public String getCarrera(){
        return carrera;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public void setCarrera(String carrera){
        this.carrera = carrera;
    }
    
}
