package proyectopoo;
import java.util.Date;

public class Admin extends Usuario{
    private String cargo;
    @Override
    public void gestionarReserva(Date fecha, Espacio espacio, String motivo){
    }
    @Override
    public void consultarReserva(Date fecha){
    }
    public void enviarCorreo(Estado estado){

    }
    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
}
