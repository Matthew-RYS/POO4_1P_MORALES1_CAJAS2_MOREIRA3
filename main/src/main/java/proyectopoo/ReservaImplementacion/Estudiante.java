package proyectopoo.ReservaImplementacion;
import java.util.Date;
import java.util.Scanner;


public class Estudiante extends Usuario{
    private String matricula;
    private String carrera;

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

    @Override
    public String toString() {
        return super.toString()+
               " Matricula: "+this.matricula+
               " Carrera: "+this.carrera;
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
        System.out.println("Espacios Disponibles: ");
        for(Espacio e:Sistema.espacios){
            if(e.getPermiso().equals(Rol.ESTUDIANTE)){
                e.mostrarEspaciosDisponibles();
            }
        }
        int cantidadReservas = justOne(fecha);
        if(cantidadReservas==1){
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
                for(Admin a: Sistema.administradores){
                    r.enviarCorreo(a.getCorreo());
                }
            }
            else{
                System.out.println("Reserva cancelada");
            }
            String rol = "E";
            Sistema.regresarMenuPrincipal(this.codigoUnico,rol);
        }
        else if(cantidadReservas==2){
            System.out.println("Ya no puede realizar mas reservas para esa fecha");
        }
    }
    public int justOne(Date fecha){
        for(Reserva r: Sistema.reservas){
            if(r.getUsuario().getCodigoUnico().trim().equals(this.codigoUnico.trim())&&r.getFecha().equals(fecha)){
                return 2;
            }
            else if(r.getUsuario().getCodigoUnico().trim().equals(this.codigoUnico.trim())&&!r.getFecha().equals(fecha)){
                return 1;
            }
        }
        return 0;
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