package proyectopoo.ReservaImplementacion;
import java.util.ArrayList;
import java.util.Scanner;
import proyectopoo.ReservaImplementacion.archivo.ManejoArchivos;
public class Sistema {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();                 
    public static ArrayList<Espacio> espacios = new ArrayList<>();
    public static ArrayList<Reserva> reservas = new ArrayList<>();
    public static ArrayList<Estudiante> estudiantes;
    public static ArrayList<Profesor> profesores;

    public static void logIn(String usuario, String contrasena) {
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("C:\\Users\\misae\\POO4_1P_MORALES1_CAJAS2_MOREIRA3\\main\\usuarios.txt");   
        boolean usuarioEncontrado = false;  
        String rol = "";
        String codigoUnico = "";
    
        for (String linea : lineas) {
            String[] palabras = linea.split("\\|");
            if(usuario.equals("jperez")&&contrasena.equals("contrasena123")){
                rol = palabras[7];
                System.out.println(rol);
                usuarioEncontrado = true;
                codigoUnico = palabras[0];
                System.out.println(codigoUnico);
                break;
             }
         }
        mostrarMenu(codigoUnico, rol, usuarioEncontrado);
    }
    

    public static void mostrarMenu(String codigoUnico, String rol, boolean usuarioEncontrado) {
        try (Scanner sc = new Scanner(System.in)) {
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
                                retornar(codigoUnico).gestionarReserva();
                                break;
                        case 2:
                                retornar(codigoUnico).consultarReserva();
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
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("RESERVAS ESPOL");
        System.out.print("Ingrese su usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = sc.nextLine();
        logIn(usuario, contrasena);
    }

    public static void regresarMenuPrincipal(String codigoUnico, String rol){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDesea realizar otra acción? (Sí/No)");
        String continuar = sc.nextLine();
        if (continuar.equalsIgnoreCase("Sí")) {
            mostrarMenu(codigoUnico, rol, true);
        } else {
            System.out.println("Gracias por usar el sistema de Reservas. ¡Hasta pronto!");
        }
    }
    public static Usuario retornar(String codigoUnico){
        for(Usuario u: usuarios){
            if(u instanceof Estudiante){
                Estudiante e = (Estudiante) u;
                return e;
            }
            if(u instanceof Profesor){
                Profesor p = (Profesor) u;
                return p;
            }
            if(u instanceof Admin){
                Admin a = (Admin) u;
                return a;
            }
        }
        return null;
    }
}
