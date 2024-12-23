package proyectopoo.ReservaImplementacion;
import proyectopoo.ReservaImplementacion.archivo.*;

import java.util.ArrayList;
import java.util.Arrays;




public class Manejos {
    public static void cargarUsuarios(){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("C:\\Users\\misae\\POO4_1P_MORALES1_CAJAS2_MOREIRA3\\main\\usuarios.txt");
        for(String linea: lineas){
            System.out.println(linea);
            String[] palabras = linea.split("\\|");
            if(palabras[7].trim().equals("E")){
                Usuario e = new Estudiante(palabras[0].trim(),palabras[1].trim(),palabras[2].trim(),palabras[3].trim(),palabras[4].trim(),palabras[5].trim(),palabras[6].trim(),palabras[7].trim());
                Sistema.usuarios.add(e);    
            }
            if(palabras[7].trim().equals("P")){
                Usuario p = new Profesor(palabras[0].trim(),palabras[1].trim(),palabras[2].trim(),palabras[3].trim(),palabras[4].trim(),palabras[5].trim(),palabras[6].trim(),palabras[7].trim());
                Sistema.usuarios.add(p);
            }
            if(palabras[7].trim().equals("A")){
                Usuario a = new Admin(palabras[0].trim(),palabras[1].trim(),palabras[2].trim(),palabras[3].trim(),palabras[4].trim(),palabras[5].trim(),palabras[6].trim(),palabras[7].trim());
                Sistema.usuarios.add(a);
            }
        }
    }
    
    public static void cargarReservas(){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("C:/Users/misae/POO4_1P_MORALES1_CAJAS2_MOREIRA3/main/reservas.txt");
        for(String linea: lineas){
            System.out.println(linea);
            String[] palabras = linea.split("\\|");
            Reserva r = new Reserva(palabras[0].trim(),palabras[1].trim(), palabras[3].trim(), palabras[4].trim(), palabras[6].trim(), palabras[7]);
            Sistema.reservas.add(r);
        }

    }
    public static void cargarEspacios(){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("C:/Users/misae/POO4_1P_MORALES1_CAJAS2_MOREIRA3/main/espacios.txt");
        for(String linea: lineas){
            System.out.println(linea);
            String[] palabras = linea.split("\\|");
            Espacio e = new Espacio(palabras[0].trim(),palabras[1].trim(),palabras[2].trim(),palabras[3].trim(),palabras[4].trim(),palabras[5].trim());
            Sistema.espacios.add(e);
        }

    }
    public static void cargarEstudiantes(){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("C:/Users/misae/POO4_1P_MORALES1_CAJAS2_MOREIRA3/main/estudiantes.txt");
        for(String linea: lineas){
            System.out.println(linea);
            String[] palabras = linea.split("\\|");
            String codigoUnico = palabras[0].trim();
            String matricula = palabras[4].trim();
            String carrera = palabras[5].trim();
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
            System.out.println(linea);
            String[] palabras = linea.split("\\|");
            String codigoUnico = palabras[0].trim();
            String facultad = palabras[4].trim();
            String materia = palabras[5].trim();
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
            System.out.println(linea);
            String[] palabras = linea.split("\\|");
            String cargo = palabras[4].trim();
            String codigoUnico = palabras[0].trim();
            for(Usuario u: Sistema.usuarios){
                if(u instanceof Admin && u.getCodigoUnico().equals(codigoUnico)){
                    Admin a = (Admin) u;
                    try {
                        a.setCargo(Cargo.fromDescripcion(cargo));  
                        Sistema.administradores.add(a);  
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        
        }
    }
    public static void mostrarUsuarios(){
        for(Usuario u: Sistema.usuarios){
            System.err.println(u.toString());
        }
    }
    public static void mostrarEstudiantes(){
        for(Estudiante e: Sistema.estudiantes){
            System.err.println(e.toString());
        }
    }
    public static void mostrarProfesores(){
        for(Profesor p: Sistema.profesores){
            System.err.println(p.toString());
        }
    }
    public static void mostrarAdministradores(){
        for(Admin a: Sistema.administradores){
            System.err.println(a.toString());
        }
    }
    public static void mostrarEspacios(){
        for(Espacio e: Sistema.espacios){
            System.err.println(e.toString());
        }
    }
    public static void mostrarReservas(){
        for(Reserva r: Sistema.reservas){
            System.err.println(r.toString());
        }
    }
    
}
