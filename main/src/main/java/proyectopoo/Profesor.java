package proyectopoo;
import java.util.Date;

public class Profesor extends Usuario{
    private String facultad;
    private ArrayList<String> materias;
    public void gestionarReserva(Date fecha, Espacio espacio, String motivo){

    }
    public void consultarReserva(Date fecha){

    }
    public void enviarCorreo(String materia){

    }
    public String getFacultad(){
        return facultad;
    }
    public ArrayList<String> getMaterias{
        return materias;
    }
    public void setFacultad(String facultad){
        this.facultad = facultad;
    }
    public void setMaterias(ArrayList<String> materias){
        this.materias = materias;
    }

    
}
