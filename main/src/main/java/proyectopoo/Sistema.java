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

    public static void logIn(String usuario, String contrasena) {
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("Usuario.txt");
        if (lineas.isEmpty()) {
            System.out.println("No se encontraron líneas en el archivo. Verifica que el archivo no esté vacío.");
            return;
        }
    
        boolean usuarioEncontrado = false;  
        String rol = "";
        String codigoUnico = "";
    
        for (String linea : lineas) {
            String[] palabras = linea.split("\\|");
            if (palabras[4].equals(usuario) && palabras[5].equals(contrasena)) {
                rol = palabras[7];
                usuarioEncontrado = true;
                codigoUnico = palabras[0];
                break;
            }
        }
        mostrarMenu(codigoUnico, rol, usuarioEncontrado);
    }
    

    public static void mostrarMenu(String codigoUnico, String rol, boolean usuarioEncontrado) {
        Scanner sc = new Scanner(System.in);
        int cantidadEspacio = 1;

        if (usuarioEncontrado) {
            boolean continuar = true;
            while (continuar) {
                System.out.println("\nBienvenido/a al sistema de Reservas");
                System.out.println("Elija una opción:");
                System.out.println("1. Gestionar Reserva");
                System.out.println("2. Consultar Reserva");
                System.out.println("3. Salir");

                int opcion = sc.nextInt();
                sc.nextLine(); 

                switch (opcion) {
                    case 1:
                        if (cantidadEspacio > 0) {
                            switch (rol) { 
                                case "E":
                                    Estudiante e = new Estudiante(codigoUnico);
                                    e.gestionarReserva();
                                    break;
                                case "P":
                                case "A":
                                    Profesor p = new Profesor(codigoUnico);
                                    p.gestionarReserva();
                                    break;
                            }
                            cantidadEspacio--;
                        } else {
                            System.out.println("No hay más espacios disponibles para reservas.");
                        }
                        break;
                    case 2:
                        switch (rol) {
                            case "E":
                                Estudiante e = new Estudiante(codigoUnico);
                                e.consultarReserva(Reserva.crearFecha());
                                break;
                            case "P":
                                Profesor p = new Profesor(codigoUnico);
                                p.consultarReserva(Reserva.crearFecha());
                                break;
                            case "A":
                                Admin.consultarReserva();
                                break;
                        }
                        break;
                    case 3:
                        continuar = false;
                        System.out.println("Gracias por usar el sistema de Reservas. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            }
        } else {
            System.out.println("Inicio de sesión inválido. Por favor, revise sus credenciales.");
        }
        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("RESERVAS ESPOL");
        System.out.print("Ingrese su usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = sc.nextLine();
        logIn(usuario, contrasena);
        sc.close();
    }
}

