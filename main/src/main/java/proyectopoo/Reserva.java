package proyectopoo;

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


}