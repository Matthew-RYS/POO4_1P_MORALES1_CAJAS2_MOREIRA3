package proyectopoo.ReservaImplementacion;

import java.util.Scanner;

public class Admin extends Usuario{
    private Cargo cargo;

    public Admin(String codigoUnico){
        super(codigoUnico);
    }

    public Admin(String codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, Cargo cargo){
        super(codigoUnico, cedula, nombres, apellidos, ususario, contrasena, correo, Rol.ADMIN);
        this.cargo=cargo;
    }

    @Override
    public void gestionarReserva(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el codigo de la reserva a gestionar: ");
        int codigoReservaGestionar = sc.nextInt();
        sc.nextLine();
        for(Reserva r: Sistema.reservas){
            if(r.getCodigoReserva()==codigoReservaGestionar){
                System.out.println("Datos de la reserva: "); 
                r.toString();
                System.out.println("Ingrese la decision tomada APROBADO/NEGADO");
                String decision = sc.nextLine();
                Estado estado = Estado.valueOf(decision);
                System.out.println("Ingrese el motivo de su decision: ");
                String motivo = sc.nextLine();
                r.setEstado(estado);
                r.enviarCorreo(estado,motivo);
            }

        }
        sc.close();
        
    }
    @Override
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