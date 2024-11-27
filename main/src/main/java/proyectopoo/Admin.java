package proyectopoo;
import java.util.Date;
import java.util.Scanner;

public class Admin extends Usuario{
    private String cargo;

    public Admin(String codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, Rol rol, String cargo){
        super(codigoUnico, cedula, nombres, apellidos, ususario, contrasena, correo, rol);
        this.cargo=cargo;
    }

    @Override
    public Reserva gestionarReserva(Date fecha, Espacio espacio, String motivo){
        System.out.println("Ingrese su decision APROBADO/NEGADO");
        Scanner sc = new Scanner(System.in);
        String decision = sc.nextLine();
        Estado e = Estado.valueOf(decision);
        Reserva r = new Reserva(e);
        r.enviarCorreo(e,motivo);
        sc.close();
        return r;
        
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
