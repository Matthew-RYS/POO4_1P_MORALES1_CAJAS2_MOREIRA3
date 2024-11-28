package proyectopoo.ReservaImplementacion.archivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ManejoArchivos {
    public static ArrayList<String> LeeFichero(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {

            archivo = new File(nombrearchivo);
            fis = new FileInputStream(archivo); 
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8); 
            br = new BufferedReader(isr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
                System.out.println(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;
    }

    public static void EscribirArchivo(String nombreArchivo, String linea) {
        FileWriter fichero = null;
        BufferedWriter bw = null;

        try {
            fichero = new FileWriter(nombreArchivo, true); 
            bw = new BufferedWriter(fichero);
            bw.write(linea + "\n"); 
            System.out.println("Línea escrita con éxito");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
