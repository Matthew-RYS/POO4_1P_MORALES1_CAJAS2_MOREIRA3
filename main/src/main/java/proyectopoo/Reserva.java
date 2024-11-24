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
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

//    public Espacio getEspacioDisponible() {
//        return espacioDisponible;
//    }

//    public void setEspacioDisponible(Espacio espacioDisponible) {
//        this.espacioDisponible = espacioDisponible;
//    }

    public char getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(char confirmacion) {
        this.confirmacion = confirmacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadReserva() {
        return cantidadReserva;
    }

    public void setCantidadReserva(int cantidadReserva) {
        this.cantidadReserva = cantidadReserva;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


}