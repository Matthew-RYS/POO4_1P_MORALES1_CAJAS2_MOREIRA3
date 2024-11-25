package proyectopoo;
import java.util.Date;
import java.util.ArrayList;


public class Profesor extends Usuario{
    private String facultad;
    private ArrayList<String> materias;
    @Override
    public void gestionarReserva(Date fecha, Espacio espacio, String motivo){

    }
    @Override
    public void consultarReserva(Date fecha){
    }
    public String getFacultad(){
        return facultad;
    }
    public String getMaterias(){
        return String.join(" ", materias);
    }
    public void setFacultad(String facultad){
        this.facultad = facultad;
    }
    public void setMaterias(ArrayList<String> materias){
        this.materias = materias;
    }

    
}
