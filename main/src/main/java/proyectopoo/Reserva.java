package proyectopoo;
import java.util.Random;
import java.util.ArrayList;
import java.util.Date;

public class Reserva {
    public Date fecha;
    public Espacio espacio;
    public Usuario usuario;
    public Estado estado;
    public int cantidadReserva;
    public String codigoReserva;
    public String motivo;
    
    public Reserva(Date fecha, Espacio espacio, String motivo, Estado estado){
        this.fecha = fecha;
        this.espacio = espacio;
        this.motivo = motivo;
        this.estado = estado;
    }
    public void cambiarEstado(String estado, String motivo){
        this.estado=Estado.NEGADO;
        this.motivo=motivo;

    }

    private int generarCodigo(){
        Random rd= new Random();
        int codigo=rd.nextInt(9000)+1000;
        return codigo;
        
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // public Espacio getEspacioDisponible() {
    //     return espacioDisponible;
    // }

//    public void setEspacioDisponible(Espacio espacioDisponible) {
//        this.espacioDisponible = espacioDisponible;
//    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
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
    public Espacio getEspacio() {
        return espacio;
    }
    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }


}