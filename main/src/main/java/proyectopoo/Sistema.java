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

    public void logIn(String usuario, String contrasena){
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("Usuario.txt");
        boolean usuarioEncontrado = false;  
        String rol = "";
        Usuario u;
        for(String linea: lineas){
            String[] palabras = linea.split("\\|");
            if(palabras[4].equals(usuario) && palabras[5].equals(contrasena)){
                rol = palabras[7];
                usuarioEncontrado = true;
                u.setCodigoUnico(palabras[0]);
                u.setCedula(palabras[1]);
                u.setNombres(palabras[2]);
                u.setApellidos(palabras[3]);
                u.setUsusario(palabras[4]);
                u.setContrasena(palabras[5]);

                break;
            }
        }
        if(usuarioEncontrado){ 
            switch(rol){
                case "ESTUDIANTE":
                    mostrarMenuEstudiante(Us);
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
    public static void mostrarMenuEstudiante(Usuario us){
        System.out.println("Bienvenido/a al sistema de Reservas");
        System.out.println("Elija una opcion");
        System.out.println("1. Reservar");
        System.out.println("2. Consultar Reserva");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        sc.nextLine();
        int cantidadEspacio = 1;
        if(opcion==1){
            System.out.println("Ingrese el dia");
            int dia = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el mes");
            int mes = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el ano");
            int ano = sc.nextInt();
            sc.nextLine();
            @SuppressWarnings("deprecation")
            Date fecha = new Date(dia, mes, ano);

            for(Espacio e:Sistema.espacios){
                e.mostrarEspaciosDisponibles();
            }
            System.out.println("Ingrese el codigo del Espacio a reservar");
            int codigoEspacio = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese su motivo para reservar");
            String motivo = sc.nextLine();
            System.out.println("Desea crear su reserva? Si/No");
            String confirmacion = sc.nextLine();
            sc.nextLine();
            if(confirmacion.equals("Si")){
                us.gestionarReserva(fecha, codigoEspacio, motivo);
            }
            else{
            }
        }

    }
    public static void mostrarMenuProfesor(){
    }
    public static void mostrarMenuAdmin(){
    }


    public static void main(String[] args) {
    }

}
