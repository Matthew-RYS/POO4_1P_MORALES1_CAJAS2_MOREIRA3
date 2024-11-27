package proyectopoo;
import java.util.Date;


public class Estudiante extends Usuario{
    private String matricula;
    private String carrera;

    public Estudiante(String codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, Rol rol, String matricula, String carrera){
        super(codigoUnico, cedula, nombres, apellidos, ususario, contrasena, correo, rol);
        this.matricula=matricula;
        this.carrera=carrera;
    }


    @Override
    public Reserva gestionarReserva(Date fecha, int codigo, String motivo){
        Reserva r = new Reserva(fecha, codigo, motivo, Estado.PENDIENTE,this.codigoUnico);
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
