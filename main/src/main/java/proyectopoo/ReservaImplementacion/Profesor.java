package proyectopoo.ReservaImplementacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;;

public class Profesor extends Usuario{
    private String facultad;
    private ArrayList<String> materias;

    public Profesor(String codigoUnico, String cedula, String nombres, String apellidos, String usuario, String contrasena, String correo, String rol){
        super(codigoUnico, cedula, nombres, apellidos, usuario, contrasena, correo, rol);
        this.materias = new ArrayList<>();
    }

    public Profesor(String codigoUnico, String cedula, String nombres, String apellidos, String ususario, String contrasena, String correo, String facultad, ArrayList<String> materias){
        super(codigoUnico, cedula, nombres, apellidos, ususario, contrasena, correo, Rol.PROFESOR);
        this.facultad=facultad;
        this.materias=materias;
    }
    public Profesor(String codigoUnico){
        super(codigoUnico);
    }

    @Override
    public String toString() {
        return super.toString()+
               " Facultad: "+this.facultad+
               " Materias: "+this.materias.toString();
    }

    public void consultarReserva(Date fecha){
        for(Reserva i:Sistema.reservas){
            if(i.getFecha().equals(fecha)){
                System.out.println(i.toString());
            }
        }
        Sistema.regresarMenuPrincipal(this.codigoUnico,"P");
    }

    @Override
    public void gestionarReserva(){
        Scanner sc = new Scanner(System.in);
        Date fecha = Reserva.crearFecha();
        for(Espacio e:Sistema.espacios){
            if(e.getPermiso().equals(Rol.PROFESOR)){
                e.mostrarEspaciosDisponibles();
            }
        }
        System.out.println("Ingrese el codigo del Espacio a reservar");
        int codigoEspacio = sc.nextInt();
        sc.nextLine();
        materiasToString();
        System.out.println("Ingrese la materia para la reserva");
        String materia = sc.nextLine();
        System.out.println("Desea crear su reserva? Si/No");
        String confirmacion = sc.nextLine();
        if(confirmacion.equals("Si")){
            Reserva r = new Reserva(fecha,codigoEspacio,materia,codigoUnico);
            Sistema.reservas.add(r);
            System.out.println("Reserva Generada");
            for(Admin a: Sistema.administradores){                    
                r.enviarCorreo(a.getCorreo());
            }
        }
        else if(confirmacion.equals("No")){
            System.err.println("Reserva cancelada");
        }
        String rol = "P";
        Sistema.regresarMenuPrincipal(this.codigoUnico, rol);
    }
    public String getFacultad(){
        return facultad;
    }
    public String getMaterias(){
        return String.join(",", materias);
    }
    public void setFacultad(String facultad){
        this.facultad = facultad;
    }
    public void setMaterias(ArrayList<String> materias){
        this.materias = materias;
    }
    public String materiasToString(){
        return String.join("//|", materias);
    }

    
}