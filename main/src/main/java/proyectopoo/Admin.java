package proyectopoo;
import java.util.Date;

public class Admin extends Usuario{
    private String cargo;

    public Admin(String codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, String rol, String cargo){
        super(codigoUnico, cedula, nombres, apellidos, ususario, contrasena, correo, rol);
        this.cargo=cargo;
    }

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
