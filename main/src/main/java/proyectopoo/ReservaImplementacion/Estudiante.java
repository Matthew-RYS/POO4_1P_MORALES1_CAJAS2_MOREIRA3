package proyectopoo.ReservaImplementacion;
import java.util.Date;
import java.util.Scanner;


public class Estudiante extends Usuario{
    private String matricula;
    private String carrera;
    public int cantidadReservas=1;

    public Estudiante(String codigoUnico, String cedula, String nombres, String apellidos, String usuario, String contrasena, String correo, String rol){
        super(codigoUnico, cedula, nombres, apellidos, usuario, contrasena, correo, rol);
    }

    public Estudiante(String codigoUnico, String cedula, String nombres, String apellidos, String usuario, String contrasena, String correo, String matricula, String carrera){
        super(codigoUnico, cedula, nombres, apellidos, usuario, contrasena, correo, Rol.ESTUDIANTE);
        this.matricula=matricula;
        this.carrera=carrera;
    }
    public Estudiante(String codigoUnico){
        super(codigoUnico);
    }

    public void consultarReserva(){
        Date fecha = Reserva.crearFecha();
        for(Reserva i:Sistema.reservas){
            if(i.getFecha().equals(fecha)){
                System.out.println(i.toString());
            }
        }
        System.err.println("-------------------");
        Sistema.regresarMenuPrincipal(this.codigoUnico,"E");
    }


    @Override
    public void gestionarReserva(){
        System.out.println("Nota: solo puede realizar una reservacion por fecha");
        Date fecha = Reserva.crearFecha();
        for(Espacio e:Sistema.espacios){
            if(e.getPermiso().equals(Rol.ESTUDIANTE)){
                e.mostrarEspaciosDisponibles();
            }
        }
        justOne(fecha);
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
        else{
            System.out.println("Reserva cancelada");
        }
        String rol = "E";
        Sistema.regresarMenuPrincipal(this.codigoUnico,rol);
    }
    public void justOne(Date fecha){
        for(Reserva r: Sistema.reservas){
            if(r.getUsuario().getCodigoUnico().equals(this.codigoUnico)&&!r.getFecha().equals(fecha)){
                this.cantidadReservas=1;
            }
            else{
                this.cantidadReservas=0;
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
    public int getCantidadReservas() {
        return cantidadReservas;
    }
    
}