package proyectopoo;
import java.util.Random;

public class Reserva {
    public String fecha;
    //public Espacio espacioDisponible;
    public char confirmacion;
    public Usuario usuario;
    public String estado;
    public int cantidadReserva;
    public String codigoReserva;
    public String motivo;
    
    public Reserva(String fecha, String estado, String codigoReserva){
        this.fecha = fecha;
        this.estado = estado;
        this.codigoReserva= codigoReserva;


    }
    
    public void cambiarEstado(String estado, String motivo){
        this.estado=estado;
        this.motivo=motivo;

    }

    private int generarCodigo(){
        Random rd= new Random();
        int codigo=rd.nextInt(9000)+1000;
        return codigo;
        
    }
    


}