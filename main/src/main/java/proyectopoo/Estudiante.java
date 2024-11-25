package proyectopoo;
import java.util.Date;

public class Estudiante extends Usuario{
    private String matricula;
    private String carrera;
    @Override
    public void gestionarReserva(Date fecha, Espacio espacio, String motivo){ 

    }
    public void enviarCorreo(){

    }
    @Override
    public void consultarReserva(Date fecha){

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
