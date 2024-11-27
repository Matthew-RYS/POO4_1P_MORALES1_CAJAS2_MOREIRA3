package proyectopoo;
import java.util.ArrayList;
import java.util.Scanner;

import proyectopoo.archivo.ManejoArchivos;


public class Sistema {
    public static ArrayList<Usuario> usuarios;
    public static ArrayList<Espacio> espacios;
    public static ArrayList<Reserva> reservas;
    public static ArrayList<Estudiante> estudiantes;
    public static ArrayList<Profesor> profesores;

    public void logIn(String usuario, String contrasena){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("Usuario.txt");
        boolean usuarioEncontrado = false;  
        String rol = "";
        for(String linea: lineas){
            String[] palabras = linea.split("\\|");
            if(palabras[4].equals(usuario) && palabras[5].equals(contrasena)){
                rol = palabras[7];
                usuarioEncontrado = true;
                break;
            }
        }
        if(usuarioEncontrado){ 
            switch(rol){
                case "ESTUDIANTE":
                    mostrarMenuEstudiante();
                    break;
                case "PROFESOR":
                    mostrarMenuProfesor();
                    break;
                case "ADMIN":
                    mostrarMenuAdmin();
                    break;
                default:
                    System.out.println("Inicio de sesion invalido");
        
            }
        }
        
            
    }
    public static void mostrarMenuEstudiante(){
        System.out.println("Bienvenido/a al sistema de Reservas");
        System.out.println("Elija una opcion");
        System.out.println("1. Reservar");
        System.out.println("2. Consultar Reserva");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        sc.nextLine();
        int cantidadEspacio = 1;
        if(opcion==1){
        }

    }
    public static void mostrarMenuProfesor(){
    }
    public static void mostrarMenuAdmin(){
    }


    public static void main(String[] args) {
    }

}
