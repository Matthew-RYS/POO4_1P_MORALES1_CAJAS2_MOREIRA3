package proyectopoo;
import java.util.Date;
import java.util.Scanner;

public class Admin extends Usuario{
    private Cargo cargo;

    public Admin(int codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, Rol rol, Cargo cargo){
        super(codigoUnico, cedula, nombres, apellidos, ususario, contrasena, correo, rol);
        this.cargo=cargo;
    }

    @Override
    public Reserva gestionarReserva(Date fecha, int codigo, String motivo){
        System.out.println("Ingrese su decision APROBADO/NEGADO");
        Scanner sc = new Scanner(System.in);
        String decision = sc.nextLine();
        Estado e = Estado.valueOf(decision);
        Reserva r = new Reserva(e);
        r.enviarCorreo(e,motivo);
        sc.close();
        return r;   
    }
    public void consultarReserva(){
        System.out.println("Numero de reservas creadas: " + Reserva.contador);
        for(Reserva j: Sistema.reservas){
            if(j.getUsuario() instanceof Estudiante){
                Estudiante e = (Estudiante) j.getUsuario();
                System.out.println(j.getCodigoReserva()+"-"+j.getEstado()+"-"+j.getFecha()+"-"+j.getUsuario().getNombres()+j.getUsuario().getApellidos()+"-"+e.getMatricula()+"-"+Rol.ESTUDIANTE);
            }
            else if(j.getUsuario() instanceof Profesor){
                System.out.println(j.getCodigoReserva()+"-"+j.getEstado()+"-"+j.getFecha()+"-"+j.getUsuario().getNombres()+j.getUsuario().getApellidos()+"-"+j.getMotivo()+"-"+Rol.PROFESOR);
            }
        }
    }
    public void enviarCorreo(Estado estado){

    }
    public Cargo getCargo(){
        return cargo;
    }
    public void setCargo(Cargo cargo){
        this.cargo = cargo;
    }
    
}
