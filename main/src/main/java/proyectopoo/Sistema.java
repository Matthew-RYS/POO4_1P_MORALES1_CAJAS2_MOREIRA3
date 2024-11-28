package proyectopoo;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

import proyectopoo.archivo.ManejoArchivos;


public class Sistema {
    public static ArrayList<Usuario> usuarios;
    public static ArrayList<Espacio> espacios;
    public static ArrayList<Reserva> reservas;
    public static ArrayList<Estudiante> estudiantes;
    public static ArrayList<Profesor> profesores;

    public static void logIn(String usuario, String contrasena){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("Usuario.txt");
        boolean usuarioEncontrado = false;  
        String rol = "";
        String codigoUnico = "";
        for(String linea: lineas){
            String[] palabras = linea.split("\\|");
            if(palabras[4].equals(usuario) && palabras[5].equals(contrasena)){
                rol.equals(palabras[7]);
                usuarioEncontrado = true;
                codigoUnico.equals(palabras[0]);
                break;
            }
        }
        mostrarMenu(codigoUnico, rol, usuarioEncontrado);
        
            
    }
    /**
     * @param codigoUnico
     * @param rol
     * @param usuarioEncontrado
     */
    public static void mostrarMenu(String codigoUnico, String rol, boolean usuarioEncontrado){
        System.out.println("Bienvenido/a al sistema de Reservas");
        System.out.println("Elija una opcion");
        System.out.println("1. Gestionar Reserva");
        System.out.println("2. Consultar Reserva");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        sc.nextLine();
        int cantidadEspacio = 1;
        if(usuarioEncontrado){ 
            switch(rol){
                case "ESTUDIANTE":
                    if(opcion==1&&cantidadEspacio>0){
                        Estudiante e = new Estudiante(codigoUnico);
                        e.gestionarReserva();
                        cantidadEspacio--;
                        //regresar al menu
                    }
                    else if(opcion==2){
                        Estudiante e = new Estudiante(codigoUnico);
                        e.consultarReserva(Reserva.crearFecha());
                        //regresar al menu
                    }
                    break;
                case "PROFESOR":
                    if(opcion==1){
                        Profesor p = new Profesor(codigoUnico);
                        p.gestionarReserva();
                        cantidadEspacio--;
                        //regresar al menu
                    }
                    else if(opcion==2){
                        Profesor p = new Profesor(codigoUnico);
                        p.consultarReserva(Reserva.crearFecha());
                        //regresar al menu
                    }
                    break;
                case "ADMIN":
                    if(opcion==1){
                        Profesor p = new Profesor(codigoUnico);
                        p.gestionarReserva();
                        cantidadEspacio--;
                        //regresar al menu
                    }
                    else if(opcion==2){
                        Admin.consultarReserva();
                        //regresar al menu
                    }
                    break;
                default:
                    System.out.println("Inicio de sesion invalido");
        
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("RESERVAS ESPOL");
        System.out.println("Ingrese su usuario");
        String usuario = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        String contrasena = sc.nextLine();
        logIn(usuario,contrasena);
    }

}
