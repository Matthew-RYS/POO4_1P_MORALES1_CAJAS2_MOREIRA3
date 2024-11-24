package proyectopoo;

public class Admin extends Usuario{
    private String cargo;
    public Estado gestionarReserva(Date fecha, Espacio espacio, String motivo){
    }
    public void consultarReserva(){

    }
    public void enviarCorreo(Estado estado){

    }
    public void getCargo(){
        return cargo;
    }
    public String setCargo(String cargo){
        this.cargo = cargo;
    }
    
}
