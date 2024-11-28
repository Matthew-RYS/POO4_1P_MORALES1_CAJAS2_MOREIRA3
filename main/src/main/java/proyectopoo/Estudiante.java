package proyectopoo;
import java.util.Date;
import java.util.Scanner;


public class Estudiante extends Usuario{
    private String matricula;
    private String carrera;

    public Estudiante(String codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, Rol rol, String matricula, String carrera){
        super(codigoUnico, cedula, nombres, apellidos, ususario, contrasena, correo, Rol.ESTUDIANTE);
        this.matricula=matricula;
        this.carrera=carrera;
    }
    public Estudiante(String codigoUnico){
        super(codigoUnico);
    }


    @Override
    public void gestionarReserva(){
        System.out.println("Nota: solo puede realizar una reservacion por dia");
        Date fecha = Reserva.crearFecha();
        for(Espacio e:Sistema.espacios){
            if(e.getPermiso() instanceof Estudiante){
                e.mostrarEspaciosDisponibles();
            }
         }
         Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el codigo del Espacio a reservar");
        int codigoEspacio = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese su motivo para reservar");
        String motivo = sc.nextLine();
        System.out.println("Desea crear su reserva? Si/No");
        String confirmacion = sc.nextLine();
        if(confirmacion.equals("Si")){
            Reserva r = new Reserva(fecha,codigoEspacio,motivo,Estado.PENDIENTE,codigoUnico);
            Sistema.reservas.add(r);
            System.out.println("Reserva Generada");
            r.enviarCorreo();
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
