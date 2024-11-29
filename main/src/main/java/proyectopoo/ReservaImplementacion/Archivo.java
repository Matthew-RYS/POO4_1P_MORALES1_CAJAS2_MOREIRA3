package proyectopoo.ReservaImplementacion;
import proyectopoo.ReservaImplementacion.archivo.*;

import java.util.ArrayList;
import java.util.Arrays;




public class Archivo {
    public static void cargarUsuarios(){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("C:\\Users\\misae\\POO4_1P_MORALES1_CAJAS2_MOREIRA3\\main\\usuarios.txt");        for(String linea: lineas){
            String[] palabras = linea.split("\\|");
            if(palabras[7].equals("E")){
                Usuario e = new Estudiante(palabras[0],palabras[1],palabras[2],palabras[3],palabras[4],palabras[5],palabras[6],palabras[7]);
                Sistema.usuarios.add(e);    
            }
            if(palabras[7].equals("P")){
                Usuario p = new Profesor(palabras[0],palabras[1],palabras[2],palabras[3],palabras[4],palabras[5],palabras[6],palabras[7]);
                Sistema.usuarios.add(p);
            }
            if(palabras[7].equals("E")){
                Usuario a = new Admin(palabras[0],palabras[1],palabras[2],palabras[3],palabras[4],palabras[5],palabras[6],palabras[7]);
                Sistema.usuarios.add(a);
            }
        }
    }
    public static void cargarReservas(){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("C:/Users/misae/POO4_1P_MORALES1_CAJAS2_MOREIRA3/main/reservas.txt");
        for(String linea: lineas){
            String[] palabras = linea.split("\\| ");
            Reserva r = new Reserva(palabras[0].trim(),palabras[1], palabras[3].trim(), palabras[4].trim(), palabras[6].trim(), palabras[7]);
            Sistema.reservas.add(r);
        }
    }
    public static void cargarEspacios(){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("C:/Users/misae/POO4_1P_MORALES1_CAJAS2_MOREIRA3/main/espacios.txt");
        for(String linea: lineas){
            String[] palabras = linea.split("\\|");
            Espacio e = new Espacio(palabras[0].trim(),palabras[1].trim(),palabras[2],palabras[3].trim(),palabras[4].trim(),palabras[5].trim());
            Sistema.espacios.add(e);
        }
    }
    public static void cargarEstudiantes(){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("C:/Users/misae/POO4_1P_MORALES1_CAJAS2_MOREIRA3/main/estudiantes.txt");
        for(String linea: lineas){
            String[] palabras = linea.split("\\| ");
            String codigoUnico = palabras[0];
            String matricula = palabras[4];
            String carrera = palabras[5];
            for(Usuario u: Sistema.usuarios){
                if(u instanceof Estudiante && u.getCodigoUnico().equals(codigoUnico)){
                    Estudiante e = (Estudiante) u;
                    e.setMatricula(matricula);
                    e.setCarrera(carrera);
                    Sistema.estudiantes.add(e);
                }
            }
        }

    }

    public static void cargarProfesores(){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("C:/Users/misae/POO4_1P_MORALES1_CAJAS2_MOREIRA3/main/profesores.txt");
        for(String linea: lineas){
            String[] palabras = linea.split("\\| ");
            String codigoUnico = palabras[0];
            String facultad = palabras[4];
            String materia = palabras[5];
            for(Usuario u: Sistema.usuarios){
                if(u instanceof Profesor && u.getCodigoUnico().equals(codigoUnico)){
                    Profesor p = (Profesor) u;
                    p.setFacultad(facultad);
                    ArrayList<String> materias = new ArrayList<>(Arrays.asList(materia.split(",")));
                    p.setMaterias(materias);
                    Sistema.profesores.add(p);
                }
            }
        }
    }

    public static void cargarAdministradores(){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("C:\\Users\\misae\\POO4_1P_MORALES1_CAJAS2_MOREIRA3\\main\\administradores.txt");
        for(String linea: lineas){
            String[] palabras = linea.split("\\| ");
            String cargo = palabras[4];
            String codigoUnico = palabras[0];
            for(Usuario u: Sistema.usuarios){
                if(u instanceof Admin && u.getCodigoUnico().equals(codigoUnico)){
                    Admin a = (Admin) u;
                    a.setCargo(Cargo.valueOf(cargo));
                    Sistema.administradores.add(a);
                }
            }
            
        }
    }
    
}
