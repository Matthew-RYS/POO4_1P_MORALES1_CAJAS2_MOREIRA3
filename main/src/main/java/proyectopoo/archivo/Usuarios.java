package proyectopoo.archivo;

public class Usuarios {
    public static void main(String[] arg) {
        Archivos.EscribirArchivo("archivosalida.txt","Hola!");
        Archivos.EscribirArchivo("archivosalida.txt","Adios!");
        Archivos.EscribirArchivo("archivosalida.txt","NUevo!");
        Archivos.LeeFichero("archivosalida.txt");
  
        
        
    }  
}
